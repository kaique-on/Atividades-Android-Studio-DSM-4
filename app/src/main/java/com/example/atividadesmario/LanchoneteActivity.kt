package com.example.atividadesmario.aula10.ex2_lanchonete

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

class LanchoneteActivity : AppCompatActivity() {

    private lateinit var spinnerLanche: Spinner
    private lateinit var imgLanche: ImageView
    private lateinit var edtQuantidade: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    private val precos = mapOf(
        0 to 25.00,
        1 to 40.00,
        2 to 18.00
    )

    private val imagens = mapOf(
        0 to R.drawable.img_hamburguer,
        1 to R.drawable.img_pizza,
        2 to R.drawable.img_salada
    )

    private var indexSelecionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanchonete)

        spinnerLanche = findViewById(R.id.spinnerLanche)
        imgLanche = findViewById(R.id.imgLanche)
        edtQuantidade = findViewById(R.id.edtQuantidade)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.lanchonete_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLanche.adapter = adapter

        spinnerLanche.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                indexSelecionado = position
                imgLanche.setImageResource(imagens[position] ?: R.drawable.img_hamburguer)
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
        val temDesconto = qtd >= 3
        val total = if (temDesconto) subtotal * 0.95 else subtotal
        val desconto = subtotal - total

        val sb = StringBuilder()
        sb.appendLine(getString(R.string.resultado_subtotal, subtotal))
        if (temDesconto) {
            sb.appendLine(getString(R.string.resultado_desconto, desconto))
        }
        sb.append(getString(R.string.resultado_total, total))
        tvResultado.text = sb.toString()
    }
}
