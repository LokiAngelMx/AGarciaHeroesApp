package com.example.heroesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.models.Heroe
import com.squareup.picasso.Picasso

class HeroeDetailAdapter(val heroes: List<Heroe>, val onClick: (Heroe) -> Unit): RecyclerView.Adapter<HeroeAdapter.HeroeViewHolder>() {
    class HeroeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val heroeTextView: TextView = view.findViewById(R.id.heroeName)
        val heroeImage: ImageView = view.findViewById(R.id.heroeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeAdapter.HeroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.heroe_item, parent, false)
        return HeroeAdapter.HeroeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun onBindViewHolder(holder: HeroeAdapter.HeroeViewHolder, position: Int) {
        val heroe = heroes[position]
        holder.heroeTextView.text = heroe.name
        Picasso.get().load(heroe.image).into(holder.heroeImage)
        holder.view.setOnClickListener {
            onClick(heroe)
        }
    }
}