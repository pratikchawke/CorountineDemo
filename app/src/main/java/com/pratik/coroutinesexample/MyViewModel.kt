package com.pratik.coroutinesexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.pratik.coroutinesexample.model.User
import com.pratik.coroutinesexample.repository.MyRepository

class MyViewModel : ViewModel() {

    private val _userId : MutableLiveData<Int> = MutableLiveData()
    val user: LiveData<User> = Transformations
        .switchMap(_userId){
            MyRepository.getUser(it)
        }

    fun setUserId(userId: Int){
        val update = userId
        if (_userId.value == update) {
            return
        }
        _userId.value = update
    }

    fun cancelJobs(){
        MyRepository.cancelJobs()
    }
}