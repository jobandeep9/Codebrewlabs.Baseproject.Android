package com.codebrewlabs.base_application.utils

import android.content.Context
import android.content.SharedPreferences

open class SharedPrefUtils protected constructor(context: Context) {

    private val preferences: SharedPreferences

    fun writeBoolean(key: Int, value: Boolean) {
        preferences.edit().putBoolean(key.toString(), value).apply()
    }

    fun writeInteger(key: Int, value: Int) {
        preferences.edit().putInt(key.toString(), value).apply()
    }

    fun writeString(key: Int, value: String?) {
        preferences.edit().putString(key.toString(), value).apply()
    }

    fun readBoolean(key: Int): Boolean {
        return if (key == 0) {
            preferences.getBoolean(key.toString(), true)
        } else preferences.getBoolean(key.toString(), false)
    }

    fun readInteger(key: Int): Int {
        return if (key == -1) {
            preferences.getInt(key.toString(), 2)
        } else preferences.getInt(key.toString(), 0)
    }

    fun readLong(key: Int): Long {
        return if (key == -1) {
            preferences.getLong(key.toString(), 2L)
        } else preferences.getLong(key.toString(), 0L)
    }

    fun writeLong(key: Int, value: Long) {
        preferences.edit().putLong(key.toString(), value).apply()
    }

    fun readString(key: Int): String? {
        return if (key == 99) {
            preferences.getString(key.toString(), "")
        } else preferences.getString(key.toString(), "")
    }

    companion object {
        private var i: SharedPrefUtils? = null
        @JvmStatic
        fun i(): SharedPrefUtils? {
            return if (i == null) {
                throw AssertionError("Before using it initialise it by creating object with context")
            } else {
                i
            }
        }

        fun initiate(context: Context) {
            if (i == null) {
                SharedPrefUtils(context)
            }
        }
    }

    init {
        i = this
        val fileName = context.packageName + ".prefFile"
        preferences = context.getSharedPreferences(fileName, 0)
    }
}