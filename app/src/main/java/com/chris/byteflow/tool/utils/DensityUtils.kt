package com.chris.byteflow.tool.utils

import android.content.Context
import android.util.TypedValue

fun Number.dip2px(context: Context): Float {
    val displayMetrics = context.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics)
}

fun Float.sp2px(context: Context): Float {
    val displayMetrics = context.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), displayMetrics)
}