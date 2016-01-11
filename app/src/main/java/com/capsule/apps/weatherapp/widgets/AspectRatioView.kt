package com.capsule.apps.weatherapp.widgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

import com.capsule.apps.weatherapp.R

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
class AspectRatioView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr) {
    private var mAspectRatio = 0f

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioView, defStyleAttr, 0)
        mAspectRatio = array.getFloat(R.styleable.AspectRatioView_aspectRatio, 0f)
        if (mAspectRatio == 0f) {
            throw IllegalArgumentException("You must specify an aspect ratio when suing the AspectRatioView")
        }
        array.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val width: Int
        val height: Int
        if (mAspectRatio != 0f) {
            width = widthSize
            height = (width / mAspectRatio).toInt()
            val exactWidthSize = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
            val exactHeightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
            super.onMeasure(exactWidthSize, exactHeightSpec)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
