package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class SelectLaundry : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_laundry)


        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val laundromat = findViewById<ImageButton>(R.id.laundromat)



        // Set up click listener for Back Button
        btnBack.setOnClickListener {

            val intent = Intent(this, SelectService::class.java)
            startActivity(intent)

        }

        // Set up click listener for Laundromat Image Button
        laundromat.setOnClickListener {

            val intent = Intent(this, FindDriver::class.java)
            startActivity(intent)
        }


    }
}