package com.adhibuchori.wastewizard.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhibuchori.wastewizard.databinding.ActivityMoreInformationBinding
import com.adhibuchori.wastewizard.utils.WasteInformation


class MoreInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoreInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        receiveWasteInformation()
    }

    private fun setToolbar() {
        with(binding) {
            toolbar.ivToolbarIcon.setOnClickListener {
                val intent = Intent(this@MoreInformationActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun receiveWasteInformation() {

        val wasteInformation = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_WASTE_INFORMATION, WasteInformation::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_WASTE_INFORMATION)
        }

        if (wasteInformation != null) {
            with(binding) {
                tvHowToSortWasteInformation.text = wasteInformation.sortWaste
                tvHowToRecycleWasteInformation.text = wasteInformation.recycleWaste
            }
        }

        val imageUriString = intent.getStringExtra("IMAGE_URI")
        val garbageType = intent.getStringExtra("GARBAGE_TYPE")

        val imageUri = Uri.parse(imageUriString)

        with(binding) {
            ivInputImage.setImageURI(imageUri)
            tvGarbageType.text = garbageType
        }
    }

    companion object {
        const val EXTRA_WASTE_INFORMATION = "extra_waste_information"
    }
}