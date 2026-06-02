package com.example.atividadesmario.aula08.ex1_trigonometria

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R

class TrigonometriaActivity : AppCompatActivity() {

    private lateinit var edtAngulo: EditText
    private lateinit var cbSeno: CheckBox
    private lateinit var cbCosseno: CheckBox
    private lateinit var cbTangente: CheckBox
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trigonometria)

        edtAngulo = findViewById(R.id.edtAngulo)
        cbSeno = findViewById(R.id.cbSeno)
        cbCosseno = findViewById(R.id.cbCosseno)
        cbTangente = findViewById(R.id.cbTangente)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val texto = edtAngulo.text.toString()
        if (texto.isEmpty()) {
            tvResultado.text = getString(R.string.erro_campo_vazio)
            return
        }

        val angulo = texto.toDoubleOrNull()
        if (angulo == null) {
            tvResultado.text = getString(R.string.erro_valor_invalido)
            return
        }

        if (!cbSeno.isChecked && !cbCosseno.isChecked && !cbTangente.isChecked) {
            tvResultado.text = getString(R.string.erro_nenhuma_opcao)
            return
        }

        val rad = Math.toRadians(angulo)
        val sb = StringBuilder()

        if (cbSeno.isChecked) {
            val seno = Math.sin(rad)
            sb.appendLine(getString(R.string.resultado_seno, seno))
        }
        if (cbCosseno.isChecked) {
            val cosseno = Math.cos(rad)
            sb.appendLine(getString(R.string.resultado_cosseno, cosseno))
        }
        if (cbTangente.isChecked) {
            val tangente = Math.tan(rad)
            sb.appendLine(getString(R.string.resultado_tangente, tangente))
        }

        tvResultado.text = sb.toString().trim()
    }
}
