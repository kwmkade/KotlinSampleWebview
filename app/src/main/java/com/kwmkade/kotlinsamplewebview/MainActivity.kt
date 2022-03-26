package com.kwmkade.kotlinsamplewebview

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mWordEditText: EditText
    private lateinit var mLangSpinner: Spinner
    private lateinit var mSearchButton: Button

    private var mLang: String = "ja"

    private val langs = arrayOf(
        "Japanese",
        "Korean",
        "Chinese (Traditional)",
        "French",
        "Italian",
        "Dutch",
        "Portuguese",
        "Thai",
        "Malay"
    )

    val toLangCd = mapOf(
        "Japanese" to "ja",
        "Korean" to "ko",
        "Chinese (Traditional)" to "zh-TW",
        "French" to "fr",
        "Italian" to "it",
        "Dutch" to "nl",
        "Portuguese" to "pt",
        "Thai" to "th",
        "Malay" to "ms",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWordEditText = findViewById(R.id.word_text)


        mLangSpinner = findViewById<Spinner>(R.id.lang_spinner)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, langs)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mLangSpinner.adapter = adapter
        mLangSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val langName = parent.getItemAtPosition(position)
                mLang = toLangCd[langName] as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        mSearchButton = findViewById(R.id.search_btn)

        mSearchButton.setOnClickListener {
            val word = mWordEditText.text.toString()
            WebviewDialogFragment.Builder()
                .setUrl("https://translate.google.com/m?sl=en&tl=${mLang}&hl=en&q=${word}")
                .build()
                .show(supportFragmentManager, WebviewDialogFragment::class.simpleName)
        }
    }
}