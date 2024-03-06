package com.rana.muncakapp

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context){

    private val PREFS_NAME = "sharedprefkotlin12345"
    private var sharedpref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedpref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedpref.edit()
    }

    fun put(key:String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key : String?) : String? {
        return sharedpref.getString(key, null)
    }

    fun put(key:String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key : String?) : Boolean? {
        return sharedpref.getBoolean(key, false)
    }

    fun put(key:String, value: Int){
        editor.putInt(key, value)
            .apply()
    }

    fun getInt(key : String?) : Int? {
        return sharedpref.getInt(key, 0)
    }

    fun clear() {
        editor.clear()
            .apply()
    }

}