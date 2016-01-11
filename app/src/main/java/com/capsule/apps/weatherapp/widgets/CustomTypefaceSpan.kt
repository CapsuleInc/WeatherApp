package com.capsule.apps.weatherapp.widgets

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.TypefaceSpan

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
class CustomTypefaceSpan(family: String, private val mNewType: Typeface) : TypefaceSpan(family) {

    override fun updateDrawState(ds: TextPaint) {
        applyCustomTypeface(ds, mNewType)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeface(paint, mNewType)
    }

    private fun applyCustomTypeface(paint: Paint, typeface: Typeface) {
        val oldStyle: Int
        val oldTypeface = paint.typeface
        if (oldTypeface == null) {
            oldStyle = 0
        } else {
            oldStyle = oldTypeface.style
        }

        val fakeStyle = oldStyle and typeface.style.inv()
        if (fakeStyle and Typeface.BOLD != 0) {
            paint.isFakeBoldText = true
        }

        if (fakeStyle and Typeface.ITALIC != 0) {
            paint.textSkewX = -0.25f
        }
        paint.setTypeface(typeface)
    }
}
