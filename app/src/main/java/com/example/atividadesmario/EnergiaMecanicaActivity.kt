package com.example.atividadesmario.aula08.ex3_energia_mecanica

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R

class EnergiaMecanicaActivity : AppCompatActivity() {

    private val GRAVIDADE = 9.8

    private lateinit var edtMassa: EditText
    private lateinit var edtAltura: EditText
    private lateinit var edtVelocidade: EditText
    private lateinit var cbEnergiaPotencial: CheckBox
    private lateinit var cbEnergiaKinetica: CheckBox
    private lateinit var cbEnergiaMecanica: CheckBox
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energia_mecanica)

        edtMassa = findViewById(R.id.edtMassa)
        edtAltura = findViewById(R.id.edtAltura)
        edtVelocidade = findViewById(R.id.edtVelocidade)
        cbEnergiaPotencial = findViewById(R.id.cbEnergiaPotencial)
        cbEnergiaKinetica = findViewById(R.id.cbEnergiaKinetica)
        cbEnergiaMecanica = findViewById(R.id.cbEnergiaMecanica)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val m = edtMassa.text.toString().toDoubleOrNull()
        val h = edtAltura.text.toString().toDoubleOrNull()
        val v = edtVelocidade.text.toString().toDoubleOrNull()

        if (m == null || h == null || v == null) {
            tvResultado.text = getString(R.string.erro_preencha_todos)
            return
        }

        if (!cbEnergiaPotencial.isChecked && !cbEnergiaKinetica.isChecked && !cbEnergiaMecanica.isChecked) {
            tvResultado.text = getString(R.string.erro_nenhuma_opcao)
            return
        }

        val ep = m * GRAVIDADE * h
        val ec = 0.5 * m * v * v
        val em = ep + ec

        val sb = StringBuilder()

        if (cbEnergiaPotencial.isChecked) {
            sb.appendLine(getString(R.string.resultado_ep, ep))
        }
        if (cbEnergiaKinetica.isChecked) {
            sb.appendLine(getString(R.string.resultado_ec, ec))
        }
        if (cbEnergiaMecanica.isChecked) {
            sb.appendLine(getString(R.string.resultado_em, em))
        }

        tvResultado.text = sb.toString().trim()
    }
}
