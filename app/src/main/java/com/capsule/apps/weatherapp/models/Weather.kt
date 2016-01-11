package com.capsule.apps.weatherapp.models

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class Weather {
    public var location: Location? = Location()
    public var condition: Condition? = Condition()
    public var temperature: Temperature? = Temperature()
    public var wind: Wind? = Wind()
    public var rains: Array<Rain>? = arrayOf(Rain(), Rain())
    public var iconData: Array<Byte>? = null

    public class Condition {
        var weatherId: Int = 0
        var condition: String? = null

        var description: String? = null
        var icon: String? = null

        var pressure: Float = 0f
        var humidity: Float = 0f

        var visibility: Float = 0f
        var pressureTrend: Int = 0

        var uv: Float = 0f
        var dewPoint: Float = 0f
        var heatIndex: String? = null

        var solarRadiation: String? = null
        var pressureSeaLevel: Float = 0f
        var pressureGroundLevel: Float = 0f
        var weatherCode: WeatherCode? = null

    }

    public class Temperature {
        var temp: Float = 0f
        var minTemp: Float = 0f
        var maxTemp: Float = 0f
    }

    public class Wind {
        var speed: Float = 0f
        var deg: Float = 0f
        var chill: Float = 0f
        var gust: Float = 0f
    }

    public class Rain {
        var time: String? = null
        var amount: Float = 0f
        var chance: Float = 0f
    }

    public class Snow {
        var time: String? = null
        var amount: Float = 0f
    }

    public class Clouds {
        var perc: Int? = 0
    }
}