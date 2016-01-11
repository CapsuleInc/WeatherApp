package com.capsule.apps.weatherapp

import android.app.Application
import android.os.Handler
import android.os.Message
import com.capsule.apps.weatherapp.activities.ActivityHandler
import com.capsule.apps.weatherapp.models.DataModel
import com.capsule.apps.weatherapp.utils.LogUtils
import java.util.*

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public class WeatherApp() : Application() {
    companion object {
        public val TAG: String = LogUtils.makeLogTag(WeatherApp.javaClass)
    }

    private val dataModel = DataModel()
    private val mHandlerList = ArrayList<ActivityHandler>()
    private val mainHandler = AppMainHandler()

    public override fun onCreate() {
        LogUtils.LOGD(TAG, "WeatherApp is Created");
        super<Application>.onCreate()

    }

    fun addHandlerIfNotExist(handler: ActivityHandler) {
        var blnExist = false
        try {
            val size = mHandlerList.size
            for (i in 0..size - 1) {
                if (mHandlerList[i].hashCode() == handler.hashCode()) {
                    blnExist = true
                    break
                }
            }

            if (!blnExist) {
                LogUtils.LOGE(TAG, "addHandlerIfNotExist")
                addHandler(handler)
            }
        } catch (e: Exception) {
            LogUtils.LOGE(TAG, "addHandlerIfNotExist() throws new exception: %s".format(e.message))
        }
    }

    fun addHandler(handler: ActivityHandler) {
        LogUtils.LOGD(TAG, "addHandler: %s".format(handler.toString()))
        mHandlerList.add(handler)
    }

    fun removeHandler(handler: ActivityHandler) {
        LogUtils.LOGD(TAG, "removeHandler: %s".format(handler.toString()))
        mHandlerList.remove(handler)
        LogUtils.LOGD(TAG, "count of remained handlers: %d".format(mHandlerList.size))
    }

    fun removeAllHandlers() {
        LogUtils.LOGD(TAG, "remove all of handlers %d".format(mHandlerList.size))
        mHandlerList.clear()
    }

    val appMainHandler: Handler
        get() = this.mainHandler

    val appDataModel: DataModel
        get() = this.appDataModel

    internal inner class AppMainHandler: Handler() {

        override fun handleMessage(msg: Message?) {
            val fn = "handleMessage(): "
            LogUtils.LOGD(TAG, "[AppMainHandler] handle: %s".format(msg.toString()))
            val index = 0
            val size = mHandlerList.size
            LogUtils.LOGD(TAG, "[AppMainHandler] handlerList's size: %d".format(size))

            for (i in 0..size - 1) {
                LogUtils.LOGD(TAG, fn + "Message's " + msg!!.what + " handler of " + mHandlerList[index].javaClass.simpleName)
                val activityHandler = mHandlerList[i]
                LogUtils.LOGD(TAG, "handlerList's Size: %d".format(mHandlerList.size))
                activityHandler.callback(msg)
            }
        }
    }
}