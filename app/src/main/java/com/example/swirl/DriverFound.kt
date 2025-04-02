package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DriverFound : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.driver_found)

        val btnContinue = findViewById<Button>(R.id.btnContinue)
        // Navigation for Continue button
        btnContinue.setOnClickListener {
            // Replace NextActivity with the actual destination activity
            val intent = Intent(this, OrderSummary::class.java)
            startActivity(intent)
        }
    }
}