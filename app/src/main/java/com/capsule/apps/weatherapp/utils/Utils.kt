package com.capsule.apps.weatherapp.utils

import android.view.MenuItem
import android.view.View
import java.util.*

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public fun onClickListener(action: (View) -> Unit): View.OnClickListener {
    return object: View.OnClickListener {
        override fun onClick(v: View?) {
            action(v!!)
        }
    }
}

public fun View.setOnClickListener(action: (View?) -> Unit) : Unit {
    setOnClickListener(onClickListener(action))
}

public fun MenuItem?.andHide(): MenuItem {
    this!!.setVisible(false)
    return this
}

public fun Int.toHoursInMinutes() =  this * 60

public fun daysBeforeNow(days: Int): Date {
    val hours = days * 24
    val now = Calendar.getInstance()
    now.add(Calendar.HOUR, -hours)
    return now.time
}

public fun hoursBeforeNow(hours: Int): Date {
    val now = Calendar.getInstance()
    now.add(Calendar.HOUR, -hours)
    return now.time
}

fun <T: View> View?.findViewById(id: Int) : T {
    @Suppress("UNCHECKED_CAST")
    return this!!.findViewById(id) as T
}