package com.karzek.planner.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.karzek.planner.PlannerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    fun provideApplicationContext(application: PlannerApplication): Context = application.applicationContext

    @Singleton
    @Provides fun provideAppSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)
    }

    @Singleton
    @Provides fun provideAppEncryptedSharedPreferences(context: Context): EncryptedSharedPreferences {
        val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        return EncryptedSharedPreferences.create(
            ENCRYPTED_SHARED_PREFERENCES_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ) as EncryptedSharedPreferences
    }

    private const val SHARED_PREFERENCES_NAME = "planner_shared_preferences"
    private const val ENCRYPTED_SHARED_PREFERENCES_NAME = "planner_encrypted_shared_preferences"
}