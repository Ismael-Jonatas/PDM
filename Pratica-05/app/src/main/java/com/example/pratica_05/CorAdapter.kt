package com.example.pratica_05

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CorAdapter(var context: Context, var cores: ArrayList<Cor>): BaseAdapter() {
    override fun getCount(): Int {
        return this.cores.size
    }

    override fun getItem(position: Int): Any {
        return this.cores[position]
    }

    override fun getItemId(position: Int): Long {
        return this.cores[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = if (convertView == null){
            LayoutInflater.from(context).inflate(R.layout.cor_layout, parent, false)
        }else{
            convertView
        }
        val tvNome = view.findViewById<TextView>(R.id.tvCorNome)
        val tvCodigo = view.findViewById<TextView>(R.id.tvCorCodigo)
        val ivIcone = view.findViewById<ImageView>(R.id.ivCorIcone)
        val cor = this.cores[position]
        tvNome.text = cor.nome
        tvCodigo.text = cor.codigo
        ivIcone.setColorFilter(cor.color())
        return view
    }
}