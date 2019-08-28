package com.example.loadpostswithretrofit.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.loadpostswithretrofit.R
import com.example.loadpostswithretrofit.adapters.PostDataDetailsAdapter
import com.example.loadpostswithretrofit.model.PostDataItem
import com.example.loadpostswithretrofit.utils.GlobalConst

open class PostDataDetailsActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<PostDataItem>
    internal val TAG = PostDataDetailsActivity::class.java.simpleName

    internal lateinit var mRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        if (intent != null && intent.extras.get(GlobalConst.LIST_OF_POSTS) != null) {
            list = intent.extras.get(GlobalConst.LIST_OF_POSTS) as ArrayList<PostDataItem>
        }
        initViews()
        setTitle(getText(R.string.postFromTheUser).toString() + " " + list.firstOrNull()!!.userId)
    }

    private fun initViews() {
        mRecyclerView = findViewById(R.id.details_recycler_view)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerView.layoutManager = linearLayoutManager
        val postDescAdapter =
            PostDataDetailsAdapter(this, list)
        mRecyclerView.adapter = postDescAdapter
    }

}
