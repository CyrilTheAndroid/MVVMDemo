package com.cyriltheandroid.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyriltheandroid.mvvmdemo.data.Repository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val repository = Repository()
    private val mutableLiveData = MutableLiveData<List<String>>()
    val liveData: LiveData<List<String>> = mutableLiveData

    fun getList() {
        viewModelScope.launch {
            repository.getList().collect { list ->
                mutableLiveData.value = list
            }
        }
    }
}