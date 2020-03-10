package com.pratik.coroutinesexample.repository

import androidx.lifecycle.LiveData
import com.pratik.coroutinesexample.Api.MyRetrofitBuilder
import com.pratik.coroutinesexample.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MyRepository {

    var job: CompletableJob? = null

    fun getUser(userId: Int): LiveData<User> {
        job = Job()
        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { thisJob ->
                    CoroutineScope(IO + thisJob).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main) {
                            value = user
                            thisJob.complete()
                        }
                    }
                }

            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }
}