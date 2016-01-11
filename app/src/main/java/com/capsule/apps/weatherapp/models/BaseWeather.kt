package com.capsule.apps.weatherapp.models

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public abstract class BaseWeather {

    public var unit: WeatherUnit? = null

    public class WeatherUnit {
        var speedUnit: String? = null
        var tempUnit: String? = null
        var pressureUnit: String? = null
        var distanceUnit: String? = null
    }
}