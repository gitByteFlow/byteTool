package com.chris.byteflow.tool.repos

import android.app.Application
import android.content.pm.PackageManager
import android.widget.Toast
import com.chris.byteflow.tool.R
import com.chris.byteflow.tool.base.BaseRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.MainScope
import javax.inject.Inject

@ViewModelScoped
class NfcRepository @Inject constructor(
    ctx: Application
) : BaseRepository(ctx) {
    private val TAG = "NfcRepository"


    private val _consumeScope = MainScope()


    fun checkNFC() {
        val packageManager = ctx.packageManager
        packageManager.hasSystemFeature(PackageManager.FEATURE_NFC).let {
            if (it) {
                Toast.makeText(ctx, ctx.getString(R.string.nfc), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(ctx, ctx.getString(R.string.nfc_have), Toast.LENGTH_LONG).show()
            }
        }

    }


}