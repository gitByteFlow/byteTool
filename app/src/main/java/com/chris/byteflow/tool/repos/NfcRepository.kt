package com.chris.byteflow.tool.repos

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NfcRepository @Inject constructor() {
    private val TAG = "NfcRepository"

    val carData = MutableLiveData(false)


}