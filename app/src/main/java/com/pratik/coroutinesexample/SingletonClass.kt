package com.pratik.coroutinesexample

import com.pratik.coroutinesexample.model.User

object SingletonClass {

    val singletonUser: User by lazy{
        User(
            "pratikchawke@gmail.com",
            "pratikchawke",
            "ic_launcher.png"
        )
    }
}