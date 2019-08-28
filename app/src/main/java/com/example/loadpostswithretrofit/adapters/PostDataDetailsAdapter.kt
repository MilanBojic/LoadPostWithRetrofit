package com.example.loadpostswithretrofit.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.loadpostswithretrofit.R
import com.example.loadpostswithretrofit.model.PostDataItem

class PostDataDetailsAdapter(
    private val mContext: Context,
    private val mDataList: ArrayList<PostDataItem>
) : RecyclerView.Adapter<PostDataDetailsAdapter.DataObjectHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataObjectHolder {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.details_item, parent, false)

        return DataObjectHolder(
            view
        )

    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        val postDataItem = mDataList.get(position)

        holder.title.setText(postDataItem.title)
        holder.desc.setText(postDataItem.getCleanUpBody())

    }


    override fun getItemCount(): Int {
        return mDataList.size
    }

    open class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var title: TextView
        var desc: TextView

        init {
            title = itemView.findViewById(R.id.details_title)
            desc = itemView.findViewById(R.id.details_desc)


        }
    }


}
