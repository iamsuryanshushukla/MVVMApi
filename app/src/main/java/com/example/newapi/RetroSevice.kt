package com.example.newapi

import retrofit2.http.GET

interface RetroSevice {
    @GET("entries")
    suspend fun getDatafromApi():ApiModel
}