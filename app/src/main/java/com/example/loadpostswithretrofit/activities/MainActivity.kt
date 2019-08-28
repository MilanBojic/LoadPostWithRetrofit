package com.example.loadpostswithretrofit.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.loadpostswithretrofit.R
import com.example.loadpostswithretrofit.adapters.PostDataListAdapter
import com.example.loadpostswithretrofit.api.APIClient
import com.example.loadpostswithretrofit.api.ApiInterface
import com.example.loadpostswithretrofit.model.PostDataItem
import com.example.loadpostswithretrofit.utils.GlobalConst
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import java.io.Serializable

class MainActivity : AppCompatActivity() {


    internal val TAG = MainActivity::class.java.simpleName
    internal var listOfPosts: ArrayList<PostDataItem> = ArrayList()
    internal lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = APIClient.SingletonConfig.getRetrofit()?.create(ApiInterface::class.java)
        val singleResponse = apiInterface!!.doGetPosts()
        initViews()

        singleResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<List<PostDataItem>>> {

                override fun onSuccess(response: Response<List<PostDataItem>>) {
                    if (response.isSuccessful) {
                        response.body()!!.forEach { postDataItem: PostDataItem? ->
                            listOfPosts.add(postDataItem!!)

                            val postItemAdapter =
                                PostDataListAdapter(
                                    this@MainActivity,
                                    listOfPosts.distinctBy { postDataItem -> postDataItem.userId } as ArrayList<PostDataItem>)
                            mRecyclerView.adapter = postItemAdapter

                            postItemAdapter.publishSubject.subscribe({ position ->
                                val intent =
                                    Intent(this@MainActivity, PostDataDetailsActivity::class.java)
                                intent.putExtra(
                                    GlobalConst.LIST_OF_POSTS,
                                    listOfPosts.filter { postDataItem -> postDataItem.userId == position } as Serializable)
                                this@MainActivity.startActivity(intent)

                            })

                        }
                    }

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    Log.i(TAG, e.printStackTrace().toString())
                }


            })

    }

    private fun initViews() {
        mRecyclerView = findViewById(R.id.main_recycler_view)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerView.layoutManager = linearLayoutManager
    }
}
