package com.example.pratica_05

import android.graphics.Color
import java.io.Serializable

var CODIGO = 0L
class Cor:Serializable{
    var id: Int
    var nome: String
    var codigo: String

    constructor(nome: String, codigo: String){
        this.id = -1
        this.nome = nome
        this.codigo = codigo
    }

    constructor(id: Int, nome: String, codigo: String){
        this.id = id
        this.nome = nome
        this.codigo = codigo
    }


    fun color(): Int{
        return Color.parseColor("#${this.codigo}")
    }

    override fun toString(): String {
        return "${this.nome} ${this.codigo}"
    }

}