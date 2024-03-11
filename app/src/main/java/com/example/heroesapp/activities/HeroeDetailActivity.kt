package com.example.heroesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.models.Heroe

class HeroeDetailActivity : AppCompatActivity() {
    private lateinit var heroeDetailRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroe_detail)

        val heroeId = intent.getIntExtra("heroeId", 0)
        val heroe = Heroe.heroes.filter { it.id == heroeId }

        heroeDetailRecyclerView = findViewById(R.id.heroeDetailRecyclerView)
        heroeDetailRecyclerView.adapter = HeroeDetailAdapter(heroe) { heroe ->
            Log.i("Heroe Clicked", heroe.name)
            val intent = Intent(this, HeroeDetailActivity::class.java).apply {
                putExtra("heroeId", heroe.id)
            }
            startActivity(intent)
        }
    }
}