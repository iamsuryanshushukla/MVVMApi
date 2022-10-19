package com.example.newapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val BaseUrl = "https://api.publicapis.org/"
        fun getRetroInstance():Retrofit{
            return Retrofit.Builder().baseUrl(BaseUrl).
            addConverterFactory(GsonConverterFactory.create()).
            build()
        }
    }
}