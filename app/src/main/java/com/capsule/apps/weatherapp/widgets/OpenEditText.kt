package com.capsule.apps.weatherapp.widgets

import android.content.Context
import android.content.res.TypedArray
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView

import com.capsule.apps.weatherapp.R


/**
 * @Author: larry
 * * History: 12/16/15.
 */
class OpenEditText : EditText {

    var mFixWindowWordEnabled = false

    constructor(context: Context) : super(context) {
        TypefaceCache.setCustomTypeface(context, this, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        TypefaceCache.setCustomTypeface(context, this, attrs)
        readCustomAttributes(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        TypefaceCache.setCustomTypeface(context, this, attrs)
        readCustomAttributes(context, attrs)
    }

    override fun setText(text: CharSequence, type: TextView.BufferType) {
        if (!mFixWindowWordEnabled) {
            super.setText(text, type)
            return
        }

        val out: Spannable
        val lastSpace = text.toString().lastIndexOf(' ')
        if (lastSpace != -1 && lastSpace < text.length - 1) {
            val tmpText = replaceCharacter(text, lastSpace, "\u00A0")
            out = SpannableString(tmpText)

            if (text is Spanned) {
                TextUtils.copySpansFrom(text, 0, text.length, null, out, 0)
            }
        } else {
            out = SpannableString(text)
        }
        super.setText(out, type)
    }

    private fun readCustomAttributes(context: Context, attrs: AttributeSet) {
        val array = context.theme.obtainStyledAttributes(attrs, R.styleable.OpenTextView, 0, 0)
        if (array != null) {
            mFixWindowWordEnabled = array.getBoolean(R.styleable.OpenTextView_fixWidowWords, false)

            if (mFixWindowWordEnabled) {
                setText(text)
            }
        }
    }

    private fun replaceCharacter(source: CharSequence, charIndex: Int, replacement: CharSequence): CharSequence {
        if (charIndex != -1 && charIndex < source.length - 1) {
            return TextUtils.concat(source.subSequence(0, charIndex), replacement, source.subSequence(charIndex + 1, source.length))
        }
        return source
    }
}
