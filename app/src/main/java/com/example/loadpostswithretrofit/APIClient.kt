package com.example.loadpostswithretrofit

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    object SingletonConfig {

        private var retrofit: Retrofit? = null
        private const val URL_BASE = "https://jsonplaceholder.typicode.com/posts/"

        fun getRetrofit(context: Context): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}
