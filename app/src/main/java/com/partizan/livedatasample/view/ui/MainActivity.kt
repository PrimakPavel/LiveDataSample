package com.partizan.livedatasample.view.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.partizan.livedatasample.R
import com.partizan.livedatasample.viewmodel.EditTextViewModel

class MainActivity : AppCompatActivity() {
    private var mTextViewModel: EditTextViewModel? = null
    private var mEditText: EditText? = null
    private var mTextView: TextView? = null
    private var mButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        mTextViewModel = ViewModelProviders.of(this).get(EditTextViewModel::class.java)
        mTextViewModel?.getCurrentName()?.observe(this, textObserver)
    }

    private fun initView() {
        mEditText = findViewById(R.id.input_et)
        mTextView = findViewById(R.id.output_tv)
        mButton = findViewById(R.id.button_update)
        mButton?.setOnClickListener({
            val text = mEditText?.text.toString()
            mTextViewModel?.getCurrentName()?.value = text
        })
    }

    //Text Observer
    private val textObserver = Observer<String> {
        mTextView?.setText(it)
    }


}
