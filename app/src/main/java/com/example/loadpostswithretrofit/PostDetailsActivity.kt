package com.example.loadpostswithretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.example.loadpostswithretrofit.model.PostDataItem

open class PostDetailsActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<PostDataItem>
    internal val TAG = PostDetailsActivity::class.java.simpleName
    lateinit var title: TextView
    lateinit var desc: TextView
    internal lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        if (intent != null && intent.extras.get("list") != null) {
            list = intent.extras.get("list") as ArrayList<PostDataItem>
            list.forEach({ t -> Log.i("XXX", t.body) })
        }
        initViews()
    }

    private fun initViews() {
        mRecyclerView = findViewById(R.id.details_recycler_view)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerView.layoutManager = linearLayoutManager
        val postDescAdapter = PostDescAdapter(this, list)
        mRecyclerView.adapter = postDescAdapter
    }

}
