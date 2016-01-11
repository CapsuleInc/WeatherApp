package com.capsule.apps.weatherapp.services

import android.os.Handler
import android.os.Looper
import android.os.Message
import java.lang.ref.WeakReference

/**
 * @author Larry Pham
 * @date: Jan.11.2016
 * <br/>
 * Email: larrypham.vn@gmail.com.
 * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */

class WeakHandler {
    private val mCallback: Handler.Callback?
    private val mExecHandler: ExecHandler
    private val mRunnableRef = ChainedRef(null)

    constructor() {
        mCallback = null
        mExecHandler = ExecHandler()
    }

    constructor(callback: Handler.Callback?) {
        mCallback = callback
        mExecHandler = ExecHandler(WeakReference<Handler.Callback>(callback))
    }

    constructor(looper: Looper) {
        mCallback = null
        mExecHandler = ExecHandler(looper)
    }

    constructor(looper: Looper, callback: Handler.Callback) {
        mCallback = callback
        mExecHandler = ExecHandler(looper, WeakReference(callback))
    }

    fun post(runnable: Runnable): Boolean {
        return mExecHandler.post(wrapRunnable(runnable))
    }

    fun postAtTime(runnable: Runnable, uptimeMillis: Long): Boolean {
        return mExecHandler.postAtTime(wrapRunnable(runnable), uptimeMillis)
    }

    fun postAtTime(runnable: Runnable, token: Any, uptimeMillis: Long): Boolean {
        return mExecHandler.postAtTime(wrapRunnable(runnable), token, uptimeMillis)
    }

    fun postDelayed(runnable: Runnable, delayMillis: Long): Boolean {
        return mExecHandler.postDelayed(wrapRunnable(runnable), delayMillis)
    }

    fun postAtFrontOfQueue(runnable: Runnable): Boolean {
        return mExecHandler.postAtFrontOfQueue(wrapRunnable(runnable))
    }

    fun removeCallbacks(runnable: Runnable) {
        val runnableRef = mRunnableRef.findForward(runnable)
        if (runnableRef != null) {
            mExecHandler.removeCallbacks(runnableRef.wrapper)
        }
    }

    fun removeCallbacks(runnable: Runnable, token: Any) {
        val runnableRef = mRunnableRef.findForward(runnable)
        if (runnableRef != null) {
            mExecHandler.removeCallbacks(runnableRef.wrapper, token)
        }
    }

    fun sendMessage(msg: Message): Boolean {
        return mExecHandler.sendMessage(msg)
    }

    fun sendEmptyMessage(what: Int): Boolean {
        return mExecHandler.sendEmptyMessage(what)
    }

    fun sendEmptyMessageDelayed(what: Int, delayMillis: Long): Boolean {
        return mExecHandler.sendEmptyMessageDelayed(what, delayMillis)
    }

    fun sendMessageAtTime(msg: Message, uptimeMillis: Long): Boolean {
        return mExecHandler.sendMessageAtTime(msg, uptimeMillis)
    }

    fun sendMessageAtFrontOfQueue(msg: Message): Boolean {
        return mExecHandler.sendMessageAtFrontOfQueue(msg)
    }

    fun removeMessages(what: Int) {
        mExecHandler.removeMessages(what)
    }

    fun removeMessages(what: Int, obj: Any) {
        mExecHandler.removeMessages(what, obj)
    }

    fun removeCallbacksAtMessages(token: Any) {
        mExecHandler.removeCallbacksAndMessages(token)
    }

    fun hasMessages(what: Int): Boolean {
        return mExecHandler.hasMessages(what)
    }

    fun hasMessages(what: Int, obj: Any): Boolean {
        return mExecHandler.hasMessages(what, obj)
    }

    val looper: Looper
        get() = mExecHandler.looper

    fun handleMessage(msg: Message) {
        mExecHandler.handleMessage(msg)
    }

    private fun wrapRunnable(runnable: Runnable): WeakRunnable {
        val hardRef = ChainedRef.obtain(runnable)
        mRunnableRef.insertAbove(hardRef)
        hardRef.wrapper = WeakRunnable(WeakReference(runnable), reference = WeakReference(hardRef))
        return hardRef.wrapper!!
    }

    private class ExecHandler: Handler {
        private val callbackRef: WeakReference<Handler.Callback>?

        internal constructor() {
            callbackRef = null
        }

        internal constructor(callback: WeakReference<Handler.Callback>) {
            callbackRef = callback
        }

        internal constructor(looper: Looper) : super(looper) {
            callbackRef = null
        }

        internal constructor(looper: Looper, callback: WeakReference<Handler.Callback>) : super(looper) {
            callbackRef = callback
        }

        override fun handleMessage(msg: Message) {
            if (callbackRef == null) {
                return
            }

            val callback = callbackRef.get()?: return
            callback.handleMessage(msg)
        }
    }

     internal class WeakRunnable(val delegate: WeakReference<Runnable>,val reference: WeakReference<ChainedRef>) : Runnable {
        override fun run() {
            val delegateRef = delegate.get()
            val referenceRef = reference.get()
            referenceRef.remove()
            delegateRef.run()
        }
    }

    internal class ChainedRef(var runnable: Runnable?) {
        var next: ChainedRef? = null
        var prev: ChainedRef? = null
        var wrapper: WeakRunnable? = null

        fun remove() {
            if (prev != null) {
                prev!!.next = next
            }

            if (next != null) {
                next!!.prev = prev
            }

            this.prev = null
            this.runnable = null
            this.wrapper = null

            synchronized(ChainedRef::class.java) {
                if (sPoolSize > MAX_POOL_SIZE) {
                    return
                }

                this.next = sPool
                sPool = this
                sPoolSize++
            }
        }

        fun insertAbove(candidate: ChainedRef) {
            if (next != null) {
                next!!.prev = candidate
            }
            candidate.next = next
            next = candidate
            candidate.prev = this
        }

        fun findForward(runnable: Runnable?): ChainedRef? {
            var current: ChainedRef? = this
            while (current != null) {
                if (current.runnable != null) {
                    if (current.runnable == runnable) {
                        return current
                    }
                } else if (runnable == null) {
                    return current
                }
                current = current.next
            }
            return null
        }

        companion object {
            val MAX_POOL_SIZE = 15
            var sPool: ChainedRef? = null
            var sPoolSize: Int = 0

            fun obtain(runnable: Runnable): ChainedRef {
                var result: ChainedRef? = null
                synchronized(ChainedRef::class.java) {
                    if (sPool != null) {
                        result = sPool
                        sPool = sPool!!.next
                        sPoolSize--
                    }
                }

                if (result != null) {
                    result!!.runnable = runnable
                    return result!!
                }

                return ChainedRef(runnable)
            }
        }
    }
}