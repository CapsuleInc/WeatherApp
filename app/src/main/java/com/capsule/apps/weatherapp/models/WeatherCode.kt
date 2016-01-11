package com.capsule.apps.weatherapp.models

import android.content.Context

import com.capsule.apps.weatherapp.R

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
public enum class WeatherCode {
    TORNADO(0, R.string.weather_code_000),
    TROPICAL_STORM(1, R.string.weather_code_001),
    HURRICANE(2, R.string.weather_code_002),
    SEVERE_THUNDERSTORMS(3, R.string.weather_code_003),
    THUNDERSTORMS(4, R.string.weather_code_004),
    MIXED_RAIN_SNOW(5, R.string.weather_code_005),
    MIXED_RAIN_SLEET(6, R.string.weather_code_006),
    MIXED_SNOW_SLEET(7, R.string.weather_code_007),
    FREEZING_DRIZZLE(8, R.string.weather_code_008),
    DRIZZLE(9, R.string.weather_code_009),
    FREEZING_RAIN(10, R.string.weather_code_010),
    SHOWERS(11, R.string.weather_code_011),
    HEAVY_SHOWERS(12, R.string.weather_code_012),
    SNOW_FLURRIES(13, R.string.weather_code_013),
    LIGHT_SNOW_SHOWERS(14, R.string.weather_code_014),
    BLOWING_SNOW(15, R.string.weather_code_015),
    SHOW(16, R.string.weather_code_016),
    HAIL(17, R.string.weather_code_017),
    SLEET(18, R.string.weather_code_018),
    DUST(19, R.string.weather_code_019),
    FOGGY(20, R.string.weather_code_020),
    HAZE(21, R.string.weather_code_021),
    SMOKY(22, R.string.weather_code_022),
    BLUSTERY(23, R.string.weather_code_023),
    WINDY(24, R.string.weather_code_024),
    COLD(25, R.string.weather_code_025),
    CLOUDY(26, R.string.weather_code_026),
    MOSTLY_CLOUDY_NIGHT(27, R.string.weather_code_027),
    MOSTLY_CLOUDY_DAY(28, R.string.weather_code_028),
    PARTLY_CLOUDY_NIGHT(29, R.string.weather_code_029),
    PARTLY_CLOUDY_DAY(30, R.string.weather_code_030),
    CLEAR_AT_NIGHT(31, R.string.weather_code_031),
    SUNNY(32, R.string.weather_code_032),
    FAIR_NIGHT(33, R.string.weather_code_033),
    FAIR_DAY(34, R.string.weather_code_034),
    MIXED_RAIND_HAIL(35, R.string.weather_code_035),
    HOT(36, R.string.weather_code_036),
    ISOLATED_THUNDERSTORMS(37, R.string.weather_code_037),
    SCATTERED_THUNDERSTORMS(38, R.string.weather_code_038),
    SCATTERED_THUNDERSTORMS_1(39, R.string.weather_code_039),
    SCATTERED_SHOWERS(40, R.string.weather_code_040),
    HEAVY_SNOW(41, R.string.weather_code_041),
    SCATTERED_SNOW_SHOWERS(42, R.string.weather_code_042),
    PARTLY_CLOUD(43, R.string.weather_code_043),
    THUNDER_SHOWERS(44, R.string.weather_code_044),
    SNOW_SHOWERS(45, R.string.weather_code_045),
    ISOLATED_THUNDER_SHOWERS(46, R.string.weather_code_046),
    NOT_AVAILABLE(1000, R.string.weather_code_047);

    var code: Int = 0
    var resId: Int = R.string.weather_code_047

    constructor() {

    }

    constructor(code: Int, resId: Int) {
        this.code = code
        this.resId = resId
    }

    fun getCode(): Int? {
        return this.code
    }

    fun getLabel(context: Context): String {
        val msg = context.resources.getString(resId)
        return msg
    }
}
