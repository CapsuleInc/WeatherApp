package com.capsule.apps.weatherapp.models

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class City{
    var id: String? = null
    var name: String? = null
    var country: String? = null
    var region: String? = null
    var lon: Double = 0.0
    var lat: Double = 0.0

    constructor() {

    }

    constructor(id: String?, name: String?, country: String?, region: String?, lon: Double, lat: Double) {
        this.id = id
        this.name = name
        this.country = country
        this.region = region
        this.lon = lon
        this.lat = lat
    }
}