package com.example.atividadesmario.aula11.ex5_estados


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.atividadesmario.R
import androidx.appcompat.app.AppCompatActivity

data class Estado(val nome: String, val capital: String, val imagemRes: Int)

class EstadosActivity : AppCompatActivity() {

    private val estados = listOf(
        Estado("Acre", "Rio Branco", R.drawable.img_ac),
        Estado("Alagoas", "Maceió", R.drawable.img_al),
        Estado("Amapá", "Macapá", R.drawable.img_ap),
        Estado("Amazonas", "Manaus", R.drawable.img_am),
        Estado("Bahia", "Salvador", R.drawable.img_ba),
        Estado("Ceará", "Fortaleza", R.drawable.img_ce),
        Estado("Distrito Federal", "Brasília", R.drawable.img_df),
        Estado("Espírito Santo", "Vitória", R.drawable.img_es),
        Estado("Goiás", "Goiânia", R.drawable.img_go),
        Estado("Maranhão", "São Luís", R.drawable.img_ma),
        Estado("Mato Grosso", "Cuiabá", R.drawable.img_mt),
        Estado("Mato Grosso do Sul", "Campo Grande", R.drawable.img_ms),
        Estado("Minas Gerais", "Belo Horizonte", R.drawable.img_mg),
        Estado("Pará", "Belém", R.drawable.img_pa),
        Estado("Paraíba", "João Pessoa", R.drawable.img_pb),
        Estado("Paraná", "Curitiba", R.drawable.img_pr),
        Estado("Pernambuco", "Recife", R.drawable.img_pe),
        Estado("Piauí", "Teresina", R.drawable.img_pi),
        Estado("Rio de Janeiro", "Rio de Janeiro", R.drawable.img_rj),
        Estado("Rio Grande do Norte", "Natal", R.drawable.img_rn),
        Estado("Rio Grande do Sul", "Porto Alegre", R.drawable.img_rs),
        Estado("Rondônia", "Porto Velho", R.drawable.img_ro),
        Estado("Roraima", "Boa Vista", R.drawable.img_rr),
        Estado("Santa Catarina", "Florianópolis", R.drawable.img_sc),
        Estado("São Paulo", "São Paulo", R.drawable.img_sp),
        Estado("Sergipe", "Aracaju", R.drawable.img_se),
        Estado("Tocantins", "Palmas", R.drawable.img_to)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estados)

        val listView = findViewById<ListView>(R.id.listViewEstados)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            estados.map { it.nome }
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val estado = estados[position]
            val intent = Intent(this, EstadoDetalheActivity::class.java)
            intent.putExtra("nome", estado.nome)
            intent.putExtra("capital", estado.capital)
            intent.putExtra("imagemRes", estado.imagemRes)
            startActivity(intent)
        }
    }
}
