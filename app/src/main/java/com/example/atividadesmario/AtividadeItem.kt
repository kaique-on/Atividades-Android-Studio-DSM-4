package com.example.atividadesmario

data class AtividadeItem(
    val aula: String,
    val titulo: String,
    val descricao: String,
    val destino: () -> Class<*>
)
