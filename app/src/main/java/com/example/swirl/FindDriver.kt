package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class FindDriver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_driver)

        // Back button setup
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            // Navigate back to PickUpLocation
            val intent = Intent(this, PickUpLocation::class.java)
            startActivity(intent)
            finish()
        }

        // Automatic navigation to DriverFound after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DriverFound::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 milliseconds = 3 seconds
    }

    // Ensure back button behavior
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, PickUpLocation::class.java)
        startActivity(intent)
        finish()
    }
}