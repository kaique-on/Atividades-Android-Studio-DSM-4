package com.example.atividadesmario.aula10.ex4_combustivel

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R

class CombustivelActivity : AppCompatActivity() {

    private lateinit var spinnerCombustivel: Spinner
    private lateinit var imgCombustivel: ImageView
    private lateinit var edtLitros: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    private val precosPorLitro = mapOf(
        0 to 6.29,
        1 to 4.19,
        2 to 6.89
    )

    private val imagens = mapOf(
        0 to R.drawable.img_gasolina,
        1 to R.drawable.img_etanol,
        2 to R.drawable.img_diesel
    )

    private var indexSelecionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combustivel)

        spinnerCombustivel = findViewById(R.id.spinnerCombustivel)
        imgCombustivel = findViewById(R.id.imgCombustivel)
        edtLitros = findViewById(R.id.edtLitros)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.combustivel_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCombustivel.adapter = adapter

        spinnerCombustivel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                indexSelecionado = position
                imgCombustivel.setImageResource(imagens[position] ?: R.drawable.img_gasolina)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val litros = edtLitros.text.toString().toDoubleOrNull()
        if (litros == null || litros <= 0) {
            tvResultado.text = getString(R.string.erro_litros_invalidos)
            return
        }
        val preco = precosPorLitro[indexSelecionado] ?: 0.0
        val total = preco * litros
        tvResultado.text = getString(R.string.resultado_total, total)
    }
}
