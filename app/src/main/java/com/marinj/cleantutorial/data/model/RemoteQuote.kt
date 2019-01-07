package com.marinj.cleantutorial.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class RemoteQuote(@SerializedName("author") @Expose var author: String,
                       @SerializedName("message") @Expose var message: String)


