package com.example.heroesapp.activities

import android.content.ClipDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.models.Heroe
import com.squareup.picasso.Picasso

class HeroeDetailActivity : AppCompatActivity() {
    private lateinit var heroeNameTextView: TextView
    private lateinit var heroeImageView: ImageView
    private lateinit var heroeDescriptionTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroe_detail)

        heroeNameTextView = findViewById(R.id.heroeNameTitle)
        heroeImageView = findViewById(R.id.heroeDetailImage)
        heroeDescriptionTextView = findViewById(R.id.heroeDescription)

        val heroeId = intent.getIntExtra("heroeId", 0)
        val heroe = Heroe.heroes.find { it.id == heroeId }
        heroeNameTextView.text = heroe?.name
        heroeDescriptionTextView.text = heroe?.description
        Picasso.get().load(heroe?.image).into(heroeImageView)
    }
}