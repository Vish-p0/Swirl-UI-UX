package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeBack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_back)

        // Set up back button click listener
        val backButton = findViewById<TextView>(R.id.back_button)
        backButton.setOnClickListener {
            // Navigate back to OtpVerificationScreen2
            val intent = Intent(this, OtpVerificationScreen2::class.java)
            startActivity(intent)
            finish()
        }

        // Set up proceed button click listener
        val proceedButton = findViewById<Button>(R.id.proceedButton)
        proceedButton.setOnClickListener {
            // Navigate to the next page (Home)
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}
