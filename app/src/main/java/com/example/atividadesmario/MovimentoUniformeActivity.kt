package com.example.atividadesmario.aula08.ex2_movimento_uniforme

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R

class MovimentoUniformeActivity : AppCompatActivity() {

    private lateinit var edtDistancia: EditText
    private lateinit var edtVelocidade: EditText
    private lateinit var edtTempo: EditText
    private lateinit var cbDistancia: CheckBox
    private lateinit var cbVelocidade: CheckBox
    private lateinit var cbTempo: CheckBox
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimento_uniforme)

        edtDistancia = findViewById(R.id.edtDistancia)
        edtVelocidade = findViewById(R.id.edtVelocidade)
        edtTempo = findViewById(R.id.edtTempo)
        cbDistancia = findViewById(R.id.cbDistancia)
        cbVelocidade = findViewById(R.id.cbVelocidade)
        cbTempo = findViewById(R.id.cbTempo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val marcados = listOf(cbDistancia.isChecked, cbVelocidade.isChecked, cbTempo.isChecked).count { it }
        if (marcados != 1) {
            tvResultado.text = getString(R.string.erro_selecione_uma_opcao)
            return
        }

        when {
            cbDistancia.isChecked -> {
                val v = edtVelocidade.text.toString().toDoubleOrNull()
                val t = edtTempo.text.toString().toDoubleOrNull()
                if (v == null || t == null) {
                    tvResultado.text = getString(R.string.erro_preencha_v_t)
                    return
                }
                val d = v * t
                tvResultado.text = getString(R.string.resultado_distancia, d)
            }
            cbVelocidade.isChecked -> {
                val d = edtDistancia.text.toString().toDoubleOrNull()
                val t = edtTempo.text.toString().toDoubleOrNull()
                if (d == null || t == null || t == 0.0) {
                    tvResultado.text = getString(R.string.erro_preencha_d_t)
                    return
                }
                val v = d / t
                tvResultado.text = getString(R.string.resultado_velocidade, v)
            }
            cbTempo.isChecked -> {
                val d = edtDistancia.text.toString().toDoubleOrNull()
                val v = edtVelocidade.text.toString().toDoubleOrNull()
                if (d == null || v == null || v == 0.0) {
                    tvResultado.text = getString(R.string.erro_preencha_d_v)
                    return
                }
                val t = d / v
                tvResultado.text = getString(R.string.resultado_tempo, t)
            }
        }
    }
}
