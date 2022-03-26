package com.kwmkade.kotlinsamplewebview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.DialogFragment

private const val ARG_PARAM_URL = "param_url"

class WebviewDialogFragment : DialogFragment() {

    private var mParamUrl: String? = null
    private lateinit var mCloseButton: Button
    private lateinit var mWebview: WebView

    class Builder {
        private val mBundle = Bundle()

        fun setUrl(url: String): Builder {
            return this.apply {
                mBundle.putString(ARG_PARAM_URL, url)
            }
        }

        fun build(): WebviewDialogFragment {
            return WebviewDialogFragment().apply {
                arguments = mBundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            mParamUrl = bundle.getString(ARG_PARAM_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_webview_dialog, container, false)
        mCloseButton = view.findViewById(R.id.close_button)
        mWebview = view.findViewById(R.id.webview)

        dialog?.setCanceledOnTouchOutside(false)

        mCloseButton.setOnClickListener {
            dismiss()
        }

        mWebview.webViewClient = object : WebViewClient() {}
        mWebview.loadUrl(mParamUrl as String)

        return view
    }
}