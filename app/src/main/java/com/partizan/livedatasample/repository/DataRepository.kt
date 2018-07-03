package com.partizan.livedatasample.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import okhttp3.*
import java.io.IOException

class DataRepository {
    fun downloadDataAsync(): LiveData<String> {
        val liveData = MutableLiveData<String>()
        val client = OkHttpClient()
        val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                //if you use not UI thread  ->POST
                liveData.postValue(e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                //if you use not UI thread  ->POST
                liveData.postValue(response.body()?.string() ?: "")
            }
        })
        return liveData
    }
}