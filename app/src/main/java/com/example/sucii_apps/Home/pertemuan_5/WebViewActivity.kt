package com.example.sucii_apps.Home.pertemuan_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar Back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://2sic-suci.alwaysdata.net/")
    }
}