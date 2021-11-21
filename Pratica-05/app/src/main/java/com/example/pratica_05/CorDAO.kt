package com.example.pratica_05

import android.content.ContentValues
import android.content.Context

class CorDAO{

    private var bancoCor: CorHelper

    constructor(context: Context){
        this.bancoCor = CorHelper(context)
    }

    fun insert(cor: Cor){
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)
        this.bancoCor.writableDatabase.insert("cores", null, cv)
    }

    fun count(): Int{
        val sql = "select count(id) from cores"
        val cursor = this.bancoCor.readableDatabase.rawQuery(sql, null)
        cursor.moveToFirst()
        return cursor.getInt(0)
    }

    fun select(): ArrayList<Cor>{
        val lista = arrayListOf<Cor>()
        val colunas = arrayOf("id", "nome", "codigo")
        val cursor = this.bancoCor.readableDatabase.query("cores", colunas, null, null, null, null, "nome")
        cursor.moveToFirst()
        for (i in 1..cursor.count){
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val codigo = cursor.getString(2)
            lista.add(Cor(id, nome, codigo))
            cursor.moveToNext()
        }
        return lista
    }

    fun find(id: Int): Cor?{
        val colunas = arrayOf("id", "nome", "codigo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.bancoCor.readableDatabase.query("cores", colunas, where, pWhere, null, null, null)
        cursor.moveToFirst()
        if (cursor.count == 1){
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val codigo = cursor.getString(2)
            return Cor(id, nome, codigo)
        }
        return null
    }

    fun update(cor: Cor){
        val where = "id = ?"
        val pWhere = arrayOf(cor.id.toString())
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)
        this.bancoCor.writableDatabase.update("cores", cv, where, pWhere)
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.bancoCor.writableDatabase.delete("cores", where, pWhere)
    }

}