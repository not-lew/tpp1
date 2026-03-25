package br.unisanta.destinosturisticos

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NavegadorActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegador)

        val link = intent.getStringExtra("link") ?: ""
        val titulo = intent.getStringExtra("titulo") ?: "Destino"

        val tvTopo = findViewById<TextView>(R.id.tvTopo)
        val btnRetornar = findViewById<Button>(R.id.btnRetornar)
        webView = findViewById(R.id.webView)

        tvTopo.text = titulo

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.loadUrl(link)

        btnRetornar.setOnClickListener {
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
