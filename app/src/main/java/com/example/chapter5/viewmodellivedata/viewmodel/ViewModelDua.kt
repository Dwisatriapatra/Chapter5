package com.example.chapter5.viewmodellivedata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDua : ViewModel() {
    var number = 0
    val addNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val lessNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}