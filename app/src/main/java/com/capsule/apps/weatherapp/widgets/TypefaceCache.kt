package com.capsule.apps.weatherapp.widgets

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

import com.capsule.apps.weatherapp.R
import com.capsule.apps.weatherapp.utils.CommonUtils

import java.util.Hashtable

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
object TypefaceCache {
    val VARIATION_NORMAL = 0
    val VARIATION_LIGHT = 1
    val VARIATION_MEDIUM = 2
    val VARIATION_THIN = 4
    val VARIATION_SPECIAL = 5

    private val mTypefaceCache = CommonUtils.newHashTable<String, Typeface>()

    @JvmOverloads fun getTypeface(context: Context?, fontStyle: Int = Typeface.NORMAL, variation: Int = VARIATION_NORMAL): Typeface? {
        if (context == null) {
            return null
        }

        var typefaceName = "ClearSans-Regular.ttf"
        if (variation == VARIATION_SPECIAL) {
            when (fontStyle) {
                Typeface.ITALIC -> {
                    typefaceName = "Bitter-Italic.otf"
                }
                Typeface.BOLD -> {
                    typefaceName = "Bitter-Bold.otf"
                }
                Typeface.BOLD_ITALIC -> {
                    typefaceName = "Bitter-BoldItalic.otf"
                }
                else -> {
                    typefaceName = "Bitter-Regular.otf"
                }
            }
        } else if (variation == VARIATION_LIGHT) {
            typefaceName = "ClearSans-Light.ttf"
        } else if (variation == VARIATION_MEDIUM) {
            when (fontStyle) {
                Typeface.ITALIC -> {
                    typefaceName = "ClearSans-MediumItalic.ttf"
                }
                else -> {
                    typefaceName = "ClearSans-Medium.ttf"
                }
            }
        } else if (variation == VARIATION_THIN) {
            typefaceName = "ClearSans-Thin.ttf"
        } else if (variation == VARIATION_NORMAL) {
            when (fontStyle) {
                Typeface.BOLD -> {
                    typefaceName = "ClearSans-Bold.ttf"
                }
                Typeface.BOLD_ITALIC -> {
                    typefaceName = "ClearSans-BoldItalic.ttf"
                }
                Typeface.NORMAL -> {
                    typefaceName = "ClearSans-Regular.ttf"
                }
                Typeface.ITALIC -> {
                    typefaceName = "ClearSans-Italic.ttf"
                }
            }
        }

        return getTypefaceForTypefaceName(context, typefaceName)
    }

    private fun getTypefaceForTypefaceName(context: Context, typefaceName: String): Typeface {
        if (!mTypefaceCache.containsKey(typefaceName)) {
            val typeface = Typeface.createFromAsset(context.applicationContext.assets, "fonts/" + typefaceName)
            if (typeface != null) {
                mTypefaceCache.put(typefaceName, typeface)
            }
        }
        return mTypefaceCache[typefaceName]!!
    }

    fun setCustomTypeface(context: Context?, textView: TextView?, attrs: AttributeSet?) {
        if (context == null || textView == null) {
            return
        }

        if (textView.isInEditMode) {
            return
        }

        var variation = TypefaceCache.VARIATION_NORMAL
        if (attrs != null) {
            val array = context.theme.obtainStyledAttributes(attrs, R.styleable.OpenTextView, 0, 0)
            if (array != null) {
                try {
                    variation = array.getInteger(R.styleable.OpenTextView_fontVariation, TypefaceCache.VARIATION_NORMAL)
                } finally {
                    array.recycle()
                }
            }
        }

        val fontStyle: Int
        if (textView.typeface != null) {
            val isBold = textView.typeface.isBold
            val isItalic = textView.typeface.isItalic

            if (isBold && isItalic) {
                fontStyle = Typeface.BOLD_ITALIC
            } else if (isBold) {
                fontStyle = Typeface.BOLD
            } else if (isItalic) {
                fontStyle = Typeface.ITALIC
            } else {
                fontStyle = Typeface.NORMAL
            }
        } else {
            fontStyle = Typeface.NORMAL
        }

        val typeface = getTypeface(context, fontStyle, variation)
        if (typeface != null) {
            textView.typeface = typeface
        }
    }
}
