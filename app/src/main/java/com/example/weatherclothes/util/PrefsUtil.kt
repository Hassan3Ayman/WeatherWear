package com.example.weatherclothes.util

import android.content.Context
import android.content.SharedPreferences

object PrefsUtil {
    private var todoSharedPreferences: SharedPreferences? = null
    private var todoSharedPreferencesEditor: SharedPreferences.Editor? = null
    private const val SHARED_PREFERENCES = "TodoSharedPreferences"
    private const val DATE = "date"
    private const val CLOTH = "cloth"

    fun initPrefsUtil(context: Context){
        todoSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        todoSharedPreferencesEditor = todoSharedPreferences?.edit()
    }

    var date: String?
        get() = todoSharedPreferences?.getString(DATE,null)
        set(value){
            todoSharedPreferencesEditor?.putString(DATE,value)?.apply()
        }

    var cloth: String?
        get() = todoSharedPreferences?.getString(CLOTH, "false")
        set(value){
            todoSharedPreferencesEditor?.putString(CLOTH,value)?.apply()
        }
}