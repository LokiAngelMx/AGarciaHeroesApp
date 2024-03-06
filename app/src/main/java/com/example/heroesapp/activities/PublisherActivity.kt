package com.example.heroesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.heroesapp.R
import com.example.heroesapp.MainActivity

class PublisherActivity : AppCompatActivity() {
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
    }
}