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

    object ReactiveX {
        object Java {
            private const val version = "3.0.2"
            const val rxJava3 = "io.reactivex.rxjava3:rxjava:$version"
        }
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
