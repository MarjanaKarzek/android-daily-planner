package com.karzek.daily.di.weather

import com.karzek.authorization.domain.session.ISessionManager
import com.karzek.authorization.domain.session.model.Session.Authorised
import com.karzek.core.di.NetworkingModule
import com.karzek.daily.http.weather.IWeatherApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkingModule::class])
class WeatherApiModule {

    @Singleton
    @Provides
    fun providesWeatherApiService(
        okHttpClientBuilder: OkHttpClient.Builder,
        sessionManager: ISessionManager
    ): IWeatherApiService {
        val okHttpClient = okHttpClientBuilder
            .addInterceptor { chain ->
                val request = chain.request()
                val session = (sessionManager.getSession() as? Authorised)
                val headerBuilder = request.newBuilder()

                headerBuilder.addHeader(WEATHER_API_KEY_HEADER, session?.weatherApiToken ?: "")
                chain.proceed(headerBuilder.build())
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(IWeatherApiService::class.java)
    }

    companion object {
        private const val WEATHER_BASE_URL = "https://api.weatherbit.io/v2.0/"
        private const val WEATHER_API_KEY_HEADER = "key"
    }

}