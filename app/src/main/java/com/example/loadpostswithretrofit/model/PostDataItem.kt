package com.example.loadpostswithretrofit.model

import android.text.Html
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PostDataItem(
    @SerializedName("userId") @Expose var userId: String,
    @SerializedName("id") @Expose var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("body") @Expose var body: String

) : Serializable {

    fun getCleanUpBody(): String = Html.fromHtml(body).toString()
}
