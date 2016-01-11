package com.capsule.apps.weatherapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.capsule.apps.weatherapp.WeatherApp
import com.capsule.apps.weatherapp.controllers.BaseController
import com.capsule.apps.weatherapp.models.DataModel

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public abstract class BaseActivity: AppCompatActivity() {
    protected var controller: BaseController? = null
    protected var dataModel: DataModel? = null
    protected var weatherApp: WeatherApp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherApp = this.applicationContext as WeatherApp
        dataModel = weatherApp!!.appDataModel
    }

    protected override fun onDestroy() {
        if (controller != null) {
            controller!!.onDestroy()
        }
        super.onDestroy()
    }


    public abstract fun invalidate()

    public abstract fun invalidate(params: Array<Any>)
}