package com.example.heroesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.MainActivity
import com.example.heroesapp.adapters.PublisherAdapter
import com.example.heroesapp.models.Publisher

class PublisherActivity : AppCompatActivity() {
    private lateinit var publisherRecyclerView: RecyclerView
    private lateinit var logoutBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publisher)

        logoutBtn = findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", false)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        publisherRecyclerView = findViewById(R.id.publisherRecyclerView)
        publisherRecyclerView.adapter = PublisherAdapter(Publisher.publishers){ publisher ->
            Log.i("Publisher Clicked", publisher.name)
            val intent = Intent(this, HeroeActivity::class.java).apply {
                putExtra("publisherId", publisher.id)
            }
            startActivity(intent)
        }
        publisherRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}