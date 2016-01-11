package com.capsule.apps.weatherapp.models

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class DayForecast: WeatherForecastData() {
    var sdf: SimpleDateFormat? = SimpleDateFormat("dd/MM/yyyy")
    var forecastTemp: ForecastTemp = ForecastTemp()

    public class ForecastTemp {
        public var day: Float = 0f
        public var min: Float = 0f
        public var max: Float = 0f
        public var night: Float = 0f
        public var eve: Float = 0f
        public var morning: Float = 0f
    }

    public fun getStringDate(): String {
        return sdf!!.format(Date(timeStamp!!))
    }
}