package com.example.atividadesmario.aula10.ex3_papelaria

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

class PapelariaActivity : AppCompatActivity() {

    private lateinit var spinnerItem: Spinner
    private lateinit var imgItem: ImageView
    private lateinit var edtQuantidade: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    private val precos = mapOf(
        0 to 22.90,
        1 to 3.50,
        2 to 8.90
    )

    private val imagens = mapOf(
        0 to R.drawable.img_caderno,
        1 to R.drawable.img_caneta,
        2 to R.drawable.img_marcador
    )

    private var indexSelecionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_papelaria)

        spinnerItem = findViewById(R.id.spinnerItem)
        imgItem = findViewById(R.id.imgItem)
        edtQuantidade = findViewById(R.id.edtQuantidade)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.papelaria_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerItem.adapter = adapter

        spinnerItem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                indexSelecionado = position
                imgItem.setImageResource(imagens[position] ?: R.drawable.img_caderno)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val qtd = edtQuantidade.text.toString().toIntOrNull()
        if (qtd == null || qtd <= 0) {
            tvResultado.text = getString(R.string.erro_quantidade_invalida)
            return
        }
        val preco = precos[indexSelecionado] ?: 0.0
        val subtotal = preco * qtd
        val taxa = subtotal * 0.10
        val total = subtotal * 1.10

        val sb = StringBuilder()
        sb.appendLine(getString(R.string.resultado_subtotal, subtotal))
        sb.appendLine(getString(R.string.resultado_taxa, taxa))
        sb.append(getString(R.string.resultado_total, total))
        tvResultado.text = sb.toString()
    }
}
