package com.example.catalogojogos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogojogos.back.Game
import kotlinx.android.synthetic.main.item_lista.view.*
import java.text.NumberFormat
import java.util.*

class ListaGameAdapter
    internal constructor(context: Context):
    RecyclerView.Adapter<ListaGameAdapter.ViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itens = emptyList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaGameAdapter.ViewHolder {
        val view = inflater.inflate(
            R.layout.item_lista,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: ListaGameAdapter.ViewHolder, position: Int) {
        val item = itens[position]
        holder.itemNome.text = item.nome
        holder.itemStudio.text = item.estudio
        holder.itemAno.text = item.ano
        holder.itemPreco.text = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(item.preco)
    }

    inner class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){

        val itemNome: TextView = itemView.itemNome
        val itemStudio: TextView = itemView.itemStudio
        val itemPreco: TextView = itemView.itemPreco
        val itemAno: TextView = itemView.itemAno
    }

    fun setGameLista(games: List<Game>) {
        this.itens = games
        notifyDataSetChanged()
    }


}