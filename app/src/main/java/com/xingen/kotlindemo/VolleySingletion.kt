package com.xingen.kotlindemo

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

/**
 * Created by ${新根} on 2017/5/21 0021.
 * 博客：http://blog.csdn.net/hexingen
 */


/***
 *  object 用于单例模式
 *
 *  object声明对象名后，通过对象名来访问，且不能=右边赋值。
 *
 */
object  VolleySingletion{
    /**
     * lateinit 声明一个非空变量，且不需要设置初始值。
     */
    private lateinit  var context:Context

    /**
     *  这里使用 延迟属性（lazy properties）：首次访问时计算结果，以后再次访问时候，将拷贝第一次记录的结果。
     *
     *
     *   使用形式： var p: String by lazy {   }
     *
     *   lazy()返回一个lazy<T> 的 T 对象.
     *
     *   注意点： lazy属性的计算结果的过程是同步锁的（synchronized）。
     *
     *   作用： 单例对象
     */
    val  requestQueque :RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }

    val  imageLoader :ImageLoader by lazy {
        // 不需要调用  new  关键字才创建对象
        ImageLoader(requestQueque,LruBtimapCache() )
    }

    fun  initConfi(context:Context){
        this.context =context.applicationContext
    }


}
