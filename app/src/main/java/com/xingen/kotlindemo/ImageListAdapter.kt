package com.xingen.kotlindemo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView

/**
 * Created by ${新根} on 2017/5/21 0021.
 * 博客：http://blog.csdn.net/hexingen
 */
class ImageListAdapter(movieList: List<MovieList.Movie>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    /**
     * 指定一个全局的变量，从主构造函数中获取到参数，进行初始化
     */
    var list = movieList

    /**
     * 加载的数量
     */
    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * 创建 ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var rootView = View.inflate(parent.context, R.layout.item_imagelist_layout, null)

        return ViewHolder(rootView)
    }

    /**
     *  绑定ViewHolder,进行加载数据
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadImage(position)
    }
    /**
     *  inner修饰内部类
     */
    inner class ViewHolder(var rootView: View) : RecyclerView.ViewHolder(rootView) {

        /**
         * 构建一个加载数据的方法，参数为RecyclerView中的当前的位置
         */
        fun loadImage(position: Int) {
            var iv = rootView.findViewById(R.id.imagelist_iv) as NetworkImageView
            var title = rootView.findViewById(R.id.imagelist_title) as TextView

            /**
             *  this@类名的方式，拿到需要对应类的this指向。
             */

            var  adapter=this@ImageListAdapter


            /**
             *   NetWorkImageView开始加载图片
             */
            iv.setDefaultImageResId(R.mipmap.ic_launcher)
            iv.setErrorImageResId(R.mipmap.ic_launcher)
            iv.setImageUrl(adapter.list[position].images.large,VolleySingletion.imageLoader)

            title.text=adapter.list[position].title
        }
    }
}