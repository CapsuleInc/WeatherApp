package com.capsule.apps.weatherapp.controllers

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Message
import com.capsule.apps.weatherapp.Action
import com.capsule.apps.weatherapp.WeatherApp
import com.capsule.apps.weatherapp.activities.ActivityHandler
import com.capsule.apps.weatherapp.activities.BaseActivity
import com.capsule.apps.weatherapp.fragments.BaseFragment
import com.capsule.apps.weatherapp.models.DataModel
import com.capsule.apps.weatherapp.utils.LogUtils

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
public abstract class BaseController {
    companion object {
        val TAG = LogUtils.makeLogTag(BaseController.javaClass)
    }
    var activity: BaseActivity? = null
    var fragment: BaseFragment? = null
    var dataModel: DataModel? = null

    var app: WeatherApp? = null
    var handler = ActivityBaseHandler()

    constructor(activity: BaseActivity, inDataModel: DataModel) {
        this.activity = activity
        this.dataModel = inDataModel
        this.app = activity.applicationContext as WeatherApp
        onCreate()
    }

    constructor(activity: BaseActivity, inDataModel: DataModel, blnFirstRunning: Boolean) {
        this.activity = activity
        this.dataModel = inDataModel
        this.app = activity.applicationContext as WeatherApp
        if (blnFirstRunning) {
            app!!.removeAllHandlers()
        }
        onCreate()
    }

    constructor(fragment: BaseFragment, inDataModel: DataModel) {
        this.fragment = fragment
        this.activity = fragment.activity as BaseActivity
        this.app = activity!!.applicationContext as WeatherApp
        this.dataModel = inDataModel
        onCreate()
    }

    constructor(fragment: BaseFragment, inDataModel: DataModel, blnFirstRunning: Boolean) {
        this.fragment = fragment
        this.activity = fragment.activity as BaseActivity
        this.app = activity!!.applicationContext as WeatherApp
        this.dataModel = inDataModel
        if (blnFirstRunning) {
            app!!.removeAllHandlers()
        }
        onCreate()
    }

    fun onCreate() {
        app!!.addHandler(handler)
    }

    fun onDestroy() {
        val fn = "onDestroy()";
        LogUtils.LOGD(TAG, fn + "removeHandler")
        app!!.removeHandler(handler);
    }

    fun sendMessage(what: Int, obj: Any) {
        val msg = Message()
        msg.what = what
        msg.obj = obj
        handleMesasge(msg)
    }

    public fun obtainIntent(msg: Int, T: Class<*>): Intent {
        val intent = Intent(activity, T.javaClass)
        intent.putExtra(Action.REQUEST_OWNER, this.hashCode())
        intent.putExtra(Action.REQUEST_MSG, msg)
        return intent
    }

    public fun checkOwner(msg: Message): Boolean {
        if (msg.arg1 == this.hashCode()) {
            return true
        } else {
            LogUtils.LOGD(TAG, "[PROC] checkOwner false %d %d".format(msg.arg1, this.hashCode()))
            return false
        }
    }

    abstract fun handleMesasge(msg: Message)

    inner class ActivityBaseHandler: ActivityHandler() {
        override fun callback(msg: Message) {
            handleMesasge(msg)
        }
    }
}