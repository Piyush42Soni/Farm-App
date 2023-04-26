# FarmApp


<div align="center"> 

<img src="https://media.discordapp.net/attachments/980479966389096460/1100773809415528538/logo_png.png" width="250" />

[![Python 3.10](https://img.shields.io/badge/python-3.10-blue.svg)](https://www.python.org/downloads/release/python-3100/)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![TensorFlow](https://img.shields.io/badge/TensorFlow-%23FF6F00.svg?style=for-the-badge&logo=TensorFlow&logoColor=white)
![Figma](https://img.shields.io/badge/figma-%23F24E1E.svg?style=for-the-badge&logo=figma&logoColor=white)


A powerful mobile application that is used to predict the suitable crop for an area based on the land and weather conditions.
Written in Python 3.10 using and uses the tensorflow, tensorflow decision forests and scikit learn libraries and uses a tensorflow-lite model in the app 
</div>

## Algorithms Used

We have done a comparitive study of three algorithms in this project:

1. ANN (Artificial Neural Network)
1. Random Forest (with optimizations)
1. Logistic Regression


## Dataset

We get our training data from information in the dataset
that is provided to the best of ICAR's knowledge. The below data
can be used publicly in all public and private undertakings.
It has 7 features like N, P, K, pH etc. used to classify 22 crops 

## Exporting the Model

The app uses a DL model which is then exported into a TFLite Model, which is a form that can be embedded into the application

## App

The android app is written in Kotlin using Android Studio with the design for the UI done in Figma
<div align="center"> 
<img src="https://media.discordapp.net/attachments/980479966389096460/1100773808606036018/image.png" width="250" />
<img src="https://media.discordapp.net/attachments/980479966389096460/1100773809096757258/image.png" width="250" />
</div> 

### App Design

The app is built to be a light-weight, accurate yet easy-to-use.
It also provides information about the crop so that Farmers can make more of the application

## Contributing/Running the project locally

The application can be downloaded from the releases section 

Clone the repository:

```bash
$ git clone https://github.com/Piyush42Soni/OS_project.git
```

Install the requirements:

```bash
$ pip install -r requirements.txt
```

From here on you can run, test or update the various models based on the dataset.




