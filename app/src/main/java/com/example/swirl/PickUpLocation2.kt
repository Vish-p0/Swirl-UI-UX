package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class PickUpLocation2 : AppCompatActivity() {

    private lateinit var btnBack: ImageButton

    private lateinit var btnAddLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pickup_location2)


        btnBack = findViewById(R.id.btnBack)
        btnAddLocation = findViewById(R.id.btnAddLocation)

        btnBack.setOnClickListener {
            val intent = Intent(this, PickUpLocation::class.java)
            startActivity(intent)

        }

        // Navigate to PickUpLocation2 when add location button is pressed
        btnAddLocation.setOnClickListener {
            val intent = Intent(this, SelectService::class.java)
            startActivity(intent)
        }

    }
}