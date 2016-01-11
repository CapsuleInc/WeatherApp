package com.capsule.apps.weatherapp.utils

import java.util.ArrayList
import java.util.HashMap
import java.util.Hashtable

/**
 * @author Larry Pham
 * *
 * @date: Jan.11.2016
 * *
 * * Email: larrypham.vn@gmail.com.
 * * Copyright (C) 2016 Capsule Inc. All rights reserved.
 */
class CommonUtils private constructor() {

    init {
        throw AssertionError("Cannot instantiated this class")
    }

    companion object {

        fun <E> newArrayList(): ArrayList<E> {
            return ArrayList()
        }

        fun <T, V> newHashTable(): Hashtable<T, V> {
            return Hashtable()
        }

        fun <K, V> newHashMap(): HashMap<K, V> {
            return HashMap()
        }
    }
}
