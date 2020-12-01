package com.example.desafiowebservices

import android.annotation.SuppressLint
import android.icu.number.NumberFormatter.with
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.hq_item.view.*

class HqsAdapter(private val hqsList: Res, private val listener: OnItemClickListener): RecyclerView.Adapter<HqsAdapter.HqsViewHolder>()  {
    inner class HqsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nome: TextView = itemView.item_nome
        val poster: ImageView = itemView.item_poster
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.hq_item, parent, false)
        return HqsViewHolder(itemView)
    }

    override fun getItemCount() = hqsList.data.results.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HqsViewHolder, position: Int) {
        val itemAtual = hqsList.data.results[position]
        holder.nome.text = "#${itemAtual.issueNumber}"
        Picasso.get().load(Uri.parse("${itemAtual.thumbnail.path}.${itemAtual.thumbnail.extension}")).into(holder.poster)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}