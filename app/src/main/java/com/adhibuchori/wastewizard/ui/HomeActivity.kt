package com.adhibuchori.wastewizard.ui

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.adhibuchori.wastewizard.R
import com.adhibuchori.wastewizard.databinding.ActivityHomeBinding
import com.adhibuchori.wastewizard.databinding.DialogDetectionResultsBinding
import com.adhibuchori.wastewizard.ml.QuantGarbageDetection
import com.adhibuchori.wastewizard.utils.WasteInformation
import com.adhibuchori.wastewizard.utils.getImageUri
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.FileNotFoundException
import java.io.IOException

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var currentImageUri: Uri? = null

    private var currentImageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpButton()
        recyclingWasteDetection()
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun showImage() {
        currentImageUri?.let { uri ->
            Log.d("Image URI", "showImage: $uri")
            binding.ivInputImage.setImageURI(currentImageUri)
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }
    }

    private fun setUpButton() {
        with(binding) {
            btnCamera.setOnClickListener {
                startCamera()
            }
            btnGallery.setOnClickListener {
                startGallery()
            }
        }
    }

    private fun recyclingWasteDetection() {
        with(binding) {
            btnScan.setOnClickListener {
                if (currentImageUri == null) {
                    Toast.makeText(
                        this@HomeActivity,
                        "Masukkan gambar dulu, yuk!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    showDetectionResults()
                }
            }
        }
    }

    private fun convertUriToBitmap() {
        currentImageUri?.let { uri ->
            Log.d("Image URI", "showImage: $uri")

            try {
                val inputStream = contentResolver.openInputStream(uri)
                val options = BitmapFactory.Options()
                val bitmap = BitmapFactory.decodeStream(inputStream, null, options)

                currentImageBitmap = bitmap

            } catch (e: FileNotFoundException) {
                Log.e("Image Conversion", "File not found: $e")
            } catch (e: IOException) {
                Log.e("Image Conversion", "Error reading image: $e")
            }
        }
    }



    private fun showDetectionResults() {
        val dialogBinding = DialogDetectionResultsBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this, R.style.DialogStyle).setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.setView(dialogBinding.root)
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        with(dialogBinding) {

            currentImageUri?.let { uri ->
                Log.d("Image URI", "showImage: $uri")
                ivInputImage.setImageURI(currentImageUri)
            }

            convertUriToBitmap()

            var tensorImage = TensorImage(DataType.FLOAT32)
            tensorImage.load(currentImageBitmap)

            val imageProcessor: ImageProcessor = ImageProcessor.Builder()
                .add(ResizeOp(299, 299, ResizeOp.ResizeMethod.BILINEAR))
                .add(NormalizeOp(0f, 255f))
                .build()

            tensorImage = imageProcessor.process(tensorImage)

            val model = QuantGarbageDetection.newInstance(this@HomeActivity)

            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 299, 299, 3), DataType.FLOAT32)
            inputFeature0.loadBuffer(tensorImage.buffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

            var maxIndex = 0
            outputFeature0.forEachIndexed { index, fl ->
                if (outputFeature0[maxIndex] < fl) {
                    maxIndex = index
                }
            }

            val labels = application.assets.open("garbage_detection_labels.txt").bufferedReader().readLines()
            val garbageTypeLabels: String = labels[maxIndex]
            tvGarbageType.text = garbageTypeLabels

            model.close()

            btnSeeMore.setOnClickListener {
                val selectedIndex = when (garbageTypeLabels) {
                    "Kertas" -> 0
                    "Kardus" -> 1
                    "Plastik" -> 2
                    "Kaca" -> 3
                    "Logam" -> 4
                    else -> 0
                }

                val sortWasteInformationArray = resources.getStringArray(R.array.data_sort_waste_information)
                val recycleWasteInformationArray = resources.getStringArray(R.array.data_recycle_waste_information)

                val sortWasteInformation = WasteInformation(
                    sortWasteInformationArray[selectedIndex],
                    recycleWasteInformationArray[selectedIndex]
                )

                val intent = Intent(this@HomeActivity, MoreInformationActivity::class.java)
                intent.putExtra("IMAGE_URI", currentImageUri.toString())
                intent.putExtra("GARBAGE_TYPE", garbageTypeLabels)
                intent.putExtra(
                    MoreInformationActivity.EXTRA_WASTE_INFORMATION,
                    sortWasteInformation
                )
                startActivity(intent)
            }

            btnOkay.setOnClickListener {
                alertDialog.dismiss()
            }
        }

        alertDialog.show()
    }
}