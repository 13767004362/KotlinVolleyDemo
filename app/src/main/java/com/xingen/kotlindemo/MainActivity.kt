package com.xingen.kotlindemo

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson

/**
 *  一个类继承父类和实现接口的方式; class 类名 :超类名（）,接口名
 */
class MainActivity : AppCompatActivity() {
    /**
     * override用于覆写继承父类或者实现接口中方法。
     *
     * fun 用于标识方法
     *
     * 参数形式： 参数名： 类型
     *
     *  ? 是用于指定可以为空对象
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shwoDiaglog()
        this.initView()
        this.sendRequest()

    }

    lateinit var recyclerView: RecyclerView
    /**
     * 初始化控件
     */
    fun initView() {
        recyclerView = this.findViewById(R.id.main_recycler_view) as RecyclerView
    }

    /**
     *  将网络数据加载到RecyclerView
     */
    fun loadData(movieList: List<MovieList.Movie>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ImageListAdapter(movieList)
    }

   lateinit var progressDialog: ProgressDialog
    /**
     * 显示dialog
     */
    fun shwoDiaglog() {
        progressDialog = ProgressDialog(this)
        progressDialog.show()
    }

    /**
     * 取消dialog
     */
    fun cancleDialog() {
        progressDialog.dismiss()
    }

    /**
     * Toast显示
     */

    fun loadToast(content: String?) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }

    /**
     * 发送请求,这里使用douban公开的搜索电影的API
     */
    fun sendRequest() {
        var url = "https://api.douban.com/v2/movie/search?q=张艺谋"
        val request = StringRequest(url, Response.Listener<String> {
            response ->
            var movilist = Gson().fromJson(response, MovieList::class.java)
            loadData(movilist.subjects)
            cancleDialog()

        }, Response.ErrorListener {
            error ->
            loadToast(error.message)
            cancleDialog()
        })
        // 单利类中对象的引用
        VolleySingletion.requestQueque.add(request)
    }
}
