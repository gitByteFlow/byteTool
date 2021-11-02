package com.chris.byteflow.tool

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.chris.byteflow.tool.databinding.ActivityNfcBinding
import com.chris.byteflow.tool.viewmodels.NfcViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NFCActivity : AppCompatActivity() {
    private val TAG = "NFCActivity"
    private lateinit var binding: ActivityNfcBinding
//    private val nfcViewModel by viewModels<NfcViewModel>()

    private val nfcViewModel: NfcViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nfcViewModel.observe(lifecycle)
        binding = ActivityNfcBinding.inflate(layoutInflater)
        binding.viewModel = nfcViewModel
        setContentView(binding.root)
        nfcViewModel.checkNFC()
    }


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
                Log.i(TAG, "onNewIntent: ${rawMessages}")
                // Process the messages array.
            }
        }

    }
}