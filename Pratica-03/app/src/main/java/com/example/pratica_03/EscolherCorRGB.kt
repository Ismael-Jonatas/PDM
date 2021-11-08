package com.example.pratica_03

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import kotlin.properties.Delegates

class EscolherCorRGB : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var progressSb: TextView
    private lateinit var seekBar1: SeekBar
    private lateinit var progressSb1: TextView
    private lateinit var seekBar2: SeekBar
    private lateinit var progressSb2: TextView
    private lateinit var corTela: LinearLayout
    private lateinit var codCor: TextView
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgb)

        this.seekBar = findViewById(R.id.tvSb_0)
        this.seekBar1 = findViewById(R.id.tvSb_1)
        this.seekBar2 = findViewById(R.id.tvSb_2)
        this.corTela = findViewById(R.id.tvColor)
        this.codCor = findViewById(R.id.tvCodColor)
        this.progressSb = findViewById(R.id.tsb0)
        this.progressSb1 = findViewById(R.id.tsb1)
        this.progressSb2 = findViewById(R.id.tsb2)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btCancelar = findViewById(R.id.btCancelar)

        this.seekBar.setOnSeekBarChangeListener(OnChange())
        this.seekBar1.setOnSeekBarChangeListener(OnChange())
        this.seekBar2.setOnSeekBarChangeListener(OnChange())

        this.corTela.setBackgroundColor(retornacor())
        this.codCor.setText(Integer.toHexString(retornacor()).subSequence(2,8))


        this.btSalvar.setOnClickListener { salvar() }
        this.btCancelar.setOnClickListener{
            this.finish()
        }

    }

    private fun salvar(){
        val cordavez = retornacor()
        val intent = Intent().apply {
            putExtra("CORES", cordavez)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    fun retornacor(): Int {
        val cores = Color.rgb(this.seekBar.progress, seekBar1.progress, seekBar2.progress)
        return cores
    }


    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        var i = 0
        var ii = 0
        var iii = 0
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            i = this@EscolherCorRGB.seekBar.progress
            ii = this@EscolherCorRGB.seekBar1.progress
            iii = this@EscolherCorRGB.seekBar2.progress
            progressSb.setText(""+i)
            progressSb1.setText(""+ii)
            progressSb2.setText(""+iii)

            corTela.setBackgroundColor(retornacor())
            codCor.setText(Integer.toHexString(retornacor()).subSequence(2,8))

            fun retornacor(): Int {
                val cores = Color.rgb(this@EscolherCorRGB.seekBar.progress, seekBar1.progress, seekBar2.progress)
                return cores
            }

        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

}