package com.xingen.kotlindemo

/**
 * Created by ${新根} on 2017/5/21 0021.
 * 博客：http://blog.csdn.net/hexingen
 */

class MovieList {

    lateinit var subjects: List<Movie>

    class Movie {
       lateinit var year: String
        var title: String? = null
        var id: String? = null
        lateinit  var images: Images

        class Images {
            var small: String?= null

            var large: String? = null
        }
    }
}
