package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class SelectService : AppCompatActivity() {

    private lateinit var serviceRadioGroup: RadioGroup
    private lateinit var btnProceed: Button
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_service)

        // Initialize views
        serviceRadioGroup = findViewById(R.id.service_radio_group)
        btnProceed = findViewById(R.id.btn_proceed)
        btnBack = findViewById(R.id.btn_back)

        // Setup listeners
        setupListeners()
    }

    private fun setupListeners() {
        // Proceed button click listener
        btnProceed.setOnClickListener {
            // Navigate to SelectLaundry activity
            val intent = Intent(this, SelectLaundry::class.java)
            startActivity(intent)
        }

        // Back button click listener
        btnBack.setOnClickListener {
            // Go to PickUpLocation activity
            val intent = Intent(this, PickUpLocation::class.java)
            startActivity(intent)
            finish()
        }
    }
}