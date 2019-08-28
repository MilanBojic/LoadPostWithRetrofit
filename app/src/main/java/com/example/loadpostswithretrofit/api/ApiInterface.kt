package com.example.loadpostswithretrofit.api

import com.example.loadpostswithretrofit.model.PostDataItem
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    fun doGetPosts(): Single<Response<List<PostDataItem>>>
}
