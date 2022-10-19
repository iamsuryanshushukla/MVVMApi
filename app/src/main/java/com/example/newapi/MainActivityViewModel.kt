package com.example.newapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {


    lateinit var recyclerListLiveData:MutableLiveData<ApiModel>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclereListObserver():MutableLiveData<ApiModel>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroSevice::class.java)
            val response = retroInstance.getDatafromApi()
            recyclerListLiveData.postValue(response)
        }
    }
}