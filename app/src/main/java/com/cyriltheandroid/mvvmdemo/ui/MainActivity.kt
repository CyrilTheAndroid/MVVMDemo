package com.cyriltheandroid.mvvmdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.cyriltheandroid.mvvmdemo.R
import com.cyriltheandroid.mvvmdemo.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObservers()
        textView = findViewById(R.id.text_view)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            viewModel.getList()
        }
    }

    private fun initObservers() {
        viewModel.liveData.observe(this) { list ->
            textView.text = list[1]
        }
    }
}