# Machine Learning Model

##  1. Project Domain

The project domain chosen for this machine learning project is Environment with the title **Image Classification: Recycling Waste Image Classification Using Convolutional Neural Network (CNN) Algorithm.**

## 2. Background

In recent years, the global waste volume has surged, turning waste management into a pressing global issue. According to the Ministry of Environment and Forestry (KLHK) via the SIPSN website at the close of 2022, national waste production soared to 34.4 million tons, up from 28.6 million tons in 2021 [1]. Furthermore, in 2022, it was disclosed that 17.75% of the total national waste, roughly 6.1 million tons, consisted of plastic waste [1]. This spike in waste, coupled with society's ineffectiveness in waste management, poses significant environmental and public welfare risks. Notably, multiple international reports designate Indonesia as one of the world's top producers of food and plastic waste [2].

<div align="center">
  <img src="https://drive.google.com/uc?id=1OL1WBYhV7t3rriE0DBgwJVvAevG4JQ8U" alt="Recycled Waste Model Prediction Introduction">
  <p>Figure 1. Recycled Waste Model Prediction Introduction.</p>
</div>

Recycling stands as a pivotal effort in curbing national waste levels. By repurposing waste, it can be transformed into valuable new products. However, recycling faces challenges in accurately categorizing diverse waste types and often encounters contamination issues due to public unawareness of proper waste sorting techniques [3].  

Human limitations in identifying various recyclable waste types and the market's abundance of diverse waste shapes complicate accurate classification. Thus, leveraging digital image processing techniques becomes imperative to aid the public in precisely identifying recyclable waste types.  

The Convolutional Neural Network (CNN) algorithm presents a viable solution for object identification, particularly recyclable waste. This algorithm, widely used in diverse domains like medical image and vehicle recognition, has consistently delivered results with over 70% accuracy [4]. Implementing the CNN algorithm for recyclable waste identification holds great promise and signifies a significant stride forward.

The development of technological solutions is increasingly crucial in tackling escalating waste management challenges. A promising approach lies in developing a machine learning model using the CNN algorithm. This innovative strategy is poised to drive public engagement in recycling practices, contributing positively to environmental cleanliness endeavors and mitigating the adverse impacts of waste accumulation.

## 3. Business Understanding

### 3.1. Overview

The global increase in waste production, particularly in Indonesia, has elevated waste management to a critical global concern. The Ministry of Environment and Forestry's (KLHK) data reveals a significant rise in national waste generation, with plastic waste constituting a substantial portion. This surge in waste, coupled with societal challenges in effective waste management, underscores the urgent need for innovative solutions to address waste-related environmental and public health risks.

### 3.2. Challenges

1. **Rising Waste Volumes**: The national waste volume has surged from 28.6 million tons in 2021 to 34.4 million tons in 2022, highlighting the escalating waste management challenge.
2. **Plastic Waste Concerns**: Plastic waste accounts for approximately 17.75% of the total national waste, amounting to around 6.1 million tons, indicating the pressing need to address plastic waste management.
3. **Contamination Issues**: Ineffective waste sorting methods contribute to waste contamination, rendering recyclable materials unusable and hindering recycling efforts.
4. **Limited Waste Classification**: The diverse nature and shapes of recyclable waste present challenges in accurately identifying and classifying waste types, impeding efficient recycling processes.

### 3.3. Problem Statements

Based on the background that sets the scope of discussion, the specific problem that can be addressed through this project is: How can a machine learning model classify recycling waste images?

### 3.4. Goals

The purpose of this project is to develop a machine learning model that can be used to classify recycling waste images, including plastic, paper, metal, glass, and organic waste categories.

### 3.5. Solution Statements

Utilize the Convolutional Neural Network (CNN) algorithm, known for its effectiveness in image recognition tasks, to develop a machine learning model capable of accurately identifying and classifying recyclable waste types. The model will be trained on a diverse dataset of waste images with InceptionV3 architecture to ensure robustness and accuracy in waste classification.

InceptionV3 is a Convolutional Neural Network (CNN) architecture developed by Google's artificial intelligence that enables object detection and image analysis [5]. This architecture is formed using symmetric and asymmetric building blocks that include convolutional layers, average pooling, max pooling, concatenations, dropouts, and fully connected layers [6]. In its application, batch normalization is extensively performed throughout the model and applied to activation inputs. Then, the Loss is calculated using Softmax. An illustration of the Inception V3 architecture can be seen in the following image:

<div align="center">
  <img src="https://drive.google.com/uc?id=19npauAGgz7bEY4fOK45-dH5qkIISN6KC" alt="Illustration of InceptionV3 Architecture">
  <p>Figure 2. Illustration of InceptionV3 Architecture.</p>
</div>

## 4. Library Information

