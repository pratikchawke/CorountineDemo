package com.pratik.coroutinesexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class User(

    @Expose
    @SerializedName("email")
    val email: String? = null,

    @Expose
    @SerializedName("name")
    val username: String? = null,

    @Expose
    @SerializedName("image")
    val image: String? = null,

    @Expose
    @SerializedName("id")
    val id: Int? = null
) {
    override fun toString(): String {
        return "User(email=$email, name=$username, image=$image, id=$id)"
    }
}