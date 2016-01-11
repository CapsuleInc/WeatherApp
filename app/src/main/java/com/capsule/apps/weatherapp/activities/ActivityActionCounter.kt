package com.capsule.apps.weatherapp.activities

import com.capsule.apps.weatherapp.utils.LogUtils

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class ActivityActionCounter {
    var count = 0
        private set

    companion object {
        val TAG = LogUtils.makeLogTag(ActivityActionCounter.javaClass)
    }

    @Synchronized fun incrementActionCount() {
        this.count++
        LogUtils.LOGD(TAG,"ActionCount was increased: %d".format(count))
    }

    @Synchronized fun decrementActionCount() {
        this.count--
        LogUtils.LOGD(TAG, "ActionCount was decreased: %d".format(count))
    }

    @Synchronized fun reset() {
        this.count = 0
        LogUtils.LOGD(TAG, "ActionCount was reset".format())
    }
}