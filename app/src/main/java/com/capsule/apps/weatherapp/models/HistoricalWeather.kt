package com.capsule.apps.weatherapp.models

import java.util.*

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class HistoricalWeather: BaseWeather() {

    public var historicalData: ArrayList<HistoricalHourWeather> = ArrayList()

    public fun addHistoricalHourWeather(item: HistoricalHourWeather) {
        historicalData.add(item)
    }

    public fun getHistoricalHourWeather(hourNum: Int): HistoricalHourWeather {
        return historicalData.get(hourNum)
    }
}