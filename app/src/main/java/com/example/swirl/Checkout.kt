package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Checkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout)

        // Find buttons by their IDs
        val btnGoToHome: Button = findViewById(R.id.btnGoToHome)
        val btnTrackOrder: Button = findViewById(R.id.btnTrackOrder)

        // Set click listeners for navigation
        btnGoToHome.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        btnTrackOrder.setOnClickListener {
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }
    }
}