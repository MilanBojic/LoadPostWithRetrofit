package com.example.loadpostswithretrofit.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.loadpostswithretrofit.R
import com.example.loadpostswithretrofit.model.PostDataItem
import io.reactivex.subjects.PublishSubject

class PostDataListAdapter(
    private val mContext: Context,
    private val mDataList: ArrayList<PostDataItem>
) : RecyclerView.Adapter<PostDataListAdapter.DataObjectHolder>() {
    var disposable: PublishSubject<Any> = PublishSubject.create()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataObjectHolder {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.main_item, parent, false)

        return DataObjectHolder(view)

    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        val postDataItem = mDataList.get(position)

        holder.user.setText(mContext.getText(R.string.postFromTheUser).toString() + " " + postDataItem.userId)
        holder.user.setOnClickListener({ v ->
            disposable.onNext(postDataItem.userId)
        })
    }


    override fun getItemCount(): Int {
        return mDataList.size
    }

    open class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var user: TextView

        init {
            user = itemView.findViewById(R.id.main_item_user)

        }
    }



}
