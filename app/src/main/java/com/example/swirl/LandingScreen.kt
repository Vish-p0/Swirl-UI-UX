package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LandingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_screen)

        // Hide the action bar for full screen experience
        supportActionBar?.hide()

        // Set up login button click listener
        val loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {
            // Navigate to login page
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }

        // Set up sign up button click listener
        val signupButton = findViewById<Button>(R.id.btn_signup)
        signupButton.setOnClickListener {
            // Navigate to signup page
            val intent = Intent(this, SignupScreen::class.java)
            startActivity(intent)
        }
    }
}