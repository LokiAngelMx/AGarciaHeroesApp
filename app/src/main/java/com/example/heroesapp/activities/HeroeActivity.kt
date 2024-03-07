package com.example.heroesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.adapters.HeroeAdapter
import com.example.heroesapp.adapters.PublisherAdapter
import com.example.heroesapp.models.Heroe
import com.example.heroesapp.models.Publisher

class HeroeActivity : AppCompatActivity() {
    private lateinit var heroeRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroe)

        heroeRecyclerView = findViewById(R.id.heroeRecyclerView)
        heroeRecyclerView.adapter = HeroeAdapter(Heroe.heroes){ heroe ->
            Log.i("Heroe Clicked", heroe.name)
            val intent = Intent(this, HeroeActivity::class.java).apply {
                putExtra("heroeId", heroe.id)
            }
            startActivity(intent)
        }
        heroeRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}