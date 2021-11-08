package com.example.pratica_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var corTela: LinearLayout
    private lateinit var codCor: TextView
    private lateinit var btNovaCor: Button
    private var cordavez by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.codCor = findViewById(R.id.tvCodColor)
        this.corTela = findViewById(R.id.tvColor)
        this.btNovaCor = findViewById(R.id.btNovaCor)

        val novaCor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val cordavez = it.data?.getSerializableExtra("CORES") as Int
                this.corTela.setBackgroundColor(cordavez)
                this.codCor.setText(Integer.toHexString(cordavez).subSequence(2,8))
            }else{
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
            }
        }

        this.btNovaCor.setOnClickListener{
            val intent = Intent(this, EscolherCorRGB:: class.java)
            novaCor.launch(intent)
        }

    }
}