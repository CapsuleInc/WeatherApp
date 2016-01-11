package com.capsule.apps.weatherapp.controllers

import android.content.Intent
import android.os.Message
import com.capsule.apps.weatherapp.activities.BaseActivity
import com.capsule.apps.weatherapp.models.DataModel

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
public class WeatherController(activity: BaseActivity, inDataModel: DataModel) : BaseController(activity, inDataModel) {

    override fun handleMesasge(msg: Message) {
        when (msg.what) {
        }
        throw UnsupportedOperationException()
    }

}