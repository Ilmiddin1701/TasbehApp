package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var name:String
        get() = preferences.getString("name", "null")!!
        set(value) = preferences.edit {
            if (value!=null){
                it.putString("name", value)
            }
        }

    var myCounter:Int
        get() = preferences.getInt("keyCount", 0)
        set(value) = preferences.edit{
            it.putInt("keyCount", value)
        }

    var myCounter2:Int
        get() = preferences.getInt("keyCount1", 0)
        set(value) = preferences.edit{
            it.putInt("keyCount1", value)
        }
}