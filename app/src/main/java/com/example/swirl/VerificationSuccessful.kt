package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerificationSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verification_successful)

        // Set up back button click listener
        val backButton = findViewById<TextView>(R.id.back_button)
        backButton.setOnClickListener {
            // Navigate back to OtpVerificationScreen2
            val intent = Intent(this, OtpVerificationScreen::class.java)
            startActivity(intent)
            finish()
        }

        // Set up proceed button click listener
        val proceedButton = findViewById<Button>(R.id.proceedButton)
        proceedButton.setOnClickListener {
            // Navigate to the next page (Home)
            val intent = Intent(this, SignupForm::class.java)
            startActivity(intent)
            finish()
        }
    }
}
