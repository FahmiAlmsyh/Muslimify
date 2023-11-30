package com.fahmi.muslimpedia.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fahmi.muslimpedia.data.model.ApiResponse
import com.fahmi.muslimpedia.data.repository.NewsRepository

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
    val commonMuslimNews: LiveData<ApiResponse> = repository.commonMuslimNews
    val aboutAlQuranNews: LiveData<ApiResponse> = repository.aboutAlQuranNews
    val alJazeeraNews: LiveData<ApiResponse> = repository.alJazeeraNews
    val warningForMuslimNews: LiveData<ApiResponse> = repository.warningForMuslimNews
    val searchNews: LiveData<ApiResponse> = repository.searchNews
    val isLoading: LiveData<Boolean> = repository.isLoading

    fun getCommonMuslimNews() {
        repository.getCommonMuslimNews()
    }

    fun getAboutAlQuranNews(){
        repository.getAboutAlQuranNews()
    }

    fun getAlJazeeraNews(){
        repository.getAlJazeeraNews()
    }

    fun getWarningForMuslimNews() {
        repository.getWarningForMuslim()
    }

    fun getSearchNews(q: String) {
        repository.getSearchNews(q)
    }

}