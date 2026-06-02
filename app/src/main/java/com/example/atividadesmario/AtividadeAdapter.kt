package com.example.atividadesmario

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AtividadeAdapter(
    private val itens: List<AtividadeItem>,
    private val onClick: (AtividadeItem) -> Unit
) : RecyclerView.Adapter<AtividadeAdapter.ViewHolder>() {

    private var aulaAnterior = ""

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAulaHeader: TextView = view.findViewById(R.id.tvAulaHeader)
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvDescricao: TextView = view.findViewById(R.id.tvDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_atividade, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]

        if (item.aula != aulaAnterior) {
            holder.tvAulaHeader.visibility = View.VISIBLE
            holder.tvAulaHeader.text = item.aula
            aulaAnterior = item.aula
        } else {
            holder.tvAulaHeader.visibility = View.GONE
        }

        holder.tvTitulo.text = item.titulo
        holder.tvDescricao.text = item.descricao
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = itens.size
}
