package com.fahmi.muslimpedia.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fahmi.muslimpedia.data.model.ApiResponse
import com.fahmi.muslimpedia.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val _commonMuslimNews = MutableLiveData<ApiResponse>()
    val commonMuslimNews: LiveData<ApiResponse> = _commonMuslimNews

    private val _aboutAlQuranNews = MutableLiveData<ApiResponse>()
    val aboutAlQuranNews: LiveData<ApiResponse> = _aboutAlQuranNews

    private val _alJazeeraNews = MutableLiveData<ApiResponse>()
    val alJazeeraNews: LiveData<ApiResponse> = _alJazeeraNews

    private val _warningForMuslimNews = MutableLiveData<ApiResponse>()
    val warningForMuslimNews: LiveData<ApiResponse> = _warningForMuslimNews

    private val _searchNews = MutableLiveData<ApiResponse>()
    val searchNews: LiveData<ApiResponse> = _searchNews

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getCommonMuslimNews() {
        _isLoading.value = true
        ApiClient.provideApiService().getCommonMuslimNews()
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _commonMuslimNews.postValue(response.body())
                        }
                        else {
                            Log.e(
                                "Repository",
                                "onResponse: Call error with HTTP status code"
                                        + response.code()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: "
                                + t.localizedMessage)
                }

            })
    }

    fun getAboutAlQuranNews() {
        _isLoading.value = true
        ApiClient.provideApiService().getAlQuranNews()
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _aboutAlQuranNews.postValue(response.body())
                        }
                        else {
                            Log.e(
                                "Repository",
                                "onResponse: Call error with HTTP status code"
                                        + response.code()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: "
                                + t.localizedMessage)
                }

            })
    }

    fun getAlJazeeraNews() {
        _isLoading.value = true
        ApiClient.provideApiService().getAlJazeeraNews()
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _alJazeeraNews.postValue(response.body())
                        }
                        else {
                            Log.e(
                                "Repository",
                                "onResponse: Call error with HTTP status code"
                                        + response.code()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: "
                                + t.localizedMessage)
                }

            })
    }

    fun getWarningForMuslim() {
        _isLoading.value = true
        ApiClient.provideApiService().getWarningForMuslimNews()
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _warningForMuslimNews.postValue(response.body())
                        }
                        else {
                            Log.e(
                                "Repository",
                                "onResponse: Call error with HTTP status code"
                                        + response.code()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: "
                                + t.localizedMessage)
                }

            })
    }

    fun getSearchNews(q: String) {
        _isLoading.value = true
        ApiClient.provideApiService().getSearchNews(q)
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _searchNews.postValue(response.body())
                        }
                        else {
                            Log.e(
                                "Repository",
                                "onResponse: Call error with HTTP status code"
                                        + response.code()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: "
                                + t.localizedMessage)
                }

            })
    }

}