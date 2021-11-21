package com.example.pratica_05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random


class FormCorActivity : AppCompatActivity() {

    private lateinit var etNomeCor: EditText
    private lateinit var etCodCor: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cor)

        this.etNomeCor = findViewById(R.id.etFormNomeCor)
        this.etCodCor = findViewById(R.id.etFormCodCor)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ finish() }

    }

    private fun salvar(){
        val nome = this.etNomeCor.text.toString()
        val codigo = this.etCodCor.text.toString()
        val cor = Cor(nome, codigo)
        val intent = Intent().apply {
            putExtra("CORES", cor)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

}