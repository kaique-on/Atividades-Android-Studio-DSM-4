package com.example.atividadesmario.aula11.ex6_disciplinas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R


class DisciplinaDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina_detalhe)

        val nome = intent.getStringExtra("nome") ?: ""
        val professor = intent.getStringExtra("professor") ?: ""
        val descricao = intent.getStringExtra("descricao") ?: ""
        val imagemRes = intent.getIntExtra("imagemRes", 0)

        findViewById<TextView>(R.id.tvNomeDisciplina).text = nome
        findViewById<TextView>(R.id.tvProfessor).text = professor
        findViewById<TextView>(R.id.tvDescricao).text = descricao
        if (imagemRes != 0)
            findViewById<ImageView>(R.id.imgDisciplina).setImageResource(imagemRes)
    }
}
