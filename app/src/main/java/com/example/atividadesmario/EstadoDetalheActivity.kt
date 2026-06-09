package com.example.atividadesmario.aula11.ex5_estados

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R


class EstadoDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estados_detalhe)

        val nome = intent.getStringExtra("nome") ?: ""
        val capital = intent.getStringExtra("capital") ?: ""
        val imagemRes = intent.getIntExtra("imagemRes", 0)

        findViewById<TextView>(R.id.tvNomeEstado).text = nome
        findViewById<TextView>(R.id.tvCapital).text = "Capital: $capital"
        if (imagemRes != 0)
            findViewById<ImageView>(R.id.imgEstado).setImageResource(imagemRes)
    }
}
