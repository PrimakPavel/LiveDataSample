package com.partizan.livedatasample.view.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.partizan.livedatasample.R
import com.partizan.livedatasample.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private var mDataViewModel: DataViewModel? = null
    private val mTextView: TextView by lazy {
        findViewById<TextView>(R.id.output_tv)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        mDataViewModel?.getCurrentName()?.observe(this, dataObserver)
    }

    //Data Observer
    private val dataObserver = Observer<String> {
        mTextView.text = it
    }

}
