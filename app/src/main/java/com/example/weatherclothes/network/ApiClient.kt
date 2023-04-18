package com.example.weatherclothes.network


import com.example.weatherclothes.BuildConfig
import okhttp3.Call
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class ApiClient {
    private val okHttpClient = OkHttpClient()

    fun getRequest(path: String, city: String): Call{
        val request = Request.Builder()
            .url(getHttpUrl(path, city))
            .method("GET", null)
            .build()

        return okHttpClient.newCall(request)
    }

    private fun getHttpUrl(path: String, city: String): HttpUrl {
        return HttpUrl.Builder()
            .scheme(HTTP)
            .host(BuildConfig.HOST)
            .addPathSegment(VERSION)
            .addPathSegment(path)
            .addQueryParameter(KEY, BuildConfig.API_KEY)
            .addQueryParameter(CITY, city)
            .build()
    }

    private companion object{
        const val HTTP = "https"
        const val KEY = "key"
        const val CITY = "q"
        const val VERSION = "v1"
    }
}