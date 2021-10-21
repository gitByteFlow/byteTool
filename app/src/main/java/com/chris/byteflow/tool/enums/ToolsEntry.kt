package com.chris.byteflow.tool.enums

import androidx.annotation.ColorRes
import com.chris.byteflow.tool.App
import com.chris.byteflow.tool.R

enum class ToolsEntry(@ColorRes val bg: Int, val toolName: String) {

    NFC(R.color.color_ffa39e, App.instance.getString(R.string.nfc)),
    BLE(R.color.color_17af42, App.instance.getString(R.string.ble)),
    TTS(R.color.color_3361c2, App.instance.getString(R.string.tts)),
    WIFI(R.color.color_3361c2, App.instance.getString(R.string.wifi)),

}