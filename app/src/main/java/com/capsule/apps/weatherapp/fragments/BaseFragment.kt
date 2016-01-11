package com.capsule.apps.weatherapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import com.capsule.apps.weatherapp.activities.BaseActivity
import com.capsule.apps.weatherapp.controllers.BaseController
import com.capsule.apps.weatherapp.models.DataModel
import com.capsule.apps.weatherapp.utils.LogUtils

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

public abstract class BaseFragment: Fragment() {

    companion object {
        protected val TAG = LogUtils.makeLogTag(BaseFragment.javaClass)
    }

    var mController: BaseController? = null
    protected var mDataModel: DataModel? = null
    protected var mActivity: BaseActivity?= null

    protected var mBundle = Bundle()
    protected var fragmentKey: String? = null

    override fun onDestroy() {
        if (mController != null) {
            mController!!.onDestroy()
        }
        super.onDestroy()
    }

    abstract fun invalidate()
    abstract fun invalidate(vararg params: Any)
}