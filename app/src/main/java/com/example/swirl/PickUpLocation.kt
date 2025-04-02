package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PickUpLocation : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var btnAddLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pickup_location)

        btnBack = findViewById(R.id.btnBack)
        btnAddLocation = findViewById(R.id.btnAddLocation)

        // Navigate back to HomeScreen when back button is pressed
        btnBack.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        // Navigate to PickUpLocation2 when add location button is pressed
        btnAddLocation.setOnClickListener {
            val intent = Intent(this, PickUpLocation2::class.java)
            startActivity(intent)
        }
    }
}
