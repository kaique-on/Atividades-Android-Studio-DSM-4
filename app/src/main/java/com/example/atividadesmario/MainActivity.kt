package com.example.atividadesmario

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atividadesmario.aula08.ex1_trigonometria.TrigonometriaActivity
import com.example.atividadesmario.aula08.ex2_movimento_uniforme.MovimentoUniformeActivity
import com.example.atividadesmario.aula08.ex3_energia_mecanica.EnergiaMecanicaActivity
import com.example.atividadesmario.aula09.ex1_geometria_areas.GeometriaAreasActivity
import com.example.atividadesmario.aula09.ex2_lei_ohm.LeiOhmActivity
import com.example.atividadesmario.aula10.ex1_produtos.ProdutosActivity
import com.example.atividadesmario.aula10.ex2_lanchonete.LanchoneteActivity
import com.example.atividadesmario.aula10.ex3_papelaria.PapelariaActivity
import com.example.atividadesmario.aula10.ex4_combustivel.CombustivelActivity
import com.example.atividadesmario.aula11.ex5_estados.EstadosActivity
import com.example.atividadesmario.aula11.ex6_disciplinas.DisciplinasActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val atividades = listOf(
            AtividadeItem("Aula 8", "Trigonometria", "Seno, cosseno e tangente") { TrigonometriaActivity::class.java },
            AtividadeItem("Aula 8", "Movimento Uniforme", "Cálculo de d, v e t") { MovimentoUniformeActivity::class.java },
            AtividadeItem("Aula 8", "Energia Mecânica", "Ep, Ec e Em") { EnergiaMecanicaActivity::class.java },
            AtividadeItem("Aula 9", "Geometria de Áreas", "Círculo, retângulo e triângulo") { GeometriaAreasActivity::class.java },
            AtividadeItem("Aula 9", "Lei de Ohm", "Tensão, corrente e resistência") { LeiOhmActivity::class.java },
            AtividadeItem("Aula 10", "Produtos", "Spinner com cálculo de total") { ProdutosActivity::class.java },
            AtividadeItem("Aula 10", "Lanchonete", "Spinner com desconto de 5%") { LanchoneteActivity::class.java },
            AtividadeItem("Aula 10", "Papelaria", "Spinner com taxa de 10%") { PapelariaActivity::class.java },
            AtividadeItem("Aula 10", "Combustível", "Spinner com preço por litro") { CombustivelActivity::class.java } ,
            AtividadeItem("Aula 11", "Estados Brasileiros", "Lista com capital e foto") { EstadosActivity::class.java },
            AtividadeItem("Aula 11", "Disciplinas do Curso", "Lista com professor e descrição") { DisciplinasActivity::class.java },
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAtividades)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AtividadeAdapter(atividades) { item ->
            startActivity(Intent(this, item.destino()))
        }
    }
}
