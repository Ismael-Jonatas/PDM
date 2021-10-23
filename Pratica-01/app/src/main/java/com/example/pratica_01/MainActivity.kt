package com.example.pratica_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var layout: ConstraintLayout
    private lateinit var cor: TextView
    private lateinit var cordavez: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.layout = findViewById(R.id.layoutview)
        this.cor = findViewById(R.id.cor)

        //Metodo 1
        this.layout.setOnClickListener {
            this.layout.setBackgroundColor(retornaCor2())
            this.cor.text = cordavez
        }

    }
    //Metodo 1
    fun retornaCor(): Int {
        val cores = listOf(Color.BLUE, Color.RED, Color.BLACK, Color.GREEN, Color.YELLOW, Color.WHITE)
        return cores.random()
    }
    //metodo 2
    fun retornaCor2(): Int{
        val cores = listOf<String>("red", "blue", "green", "black", "white", "gray", "cyan", "magenta", "yellow", "lightgray", "darkgray")
        cordavez = cores.random()
        return Color.parseColor(cordavez)
    }
}