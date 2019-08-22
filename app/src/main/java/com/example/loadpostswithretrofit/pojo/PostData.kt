package com.example.loadpostswithretrofit.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostData(
    @SerializedName("userId") @Expose var userId: String,
    @SerializedName("id") @Expose var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("body") @Expose var body: String

)
