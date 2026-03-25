package br.unisanta.destinosturisticos

import android.os.Bundle
import android.webkit.WebViewClient
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NavegadorActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegador)

        webView = findViewById(R.id.webView)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        val url = intent.getStringExtra("url") ?: ""

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
