package com.kwmkade.kotlinsamplewebview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mUrlEditText: EditText
    private lateinit var mSearchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUrlEditText = findViewById(R.id.url_et)
        mSearchButton = findViewById(R.id.search_btn)
    }
}