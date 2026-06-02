package com.example.atividadesmario.aula09.ex1_geometria_areas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R

class GeometriaAreasActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var layoutCirculo: LinearLayout
    private lateinit var layoutRetangulo: LinearLayout
    private lateinit var layoutTriangulo: LinearLayout
    private lateinit var edtRaio: EditText
    private lateinit var edtBaseRect: EditText
    private lateinit var edtAlturaRect: EditText
    private lateinit var edtBaseTri: EditText
    private lateinit var edtAlturaTri: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geometria_areas)

        radioGroup = findViewById(R.id.radioGroup)
        layoutCirculo = findViewById(R.id.layoutCirculo)
        layoutRetangulo = findViewById(R.id.layoutRetangulo)
        layoutTriangulo = findViewById(R.id.layoutTriangulo)
        edtRaio = findViewById(R.id.edtRaio)
        edtBaseRect = findViewById(R.id.edtBaseRect)
        edtAlturaRect = findViewById(R.id.edtAlturaRect)
        edtBaseTri = findViewById(R.id.edtBaseTri)
        edtAlturaTri = findViewById(R.id.edtAlturaTri)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            layoutCirculo.visibility = if (checkedId == R.id.rbCirculo) View.VISIBLE else View.GONE
            layoutRetangulo.visibility = if (checkedId == R.id.rbRetangulo) View.VISIBLE else View.GONE
            layoutTriangulo.visibility = if (checkedId == R.id.rbTriangulo) View.VISIBLE else View.GONE
        }

        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val area = when (radioGroup.checkedRadioButtonId) {
            R.id.rbCirculo -> {
                val r = edtRaio.text.toString().toDoubleOrNull()
                if (r == null) { tvResultado.text = getString(R.string.erro_valor_invalido); return }
                Math.PI * r * r
            }
            R.id.rbRetangulo -> {
                val b = edtBaseRect.text.toString().toDoubleOrNull()
                val h = edtAlturaRect.text.toString().toDoubleOrNull()
                if (b == null || h == null) { tvResultado.text = getString(R.string.erro_valor_invalido); return }
                b * h
            }
            R.id.rbTriangulo -> {
                val b = edtBaseTri.text.toString().toDoubleOrNull()
                val h = edtAlturaTri.text.toString().toDoubleOrNull()
                if (b == null || h == null) { tvResultado.text = getString(R.string.erro_valor_invalido); return }
                b * h / 2
            }
            else -> {
                tvResultado.text = getString(R.string.erro_selecione_figura)
                return
            }
        }
        tvResultado.text = getString(R.string.area_format, area)
    }
}
