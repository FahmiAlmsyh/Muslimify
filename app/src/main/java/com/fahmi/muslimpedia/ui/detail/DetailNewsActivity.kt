package com.fahmi.muslimpedia.ui.detail

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.fahmi.muslimpedia.R
import com.fahmi.muslimpedia.data.model.ArticlesItem
import com.fahmi.muslimpedia.databinding.ActivityDetailNewsBinding
import com.squareup.picasso.Picasso

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    companion object {
        const val DATA_NEWS = "data_news"
        const val DATE_NEWS = "date_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Detail Berita"
        }

        val dataNews = intent.getParcelableExtra<ArticlesItem>(DATA_NEWS)
        val date = intent.getStringExtra(DATE_NEWS)

        setUpWebView(dataNews)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpWebView(dataNews: ArticlesItem?) {
        val webSettings = binding.wvDetail.settings
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        binding.wvDetail.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.loadingView.root.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.loadingView.root.visibility = View.GONE
            }
        }

        dataNews?.url?.let { binding.wvDetail.loadUrl(it) }
    }

}