package com.example.atividadesmario.aula11.ex6_disciplinas

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.atividadesmario.R
import com.example.atividadesmario.aula11.ex6_disciplinas.DisciplinaDetalheActivity


data class Disciplina(
    val nome: String,
    val professor: String,
    val descricao: String,
    val imagemRes: Int
)

class DisciplinasActivity : AppCompatActivity() {

    private val disciplinas = listOf(
        Disciplina(
            "Internet das Coisas e Aplicações",
            "Prof. Fernanda Pereira Gomes",
            "Estuda conceitos e tecnologias de IoT, protocolos de comunicação, " +
                    "sensores e atuadores, e o desenvolvimento de aplicações conectadas.",
            R.drawable.img_iot
        ),
        Disciplina(
            "Experiência do Usuário",
            "Prof. Eduardo Tadeu de Almeida",
            "Aborda princípios de UX/UI design, prototipagem, testes de usabilidade " +
                    "e boas práticas para criação de interfaces centradas no usuário.",
            R.drawable.img_ux
        ),
        Disciplina(
            "Programação para Dispositivos Móveis",
            "Prof. Mario da Silva de Jesus",
            "Desenvolvimento de aplicativos Android com Kotlin, uso de componentes " +
                    "nativos, navegação entre telas e integração com APIs.",
            R.drawable.img_mobile
        ),
        Disciplina(
            "Integração e Entrega Contínua",
            "Prof. Silvio Fernando Barbieri",
            "Conceitos de CI/CD, pipelines de automação, controle de versão com Git, " +
                    "testes automatizados e práticas DevOps.",
            R.drawable.img_cicd
        ),
        Disciplina(
            "Laboratório de Desenvolvimento Web",
            "Prof. Junio Cesar dos Santos Gonçalves",
            "Prática de desenvolvimento front-end e back-end, frameworks modernos, " +
                    "consumo de APIs REST e publicação de aplicações web.",
            R.drawable.img_web
        ),
        Disciplina(
            "Estatística Aplicada",
            "Prof. André Benito Fentanes Alvarez Marques",
            "Fundamentos de estatística descritiva e inferencial aplicados à análise " +
                    "de dados, probabilidade e interpretação de resultados.",
            R.drawable.img_estatistica
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplinas)

        val listView = findViewById<ListView>(R.id.listViewDisciplinas)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            disciplinas.map { it.nome }
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val disc = disciplinas[position]
            val intent = Intent(this, DisciplinaDetalheActivity::class.java)
            intent.putExtra("nome", disc.nome)
            intent.putExtra("professor", disc.professor)
            intent.putExtra("descricao", disc.descricao)
            intent.putExtra("imagemRes", disc.imagemRes)
            startActivity(intent)
        }
    }
}
