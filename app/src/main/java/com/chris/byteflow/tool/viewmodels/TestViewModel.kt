package com.chris.byteflow.tool.viewmodels

import android.util.Log
import android.view.View
import com.chris.byteflow.tool.base.BaseViewModel
import com.chris.byteflow.tool.repos.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val repo: MainRepository,
) : BaseViewModel() {

    private val TAG = "TestViewModel"
    fun test(view: View) {
        Log.i(TAG, "test: ")
    }

    override fun onCleared() {
        super.onCleared()
    }

}