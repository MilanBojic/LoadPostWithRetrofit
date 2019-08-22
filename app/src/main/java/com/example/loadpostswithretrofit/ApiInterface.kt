package com.example.loadpostswithretrofit

import com.example.loadpostswithretrofit.pojo.PostData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
     fun doGetPosts(): Call<List<PostData>>
}
