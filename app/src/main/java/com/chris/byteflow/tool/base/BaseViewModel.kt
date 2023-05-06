package com.chris.byteflow.tool.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val TAG = "BaseViewModel"

    override fun onCleared() {
        super.onCleared()
    }
}