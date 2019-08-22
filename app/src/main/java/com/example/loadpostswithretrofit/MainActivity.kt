package com.example.loadpostswithretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.loadpostswithretrofit.pojo.PostData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = APIClient.SingletonConfig.getRetrofit(this)?.create(ApiInterface::class.java)
        val call = apiInterface?.doGetPosts()

        call?.enqueue(object : Callback<List<PostData>>{
            override fun onFailure(call: Call<List<PostData>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<List<PostData>>?, response: Response<List<PostData>>?) {

            }
        }


        )

    }
}
