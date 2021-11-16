package com.example.pratica_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btAndroid: Button
    private lateinit var btGoogle: Button
    private lateinit var btIFPB: Button
    private lateinit var btCriarCor: Button
    private lateinit var etEndereco: EditText
    private lateinit var wv: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btAndroid = findViewById(R.id.btAndroid)
        this.btGoogle = findViewById(R.id.btGoogle)
        this.btIFPB = findViewById(R.id.btIFPB)
        this.btCriarCor = findViewById(R.id.btCriarCores)

        this.etEndereco = findViewById(R.id.etEndereco)

        this.wv = findViewById(R.id.webView)

        this.wv.webViewClient = WebViewClient()
        this.wv.settings.javaScriptEnabled = true
        this.wv.settings.setSupportZoom(true)

        this.btAndroid.setOnClickListener{ open("https://www.android.com") }
        this.btGoogle.setOnClickListener{ open("https://www.google.com") }
        this.btIFPB.setOnClickListener{ open("https://www.ifpb.edu.br") }

        this.btCriarCor.setOnClickListener {
            val intent = Intent("CRIADORDECORES")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }

        if (intent.data != null){
            this.etEndereco.setText(intent.data.toString())
            this.wv.loadUrl(intent.data.toString())
        }
    }

    private fun open(endereco: String){
        this.etEndereco.setText(endereco)
        this.wv.loadUrl(endereco)
    }
}