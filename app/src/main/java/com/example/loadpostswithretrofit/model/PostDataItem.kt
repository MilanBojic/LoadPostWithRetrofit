package com.example.loadpostswithretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostDataItem(
    @SerializedName("userId") @Expose var userId: String,
    @SerializedName("id") @Expose var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("body") @Expose var body: String

)
