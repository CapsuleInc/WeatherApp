package com.capsule.apps.weatherapp

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

open class Action: Parcelable {

    companion object {
        val REQUEST_OWNER = "com.capsule.apps.actions.REQUEST_OWNER";
        val REQUEST_MSG = "com.capsule.apps.actions.REQUEST_MSG";

    }
    override fun describeContents(): Int {
        throw UnsupportedOperationException()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        throw UnsupportedOperationException()
    }

}