# Android Mobile Application

## 1. App Description

<div align="center">
  <img src="https://drive.google.com/uc?id=1eH7rLb2GW2VJtaPZ9NN57KY4ZFMVFYVC" alt="Waste Wizard App Introduction">
  <p>Figure 1. Waste Wizard App Introduction.</p>
</div>

Waste Wizard is a mobile application that utilizes machine learning technology, particularly Convolutional Neural Network (CNN) algorithms, to detect and identify types of recyclable waste.

## 2. Objectives
It aims to assist users in proper recyclable waste sorting by providing information about the waste generated.

## 3. App Technical Features
1. Utilizing the Kotlin programming language for application development.
2. Implementing Material Design 3 for a modern, cohesive user interface experience.
3. Integrating a machine learning model using TFLite as the model prediction to detect recyclable waste.

## 4. App Development Roadmap

### 4.1. System Design
This phase focuses on creating UML diagrams, specifically Use Case Diagrams and Activity Diagrams. The Use Case Diagram outlines various interactions between users and the application, including actions like camera opening, gallery opening, prediction, and recycling waste information viewing. Meanwhile, the Activity Diagram illustrates the flow of activities within the application, including all the actions in the Use Case Diagram.

### 4.2. User Interface Design
User Interface (UI) Design involves the visual and interactive aspects of the application. Using tools like Figma, I create wireframes and high-fidelity designs to depict the layout, navigation, and interactive elements of the application. This phase focuses on crafting an intuitive and visually appealing user experience, ensuring that users can easily navigate and interact with the app's features and functionalities.

### 4.3. Application Development
The actual development of the Android application takes place in this phase. Using the Integrated Development Environment (IDE) Android Studio and the Kotlin programming language, I translate design concepts into functional code, incorporating features and integrating various functionalities. This entails constructing both the frontend and backend components of the application to ensure smooth operation and optimal performance across Android devices.

### 4.4. Integrating Machine Learning Model into The Application
Integrating the Machine Learning (ML) model into the Android application involves converting the trained model into a format compatible with mobile devices, such as TensorFlow Lite (.tflite). This process includes quantization to optimize the model's size and importing it into the Android application using Android Studio extensions. The ML model enhances the application's capabilities by enabling features like waste detection and classification.

### 4.5. Testing
Testing is a crucial phase to verify and validate the application's functionality and performance. Black Box Testing methodology assesses the application's external behavior and functions without delving into its internal implementation details. This involves conducting various tests, including functional testing, usability testing, and performance testing, to ensure that the application operates smoothly and delivers accurate results, particularly in tasks like waste classification and image scanning.

## 5. App Preview
<div align="center">
  <img src="https://drive.google.com/uc?id=1eyAIqxPYxdracfTyjnI-Ls6U_x0L3icm" alt="Waste Wizard App Preview">
  <p>Figure 2. Waste Wizard App Preview</p>
</div>

## 6. Installation

### 6.1. Downloading from Google Drive Link
1. Download the application through the following Google Drive link.
2. In the upper-right corner, tap on the three vertical dots icon (more options).
3. Select "Download" from the menu.
4. Wait for the file to be downloaded to your device.
5. After the download is complete, you can install it on your device. Once completed, you'll see the Waste Wizard app icon on your device's home screen or app drawer.

### 6.2. Granting Permissions
1. Upon opening the Waste Wizard app for the first time, you may be prompted to grant certain permissions for the app to function properly.
2. These permissions may include access to the device's camera, storage, and location (if applicable).
3. Follow the on-screen prompts to grant the necessary permissions to the Waste Wizard app.

### 6.3. Launching the Application
1. Once the Waste Wizard app is successfully installed, tap on its icon to launch the application.
2. The app will open, and you'll be greeted with the home screen, where you can access the various features and functionalities of the Waste Wizard app.

### 6.4. Initial Setup and Configuration
1. Upon launching the app for the first time, you may be prompted to complete an initial setup or configuration process.
2. This setup process may include selecting language preferences, agreeing to terms of service, and customizing app settings.
3. Follow the on-screen instructions to complete the initial setup and configuration of the Waste Wizard app.

## 7. System Requirements

### 7.1. Operating Systems
Compatible with Android Version 8.0 (Oreo) or later.

### 7.2. Device Compatibility 
The application is optimized for smartphones.

### 7.3. Storage
1. Minimum 100 MB of available storage space for app installation.
2. Additional storage space may be required for storing captured images or videos.

### 7.4. Memory (RAM)
1. Recommended minimum RAM: 2 GB.
2. Higher RAM capacity may improve app performance, especially during image processing.

### 7.5. Camera
1. The device must have a built-in camera with autofocus capability.
2. Recommended resolution: 8 MP or higher for optimal image capture.

### 7.6. Permissions
The application requires permission to access the device's camera and storage to capture and process images.

## 8. Usage

### 8.1. Downloading and Installation
1. Users can download the Waste Wizard application from the Google Drive link here.
2. After downloading, users can install the application on their mobile devices by following the on-screen instructions.

### 8.2. Accessing Core Features
1. Upon launching the Waste Wizard app, users are presented with the home screen, where they can access three core features: gallery access, camera activation, and recycling waste detection.
2. Users can navigate between these features using intuitive icons or buttons on the home screen.

### 8.3. Capturing Recycling Waste Images
1. To identify recyclable waste, users can choose the camera activation feature, which activates the device's camera within the app.
2. Users can then point the camera at the waste item they wish to identify and capture an image by tapping the shutter button.

### 8.4. Performing Recycling Waste Detection:
1. Once the image is captured, the Waste Wizard app processes it using machine learning algorithms, specifically Convolutional Neural Networks (CNN), embedded within the app.
2. The app analyzes the visual characteristics of the waste item and identifies its type, such as plastic, paper, metal, glass, or organic waste.

### 8.5. Viewing Prediction Results
1. After the analysis is complete, the app presents the prediction results to the user, indicating the specific type of recycling waste identified.
2. Users receive real-time feedback on the detected waste type, empowering them to make informed decisions about proper waste disposal and recycling practices.

### 8.6. Accessing Additional Information
1. For further information on recycling waste, users can navigate to the garbage information screen, where they can access details about waste sorting methods, recycling techniques, and more.
2. The app provides comprehensive information to educate users about environmentally friendly waste management practices.

## 9. Technologies

### 9.1. Programming Languages
**Kotlin**: Kotlin is used for developing the Android version of the application, leveraging the Android SDK for native app development.

### 9.2. UI/UX Design Tools
**Figma**: Figma is used for designing user interfaces (UI) and user experiences (UX), prototyping, and converting designs into formats that can be implemented by developers.

### 9.3. Development Frameworks
1. **TensorFlow Lite**: TensorFlow Lite is used for integrating machine learning models, particularly Convolutional Neural Networks (CNN), for recycling waste detection in real time.
2. **XML-Based Layout**: XML-Based Layout is employed to boost app performance, handle lifecycle events, and streamline development tasks within the Android environment.

### 9.4. Version Control
**Git**: Git is used for version control and collaboration among development team members, enabling efficient code management, branching, and merging.
