package com.capsule.apps.weatherapp.models

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
class Location {
    var longitude: Float = 0.toFloat()
    var latitude: Float = 0.toFloat()
    var sunset: Long = 0
    var sunrise: Long = 0
    var country: String? = null
    var city: String? = null
    var region: String? = null
    var astronomy = Astronomy()
    var population: Long = 0

    constructor() {

    }

    constructor(longitude: Float, latitude: Float, sunset: Long, sunrise: Long, country: String,
                city: String, region: String, astronomy: Astronomy, population: Long) {
        this.longitude = longitude
        this.latitude = latitude
        this.sunset = sunset
        this.sunrise = sunrise
        this.country = country
        this.city = city
        this.region = region
        this.astronomy = astronomy
        this.population = population
    }
}
