package com.karzek.buildsrc

object Config {
    const val minSdk = 24
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildToolsVersion = "29.0.2"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.6.1"

    object Kotlin {
        private const val version = "1.3.61"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.2.0"
        const val crypto = "androidx.security:security-crypto:1.0.0-rc01"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha1"
    }

    object Chuck {
        private const val version = "1.1.0"
        const val debug = "com.readystatesoftware.chuck:library:$version"
        const val release = "com.readystatesoftware.chuck:library-no-op:$version"
    }

    object Dagger {
        private const val version = "2.27"
        const val dagger = "com.google.dagger:dagger:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"

        object JW {
            private const val version = "0.2.0"
            const val reflect = "com.jakewharton.dagger:dagger-reflect:$version"
            const val codegen = "com.jakewharton.dagger:dagger-codegen:$version"
        }
    }

    object Gson {
        private const val version = "2.8.6"
        const val gson = "com.google.code.gson:gson:$version"
    }

    object Navigation {
        private const val version = "2.3.0-alpha05"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val test = "androidx.navigation:navigation-testing:$version"
    }

    object OkHttp {
        private const val version = "4.3.1"
        const val okHttp = "com.squareup.okhttp3:okhttp:$version"
    }

    object ReactiveX {
        object Java {
            private const val version = "2.1.1"
            const val rxJava2Android = "io.reactivex.rxjava2:rxandroid:$version"
        }

        object Kotlin {
            private const val version = "2.4.0"
            const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$version"
        }
    }

    object Retrofit {
        private const val version = "2.8.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:$version"
        const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
    }

    object Timber {
        private const val version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:${version}"
    }

    object Test {
        object Mockk {
            private const val version = "1.9.3"
            const val mockk = "io.mockk:mockk:${version}"
            const val mockkAndroid = "io.mockk:mockk-android:${version}"
        }

        object JUnit {
            private const val version = "5.6.1"
            const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${version}"
            const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${version}"
            const val junit5VintageEngine = "org.junit.vintage:junit-vintage-engine:${version}"
        }
    }
}
