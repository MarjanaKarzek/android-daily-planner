package com.karzek.core.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkingModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().disableHtmlEscaping().create()
    }

}
