package com.fahmi.muslimpedia.data.network

import com.fahmi.muslimpedia.data.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/everything")
    fun getCommonMuslimNews(
        @Query("q") q: String = "International News",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 10,
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<ApiResponse>

    @GET("/v2/everything")
    fun getAlQuranNews(
        @Query("q") q: String = "Islamic Education",
        @Query("language") language: String = "en"
    ): Call<ApiResponse>


    @GET("/v2/everything")
    fun getAlJazeeraNews(
        @Query("q") q: String = "Humanitarian News",
        @Query("language") language: String = "en"
    ): Call<ApiResponse>


    @GET("/v2/everything")
    fun getWarningForMuslimNews(
        @Query("q") q: String = "Inspirational Content",
        @Query("language") language: String = "en"
    ): Call<ApiResponse>


    @GET("/v2/everything")
    fun getSearchNews(
        @Query("q") q: String,
        @Query("pageSize") pageSize: Int = 19,
    ): Call<ApiResponse>


}