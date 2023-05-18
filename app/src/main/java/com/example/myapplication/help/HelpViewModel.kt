package com.example.myapplication.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelpViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Это фрагмент справки"
    }
    val text: LiveData<String> = _text
}