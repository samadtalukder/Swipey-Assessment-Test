# Swipey-Assessment-Test
The repository has contains the Swipey Assessment Test, where an Android project is created and implement their task

## Demo
<img src="/Swipey-Assessment-Test.gif" align="top" width="25%"/>

### Built With

* Android Studio 
* Build gradle 7.2.0
* Android SDK 32
* Kotlin Version 1.6.21

## Language

* Kotlin

## Libraries Used

* AndroidX
* LiveData
* ViewModel
* LifeCycle
* Navigation UI
* Retrofit2
* OkHttp3
* Gson
* Hilt
* Glide


### Directory Structure

The following is a high level overview of relevant files and folders.

```
Swipey Assessment Test/
├── app/
│   └── src/     
│       └── main/
│           ├── java/com/samad_talukder/swipeyassessmenttest
│           │	├── app
│           │	│	└── WeathersApp.kt
│           │	├── data
│           │	│ 	├── api
│           │	│	├── datasource
│           │	│	├── inteceptor
│           │	│	├── models
│           │	│	├── provider
│           │	│	└── repository
│           │	├── di
│           │	│ 	├── ApiModule.kt
│           │	│	├── AppModule.kt
│           │	│	├── DataSourceModule.kt
│           │	│	├── RepositoryModule.kt
│           │	│	└── UseCaseModule.kt
│           │	├── domain
│           │   │   └── usecase 
│           │	├── features
│           │	│	└── main 
│           │	│	    └── viewmodel
│           │	└── utils
│           │	 	└── ...
│           ├── res/
│           └── AndroidManifest.xml
├── gradle/ 
│   └── wrapper/      
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── README.md
├── build.gradle
├── gradle.properties
└── settings.gradle
```
