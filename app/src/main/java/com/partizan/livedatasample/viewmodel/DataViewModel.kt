package com.partizan.livedatasample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.partizan.livedatasample.repository.DataRepository


class DataViewModel : ViewModel() {

    private var mData: LiveData<String>? = null

    fun getCurrentName(): LiveData<String>? {
        if (mData == null) {
            mData = DataRepository().downloadDataAsync()
        }
        return mData
    }

}