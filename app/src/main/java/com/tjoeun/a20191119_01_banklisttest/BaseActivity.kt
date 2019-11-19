package com.tjoeun.a20191119_01_banklisttest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    var mContext : Context = this

    abstract fun setupEvents()
    abstract fun setValues()
}