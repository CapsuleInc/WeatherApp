package com.capsule.apps.weatherapp.activities

import android.os.Message

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
abstract class ActivityHandler {
    abstract fun callback(msg: Message)
}