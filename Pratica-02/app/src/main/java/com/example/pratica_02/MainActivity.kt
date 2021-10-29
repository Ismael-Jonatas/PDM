package com.example.pratica_02

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    private lateinit var seekBar1: SeekBar
    private lateinit var seekBar2: SeekBar
    private lateinit var corTela: LinearLayout
    private lateinit var codCor: TextView
    private var cordavez by Delegates.notNull<Long>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.seekBar = findViewById(R.id.tvSb_0)
        this.seekBar1 = findViewById(R.id.tvSb_1)
        this.seekBar2 = findViewById(R.id.tvSb_2)
        this.corTela = findViewById(R.id.tvColor)
        this.codCor = findViewById(R.id.tvCodColor)

        this.seekBar.setOnSeekBarChangeListener(OnChange())
        this.seekBar1.setOnSeekBarChangeListener(OnChange())
        this.seekBar2.setOnSeekBarChangeListener(OnChange())

        this.corTela.setBackgroundColor(retornacor())
        this.codCor.setText(Integer.toHexString(retornacor()).subSequence(2,8))

    }

    fun retornacor(): Int {
        val cores = Color.rgb(this.seekBar.progress, seekBar1.progress, seekBar2.progress)
        cordavez = cores.toLong()
        return cores
    }

    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            corTela.setBackgroundColor(retornacor())
            codCor.setText(Integer.toHexString(retornacor()).subSequence(2,8))

            fun retornacor(): Int {
                val cores = Color.rgb(this@MainActivity.seekBar.progress, seekBar1.progress, seekBar2.progress)
                cordavez = cores.toLong()
                return cores
            }

        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }
}