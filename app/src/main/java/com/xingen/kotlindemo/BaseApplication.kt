package com.xingen.kotlindemo

import android.app.Application

/**
 * Created by ${新根} on 2017/5/21 0021.
 * 博客：http://blog.csdn.net/hexingen
 *
 */
class BaseApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        //初始化Volley配置
        VolleySingletion.initConfi(this)
    }
}
