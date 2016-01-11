package com.capsule.apps.weatherapp.models

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public open class WeatherForecastData {
    public var weather: Weather = Weather()
    public var timeStamp: Long? = 0

    public constructor() {

    }

    public constructor(weather: Weather, timeStamp: Long?) {
        this.weather = weather
        this.timeStamp = timeStamp
    }
}