The Import Library stage involves several crucial steps to prepare the Python environment for data processing and machine learning tasks. First, it ensures that the necessary libraries are installed and updated, such as keras-preprocessing for data preprocessing in Keras. Next, it imports matplotlib for data visualization, Google Colab's drive module for data loading from Google Drive, and OS for file system operations. TensorFlow is imported for machine learning model deployment and building, while pathlib helps manage file paths. The code also imports Keras for high-level neural network modeling and training, including various modules for model construction, optimization, and evaluation. Additionally, it imports tools for image data preprocessing, callback functions for model training monitoring, and evaluation metrics for model performance assessment. Overall, the Import Library stage sets up the necessary tools and functionalities required for data manipulation, model development, and evaluation in a machine learning project.

## 5. Data Loading

During the Data Loading stage, the main steps involve accessing and loading the dataset for further analysis. The process begins by mounting Google Drive in the Colab environment, which allows access to files and directories stored on Google Drive. Next, the base directory path `base_dir` is defined to indicate the dataset's location on Google Drive. A list of labels is created to represent different types of garbage in the dataset. Then, the number of classes or types of garbage is calculated and stored in the variable `num_classes`. Subsequently, each label is iterated through to build the directory path for each garbage class and check the number of images (garbage samples) associated with each class. Data loading also involves reading and processing images, which are then displayed in a plot using matplotlib to provide visualization of the dataset's content and distribution. This stage is crucial for understanding the dataset's structure, the number of samples per class, and the types of garbage present, which are then used for training and testing the garbage classification model.

## 6. Image Preprocessing

Image preprocessing is crucial for preparing our data before feeding it into the machine learning model for training. Here are the steps I took for image preprocessing in this project:

### 6.1. Define Variables

Firstly, I defined variables used in image processing and model training, including IMG_WIDTH, IMG_HEIGHT, and BATCH_SIZE.

### 6.2. Data Augmentation

To generate a more diverse training dataset and improve the model's generalization ability, I employed data augmentation techniques using the ImageDataGenerator class from TensorFlow. This includes transformations such as rotation, width and height shifts, shear, zoom, and horizontal and vertical flips.

### 6.3. Generate Training and Validation Data Generators

I created data generators for both training and validation datasets using the flow_from_directory method. These generators automatically load images from the specified directory, preprocess them according to the defined parameters, and yield batches of augmented images during model training.

## 7. Callback Implementation

Implementing callbacks is essential for monitoring and controlling the training process of our machine learning model. Here's how I implemented callbacks for this project:

### 7.1. Custom Callback for Early Stopping

I created a custom callback named myCallback to provide notifications during model training and stop the training process if certain conditions are met. In this case, the conditions set are to achieve an accuracy of 95% or above and a loss of 2 or below.

### 7.2. Reduce Learning Rate on Plateau

Additionally, I implemented a callback to automatically reduce the learning rate when a monitored metric (in this case, val_loss) shows no improvement after a certain number of epochs. This helps prevent the model from getting stuck in local minima and aids in convergence.

By incorporating these callbacks into my model training process, I ensure better control, early stopping if desired accuracy and loss conditions are met, and adaptive adjustment of the learning rate for improved training efficiency.

## 8. Building Architecture

This step is crucial in achieving accurate and reliable predictions. Here's how I constructed and modeled the InceptionV3 architecture for this project:

### 8.1.Constructing InceptionV3

Firstly, I constructed the InceptionV3 model, which serves as the base architecture for the model.

### 8.2. Modelling

Next, I built and compiled a new model, inceptV3_model, based on the pre-trained InceptionV3 model by adding additional layers to customize it for our specific task.

By following these steps, I have constructed and modeled the InceptionV3 architecture, tailored to this specific project requirements. This architecture serves as the backbone for the machine learning model, enabling us to train and evaluate its performance effectively.

## 9. Evaluation

Evaluation of a machine learning model is crucial to assess its performance and ensure its effectiveness in real-world applications. Here are the steps I undertook to evaluate the performance of this machine learning model:

### 9.1. Visualizing Model Performance

To gain insights into the model's performance during training, I visualized its accuracy and loss over epochs. This plot helps in understanding how well the model learns from the training data and generalizes it to unseen data. v results of visualizing the model evaluation, and plotting its performance:

<div align="center">
  <img src="https://drive.google.com/uc?id=1MjE3iyV6o9gAvwpyAZJTGpU0LVABbuiq " alt="The Results of Model Evaluation Plotting">
  <p>Figure 3. The Results of Model Evaluation Plotting.</p>
</div>

Based on Figure 3., it can be observed that the performance evaluation of the model shows positive indications with a trend of increasing accuracy values and decreasing loss values during the training and validation periods.

### 9.2. Confusion Matrix

Next, I generated a confusion matrix to evaluate the model's performance in classifying different waste types. This matrix provides insights into the model's ability to correctly classify instances and identify areas of confusion. Here is the result of the Confusion Matrix plot:

<div align="center">
  <img src="https://drive.google.com/uc?id=1xQFLWQpXioiwQRBESBb1l8um9jDBmpv3 " alt="Confusion Matrix Plotting Result">
  <p>Figure 4. Confusion Matrix Plotting Result.</p>
