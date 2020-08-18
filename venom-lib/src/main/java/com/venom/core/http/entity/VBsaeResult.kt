package com.venom.core.http.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class VBsaeResult<T> : Serializable {
    @SerializedName("message")
    var message: String? = ""

    @SerializedName("status")
    var status: String? = ""

    @SerializedName("data")
    var data: T? = null
}