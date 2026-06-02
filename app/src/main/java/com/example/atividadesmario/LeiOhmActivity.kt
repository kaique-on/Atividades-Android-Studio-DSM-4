package com.example.atividadesmario.aula09.ex2_lei_ohm

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R

class LeiOhmActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var layoutTensao: LinearLayout
    private lateinit var layoutCorrente: LinearLayout
    private lateinit var layoutResistencia: LinearLayout
    private lateinit var edtI_V: EditText
    private lateinit var edtR_V: EditText
    private lateinit var edtV_I: EditText
    private lateinit var edtR_I: EditText
    private lateinit var edtV_R: EditText
    private lateinit var edtI_R: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lei_ohm)

        radioGroup = findViewById(R.id.radioGroup)
        layoutTensao = findViewById(R.id.layoutTensao)
        layoutCorrente = findViewById(R.id.layoutCorrente)
        layoutResistencia = findViewById(R.id.layoutResistencia)
        edtI_V = findViewById(R.id.edtI_V)
        edtR_V = findViewById(R.id.edtR_V)
        edtV_I = findViewById(R.id.edtV_I)
        edtR_I = findViewById(R.id.edtR_I)
        edtV_R = findViewById(R.id.edtV_R)
        edtI_R = findViewById(R.id.edtI_R)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            layoutTensao.visibility = if (checkedId == R.id.rbTensao) View.VISIBLE else View.GONE
            layoutCorrente.visibility = if (checkedId == R.id.rbCorrente) View.VISIBLE else View.GONE
            layoutResistencia.visibility = if (checkedId == R.id.rbResistencia) View.VISIBLE else View.GONE
        }

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        when (radioGroup.checkedRadioButtonId) {
            R.id.rbTensao -> {
                val i = edtI_V.text.toString().toDoubleOrNull()
                val r = edtR_V.text.toString().toDoubleOrNull()
                if (i == null || r == null) { tvResultado.text = getString(R.string.erro_valor_invalido); return }
                val v = r * i
                tvResultado.text = getString(R.string.resultado_tensao, v)
            }
            R.id.rbCorrente -> {
                val v = edtV_I.text.toString().toDoubleOrNull()
                val r = edtR_I.text.toString().toDoubleOrNull()
                if (v == null || r == null || r == 0.0) { tvResultado.text = getString(R.string.erro_valor_invalido); return }
                val i = v / r
                tvResultado.text = getString(R.string.resultado_corrente, i)
            }
            R.id.rbResistencia -> {
                val v = edtV_R.text.toString().toDoubleOrNull()
                val i = edtI_R.text.toString().toDoubleOrNull()
                if (v == null || i == null || i == 0.0) { tvResultado.text = getString(R.string.erro_valor_invalido); return }
                val r = v / i
                tvResultado.text = getString(R.string.resultado_resistencia, r)
            }
            else -> {
                tvResultado.text = getString(R.string.erro_selecione_opcao)
            }
        }
    }
}
