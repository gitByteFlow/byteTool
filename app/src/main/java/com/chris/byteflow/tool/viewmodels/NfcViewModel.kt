package com.chris.byteflow.tool.viewmodels

import androidx.lifecycle.LifecycleObserver
import com.chris.byteflow.tool.base.BaseViewModel
import com.chris.byteflow.tool.repos.NfcRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NfcViewModel
@Inject constructor(
    private val repo: NfcRepository
) : BaseViewModel(), LifecycleObserver {


    fun checkNFC() {
        repo.checkNFC()
    }
}