</div>

### 9.3. Classification Report

Lastly, I presented a comprehensive classification report that includes precision, recall, F1-score, and support for each waste type class. This report offers a detailed analysis of the model's performance across different classes, aiding in the assessment of its overall effectiveness. This report provides valuable insights into the model's strengths and weaknesses, guiding further improvements and optimizations. Here is the result of the Classification plot:

<div align="center">
  <img src="https://drive.google.com/uc?id=181NdJkDQsZU53tyF6XPFmXlTWn4hrG-J " alt="The Results of Model Evaluation Plotting">
  <p>Figure 5. Classification Report Plotting Result.</p>
</div>

Based on Figure 5., it can be observed that the accuracy of the previously trained model is 88% with a value of 0.88. Additionally, the evaluation results of the model's performance on each classification class for each matrix are also obtained.

## 10. Prediction

In this phase, I have crafted a seamless workflow for precise and swift predictions of image data. Initially, I have developed a versatile function responsible for reading, preprocessing, and loading images from files. This function ensures that our input data is consistently prepared and compatible with the trained neural network model. Following this, I have implemented a prediction function designed to harness the power of the trained neural network. This function efficiently processes input images through the neural network, swiftly generating predictions regarding the presence or absence of garbage within the images. Through meticulous design and implementation of these prediction functions, I have optimized this mobile application for real-time garbage classification, ensuring smooth and accurate performance in any scenario.

## 11. Deployment

In the deployment phase of the machine learning model for garbage detection, several key steps were undertaken to ensure seamless integration into the mobile application. Firstly, the model was saved in the widely supported SavedModel format, ensuring compatibility across various platforms. Subsequently, to optimize for mobile deployment, the SavedModel was converted into a TensorFlow Lite (TFLite) format, denoted as `garbage_detection.tflite`. This conversion not only facilitated efficient deployment on mobile devices but also paved the way for further optimizations. One such optimization involved quantization, a technique aimed at reducing the model's size while preserving its predictive accuracy. By quantizing the TensorFlow model, we achieved a balance between model size and computational efficiency, crucial for mobile applications. Finally, the quantized TensorFlow model was saved in the TFLite format, ready for seamless integration into the mobile application, ensuring efficient garbage detection on the go.

## 12. Conclusion

The conclusion drawn from the research on designing a machine learning model for recycling waste detection using a Convolutional Neural Network (CNN) algorithm with Inception V3 architecture is as follows:

### 12.1. Conclusion 

The CNN model with Inception V3 architecture achieved an 88% success rate in accurately classifying recycling waste, encompassing packaging waste like paper, cardboard, plastic, glass, and metal waste.

### 12.2. Suggestion

For optimal detection results, it's highly recommended to augment the dataset by increasing both the quantity and variety of objects.

## 13. Reference

[1]	“SIPSN,” Sistem Informasi Pengelolaan Sampah Nasional. https://sipsn.menlhk.go.id/sipsn/public/data/komposisi (accessed Apr. 19, 2024).

[2]	C. M. Annur, “RI Hasilkan 19 Juta Ton Timbulan Sampah pada 2022, Mayoritas Sisa Makanan (datanya beda dengan SIPSN yg sekarang),” Databoks. Accessed: Apr. 19, 2024. [Online]. Available: https://databoks.katadata.co.id/datapublish/2023/03/09/ri-hasilkan-19-juta-ton-timbulan-sampah-pada-2022-mayoritas-sisa-makanan-datanya-beda-dengan-sipsn-yg-sekarang.

[3]	A. Ibnul Rasidi, Y. A. H. Pasaribu, A. Ziqri, and F. D. Adhinata, “Klasifikasi Sampah Organik dan Non-Organik Menggunakan Convolutional Neural Network,” Jurnal Teknik Informatika dan Sistem Informasi, vol. 8, no. 1, Apr. 2022, doi: 10.28932/jutisi.v8i1.4314.

[4]	Kartiko, A. Prima Yudha, N. Dimas Aryanto, and M. Arya Farabi, “Klasifikasi Sampah di Saluran Air Menggunakan Algortima CNN,” Indonesian Journal of Data and Science, vol. 3, no. 2, pp. 72–81, Jul. 2022, doi: 10.56705/ijodas.v3i2.33.

[5]	P. D. Silitonga and R. Damanik, “Perbandingan Algoritma k-Nearest Neighbors (k-NN) dan Support Vector Machines (SVM) untuk Klasifikasi Pengenalan Citra Wajah,” Jurnal ICT : Information Communication &amp; Technology, vol. 20, no. 1, pp. 186–191, Jul. 2021, doi: 10.36054/jict-ikmi.v20i1.354.

[6]	E. E.-D. Hemdan, M. A. Shouman, and M. E. Karar, “COVIDX-Net: A Framework of Deep Learning Classifiers to Diagnose COVID-19 in X-Ray Images,” arXiv.org, Mar. 24, 2020. https://arxiv.org/abs/2003.11055
