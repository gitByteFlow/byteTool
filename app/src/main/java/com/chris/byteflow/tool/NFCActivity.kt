package com.chris.byteflow.tool

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.chris.byteflow.tool.databinding.ActivityNfcBinding
import com.chris.byteflow.tool.viewmodels.NfcViewModel
import com.chris.byteflow.tool.viewmodels.TestViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NFCActivity : AppCompatActivity(), LifecycleObserver {
    private val TAG = "NFCActivity"
    private lateinit var binding: ActivityNfcBinding
    private val nfcViewModel: NfcViewModel by viewModels()
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
        binding = ActivityNfcBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            viewModel = nfcViewModel
            newViewModel = testViewModel
        }
    }
}