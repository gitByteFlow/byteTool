package com.chris.byteflow.tool.viewmodels

import android.util.Log
import android.view.View
import com.chris.byteflow.tool.base.BaseViewModel
import com.chris.byteflow.tool.repos.NfcRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NfcViewModel
@Inject constructor(
    private val repo: NfcRepository,
) : BaseViewModel() {
    private val TAG = "NfcViewModel"


    fun test(view: View) {
        Log.i(TAG, "test: ")

    }

}