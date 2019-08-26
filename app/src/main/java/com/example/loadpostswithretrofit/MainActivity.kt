package com.example.loadpostswithretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.loadpostswithretrofit.api.APIClient
import com.example.loadpostswithretrofit.api.ApiInterface
import com.example.loadpostswithretrofit.model.PostDataItem
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = APIClient.SingletonConfig.getRetrofit()?.create(ApiInterface::class.java)
        val single = apiInterface!!.doGetPosts()

        single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<List<PostDataItem>>> {

                override fun onSuccess(response: Response<List<PostDataItem>>) {
                    if (response.isSuccessful) {
                        response.body()!!.forEach { t: PostDataItem? ->
                            //todo
                        }
                    }

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    //todo
                }


            })
    }
}
