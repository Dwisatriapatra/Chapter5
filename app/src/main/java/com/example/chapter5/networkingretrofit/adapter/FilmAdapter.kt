package com.example.chapter5.networkingretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapter5.R
import com.example.chapter5.networkingretrofit.model.GetAllFilmsResponseItemItem
import kotlinx.android.synthetic.main.item_adapter_film.view.*
//changed because using view model
class FilmAdapter(
    private val onClick: (GetAllFilmsResponseItemItem) -> Unit
) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    private var dataFilm: List<GetAllFilmsResponseItemItem>? = null
    fun setDataFilm(film : List<GetAllFilmsResponseItemItem>){
        this.dataFilm = film
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adapter_film, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.item_judul_film.text = dataFilm!![position].name
        holder.itemView.item_tanggal_film.text = dataFilm!![position].date
        holder.itemView.item_director_film.text = dataFilm!![position].director
        val url = dataFilm!![position].image
        Glide.with(holder.itemView.item_image_film.context)
            .load(url)
            .error(R.drawable.ic_launcher_background)
            .override(200, 100)
            .into(holder.itemView.item_image_film)
        holder.itemView.card_film.setOnClickListener {
            onClick(dataFilm!![position])
        }
    }

    override fun getItemCount(): Int {
        return if(dataFilm.isNullOrEmpty()){
            0
        }else{
            dataFilm!!.size
        }
    }

}