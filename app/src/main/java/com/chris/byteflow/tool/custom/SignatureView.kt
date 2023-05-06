package com.chris.byteflow.tool.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class SignatureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val path: Path = Path()
    private val paint: Paint = Paint()
    private var isSigned = false

    init {
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(x, y)
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                isSigned = true
            }
            MotionEvent.ACTION_UP -> {}
        }
        invalidate()
        return true
    }

    fun hasSignature(): Boolean {
        return isSigned
    }

    fun clearSignature() {
        path.reset()
        isSigned = false
        invalidate()
    }

    fun saveSignature(): Bitmap {
        val signatureBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(signatureBitmap)
        draw(canvas)
        return signatureBitmap
    }
}