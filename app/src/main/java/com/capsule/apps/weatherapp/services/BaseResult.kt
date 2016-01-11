package com.capsule.apps.weatherapp.services

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
public open class BaseResult {
    var requestOwner: String? = null
    var requestMessage = 0
    var resultMsg = 0
    var errorReason = 0

    var resultMessage: Int
        get() = resultMsg
        set(value) {
            this.resultMsg = value
        }
}