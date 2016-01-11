package com.capsule.apps.weatherapp.controllers

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

object ControllerMessage {
    val BASE_CONTROL_MESSAGE = 100
    val REQUEST_OWNER_MESSAGE = BASE_CONTROL_MESSAGE + 1

    val REQUEST_TO_SERVER_BASE = 200
    val REQUEST_TO_SERVER_ERROR_BASE = 300
    val REQUEST_TO_SERVER_REASON_BASE= 400
    val REQUEST_TO_SERVER_COMPLETED_BASE = 500

    /**
     * Method toString() used to print the message's description.
     * @param msg Integer Type.
     * @return String type. The message's short-description.
     */
    fun toString(msg: Int): String {
        var result: String? = null
        when (msg) {
            REQUEST_OWNER_MESSAGE -> {
                result = "REQUEST_OWNER_MESSAGE"
            } else -> {

            }
        }
        return result!!
    }
}