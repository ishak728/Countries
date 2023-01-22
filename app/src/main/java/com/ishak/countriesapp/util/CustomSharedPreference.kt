package com.ishak.countriesapp.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit
import java.util.prefs.Preferences

class CustomSharedPreference {

    companion object{

        private val PREFERENCES_TIME="preferences_time"

    private var sharedPreference:SharedPreferences?=null

    @Volatile private var instance:CustomSharedPreference?=null
    private var lock=Any()

    operator fun invoke(context:Context):CustomSharedPreference=instance?: synchronized(lock){
        instance?:makeCustomSharedPreference(context)
    }

    private fun makeCustomSharedPreference(context: Context):CustomSharedPreference{
        sharedPreference=PreferenceManager.getDefaultSharedPreferences(context)
        return CustomSharedPreference()
    }


    }
    fun saveTime(time:Long){
        sharedPreference?.edit(commit=true){
           putLong(PREFERENCES_TIME,time)
        }
    }
    fun getTime()= sharedPreference?.getLong(PREFERENCES_TIME,0)


}