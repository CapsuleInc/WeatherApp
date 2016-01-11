package com.capsule.apps.weatherapp.models

import java.util.*

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class WeatherHourForecast: BaseWeather() {
    public var hoursForecast: ArrayList<HourForecast>? = ArrayList()

    public fun addForecast(forecast: HourForecast) {
        hoursForecast!!.add(forecast)
    }

    public fun getHourForecast(hourNum: Int): HourForecast {
        return hoursForecast!!.get(hourNum)
    }
}