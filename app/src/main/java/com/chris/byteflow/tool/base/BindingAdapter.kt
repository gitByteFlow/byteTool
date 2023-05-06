@file:JvmName("BindingAdapter")

package com.chris.byteflow.tool.base

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter

//
//  背景资源
//
@BindingAdapter("backgroundRes")
fun bindBackgroundRes(view: View, backgroundRes: Int) {
    view.setBackgroundResource(backgroundRes)
}

//
//圆角
//
@BindingAdapter("radius")
fun bindRadius(view: View, radius: Float) {
    view.outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline?) {
            outline?.setRoundRect(0, 0, view.width, view.height, radius)
        }
    }
    view.clipToOutline = true
}
