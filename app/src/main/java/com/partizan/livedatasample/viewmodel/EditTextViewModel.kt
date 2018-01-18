package com.partizan.livedatasample.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class EditTextViewModel : ViewModel() {
    private var mCurrentText: MutableLiveData<String>? = null

    fun getCurrentName(): MutableLiveData<String> {
        if (mCurrentText == null) {
            mCurrentText = MutableLiveData<String>()
        }
        return mCurrentText as MutableLiveData<String>
    }


}