package com.rohmanbeny.mov.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rohmanbeny.dicodingbeny.R
import com.rohmanbeny.dicodingbeny.model.Wisata

class WisataAdapter(private var data: List<Wisata>,
                    private val listener:(Wisata) -> Unit)
    : RecyclerView.Adapter<WisataAdapter.ViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WisataAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(
            R.layout.column_item_wisata, parent, false
        )
        return ViewHolder (inflatedView)
    }

    override fun onBindViewHolder(holder: WisataAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view :  View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.findViewById(R.id.tv_judul)
        private val tvLokasi: TextView = view.findViewById(R.id.tv_lokasi)
        private val tvRate: TextView = view.findViewById(R.id.tv_rate)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data:Wisata, listener: (Wisata) -> Unit, context : Context) {
            tvTitle.setText(data.nama)
            tvLokasi.setText(data.desc)
            tvRate.setText(data.rating)

            Glide.with(context)
                .load(data.poster)
                .into(tvImage)

            itemView.setOnClickListener{
                listener(data)
            }
        }
    }

}
