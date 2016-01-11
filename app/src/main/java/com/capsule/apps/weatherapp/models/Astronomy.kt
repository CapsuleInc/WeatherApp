package com.capsule.apps.weatherapp.models

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
public class Astronomy {
    var moonAge: String? = null
    var percIllum: String? = null
    var moonPhaseDesc: String? = null
    var hemisphere: String? = null

    constructor() {

    }

    constructor(moonAge: String?, percIllum: String?, moonPhaseDesc: String?, hemisphere: String?) {
        this.moonAge = moonAge
        this.percIllum = percIllum
        this.moonPhaseDesc = moonPhaseDesc
        this.hemisphere = hemisphere
    }
}