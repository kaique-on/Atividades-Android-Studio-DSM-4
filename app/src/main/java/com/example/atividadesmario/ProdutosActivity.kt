package com.example.atividadesmario.aula10.ex1_produtos

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

class ProdutosActivity : AppCompatActivity() {

    private lateinit var spinnerProduto: Spinner
    private lateinit var imgProduto: ImageView
    private lateinit var edtQuantidade: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    private val precos = mapOf(
        0 to 5.90,
        1 to 5.50,
        2 to 4.90
    )

    private val imagens = mapOf(
        0 to R.drawable.img_produto1,
        1 to R.drawable.img_produto2,
        2 to R.drawable.img_produto3
    )

    private var indexSelecionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)

        spinnerProduto = findViewById(R.id.spinnerProduto)
        imgProduto = findViewById(R.id.imgProduto)
        edtQuantidade = findViewById(R.id.edtQuantidade)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.produtos_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerProduto.adapter = adapter

        spinnerProduto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                indexSelecionado = position
                imgProduto.setImageResource(imagens[position] ?: R.drawable.img_produto1)
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
        val total = preco * qtd
        tvResultado.text = getString(R.string.resultado_total, total)
    }
}
