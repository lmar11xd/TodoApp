# TodoApp


# Configuracion
## build.gradle (project)

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
    }
}

//Plugins<br>
id("com.android.library") version "8.1.1" apply false
id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false

## build.gradle (app)

//Plugins<br>
id("dagger.hilt.android.plugin")
id("com.google.devtools.ksp")
id("kotlin-kapt")

//Android Studio: File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle<br>
Gradle JDK: jbr-17

//Android<br>
compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlinOptions {
    jvmTarget = "17"
}

//dependencies<br>

//Compose<br>
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
implementation("androidx.navigation:navigation-compose:2.7.7")
implementation("androidx.compose.material:material-icons-extended:1.6.2")
implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

//Coroutines<br>
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

//Dagger - Hilt<br>
implementation("com.google.dagger:hilt-android:2.47")
kapt("androidx.hilt:hilt-compiler:1.2.0")
kapt("com.google.dagger:hilt-android-compiler:2.47")

//Room<br>
implementation("androidx.room:room-ktx:2.6.1")
implementation("androidx.room:room-runtime:2.6.1")
ksp("androidx.room:room-compiler:2.6.1")

//Kotlin extensions and Room coroutine support<br>
implementation("androidx.room:room-ktx:2.6.1")

//Retrofit<br>
implementation("com.squareup.retrofit2:retrofit:2.9.0")

//GSON<br>
implementation("com.google.code.gson:gson:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")