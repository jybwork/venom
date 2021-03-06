package com.venom.core.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.venom.utilcode.util.Utils

open class VBaseApplication : Application() {

    companion object KApp{
        private lateinit var mContext: VBaseApplication
        fun getInstance(): Context = mContext
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this);
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        Utils.init(mContext)
    }


}