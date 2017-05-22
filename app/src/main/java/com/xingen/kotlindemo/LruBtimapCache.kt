package com.xingen.kotlindemo

import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.toolbox.ImageLoader


/**
 * Created by ${新根} on 2017/5/21 0021.
 * 博客：http://blog.csdn.net/hexingen
 */

/***
 *   LruBitmapCache主构造函数中，指定一个默认值。
 *
 *   LruBitmapCache带有主构造函数，因此超类（这里是LruCache）必须在主构造函数中初始化。
 *
 */
class LruBtimapCache (size: Int= defaultSize ): LruCache<String,Bitmap>(size) ,ImageLoader.ImageCache{

    override fun getBitmap(url: String): Bitmap ?{
        return get(url)
    }
    override fun putBitmap(url: String?, bitmap: Bitmap?) {
        put(url,bitmap)
    }
    override fun sizeOf(key: String, value: Bitmap): Int {
        return   value.rowBytes*value.height/1024
    }
    /**
     * 使用Companion关键字，伴生对象类名，可以省略。
     */
    companion object{
        /**
         *  val声明一个只读的变量
         *
         */
         val  defaultSize: Int get() {
             val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
             val cacheSize = maxMemory / 8
             return cacheSize
         }
    }
}