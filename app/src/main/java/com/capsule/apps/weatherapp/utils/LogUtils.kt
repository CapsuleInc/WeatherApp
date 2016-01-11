package com.capsule.apps.weatherapp.utils

import android.util.Log

import com.capsule.apps.weatherapp.BuildConfig
import com.capsule.apps.weatherapp.Properties


/**
 * @Author: larry
 * * History: 12/15/15.rx
 */
open class LogUtils {

    protected constructor() {

    }

    companion object {
        private val LOG_PREFIX_LENGTH = Properties.PREFIX.length
        private val MAX_LOG_TAG_LENGTH = 23

        fun makeLogTag(clazz: Class<Any>): String {
            return Properties.PREFIX + clazz.simpleName
        }

        fun LOGD(tag: String, message: String) {
            if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message)
            }
        }

        fun LOGD(tag: String, message: String, cause: Throwable) {
            if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message, cause)
            }
        }

        fun LOGV(tag: String, message: String) {
            if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message)
            }
        }

        fun LOGV(tag: String, message: String, cause: Throwable) {
            if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message, cause)
            }
        }

        fun LOGI(tag: String, message: String) {
            Log.i(tag, message)
        }

        fun LOGI(tag: String, message: String, cause: Throwable) {
            Log.v(tag, message, cause)
        }

        fun LOGW(tag: String, message: String) {
            Log.w(tag, message)
        }

        fun LOGW(tag: String, message: String, cause: Throwable) {
            Log.w(tag, message, cause)
        }

        fun LOGE(tag: String, message: String) {
            Log.e(tag, message)
        }

        fun LOGE(tag: String, message: String, cause: Throwable) {
            Log.e(tag, message, cause)
        }
    }
}