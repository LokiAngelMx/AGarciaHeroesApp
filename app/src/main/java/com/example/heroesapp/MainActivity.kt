package com.example.heroesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import com.example.heroesapp.activities.PublisherActivity
import com.google.android.material.snackbar.Snackbar
import com.example.heroesapp.mockdata.MockData

class MainActivity : AppCompatActivity() {
    private lateinit var loginBtn: Button
    private lateinit var emailET: EditText
    private lateinit var passwordET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if (isLogged) {
            val intent = Intent(this@MainActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBtn = findViewById(R.id.loginBtn)
        emailET = findViewById(R.id.emailEditText)
        passwordET = findViewById(R.id.passwordEditText)
        loginBtn.setOnClickListener{
            Log.i("INGENIERIASOFT", "Botón presionado")
            val email = emailET.text.toString()
            val password = passwordET.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Log.i("Invalid", "Invalid data")
                Snackbar.make(it, "El correo o contraseña están vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val isValidUser = MockData.users.any { u -> u.email == email && u.password == password }
            if(!isValidUser){
                Snackbar.make(it, "El correo o contraseña no son validos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()

            val intent = Intent(this@MainActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}