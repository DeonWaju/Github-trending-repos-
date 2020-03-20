# Github-trending-repos-
Kotlin-mvvm-dagger2-rxJava used to fetch trending repositories from github 

Prerequisites

Android studio, 
put this files in your gradle
// Support Design
    implementation "com.android.support:design:$android_support_version"

    // RecyclerView
    implementation "com.android.support:recyclerview-v7:$android_support_version"

    // Constraint Layout
    implementation "com.android.support.constraint:constraint-layout:1.1.3"

    // LiveData & ViewModel
    implementation"android.arch.lifecycle:extensions:$lifecycle_version"

    // Room
    implementation "android.arch.persistence.room:runtime:$room_version"
    kapt "android.arch.persistence.room:compiler:$room_version"

    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-moshi:$retrofit_version"

    // Dagger 2
    implementation "com.google.dagger:dagger:$dagger2_version"
    kapt "com.google.dagger:dagger-compiler:$dagger2_version"
    compileOnly "org.glassfish:javax.annotation:3.1.1"

    //Rx
    implementation "io.reactivex.rxjava2:rxjava:2.2.18"
    implementation "io.reactivex.rxjava2:rxandroid:2.1.1"
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'

Author Olarewaju Oyindamola Gideon
