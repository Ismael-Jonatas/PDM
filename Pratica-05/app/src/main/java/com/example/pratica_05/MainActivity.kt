package com.example.pratica_05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var cores: ArrayList<Cor>
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var DAO: CorDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.DAO = CorDAO(this)
        this.cores = ArrayList()
        this.listView = findViewById(R.id.listView)
        this.addCores()
        this.listView.adapter = CorAdapter(this, this.cores)

        this.fabAdd = findViewById(R.id.fabMainAdd)

        this.listView.onItemClickListener = OnClick()
        this.listView.onItemLongClickListener = OnLongClick()

        val novaCorResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val cordavez = it.data?.getSerializableExtra("CORES") as Cor
                this.DAO.insert(cordavez)
                this.cores = this.DAO.select()
                this.listView.adapter = CorAdapter(this, this.cores)
            }else{
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
            }
        }

        this.fabAdd.setOnClickListener{
            val intent = Intent(this, FormCorActivity::class.java)
            novaCorResult.launch(intent)
        }


    }
    inner class OnClick: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val corNova = this@MainActivity.cores.get(position)
            Toast.makeText(this@MainActivity, corNova.nome, Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnLongClick: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ): Boolean {
            // excluir a pessoa da lista
            this@MainActivity.DAO.delete(id.toInt())
            this@MainActivity.cores = DAO.select()
            this@MainActivity.listView.adapter = CorAdapter(this@MainActivity, this@MainActivity.cores)
            return true
        }
    }

    private fun addCores(){
        this.cores.add(Cor("Cor Exemplo Azul", "0000FF"))
    }

}