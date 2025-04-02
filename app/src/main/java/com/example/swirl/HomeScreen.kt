package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        val textViewPickUpLocation = findViewById<TextView>(R.id.textViewPickUpLocation)


        textViewPickUpLocation.setOnClickListener {
            val intent = Intent(this, PickUpLocation::class.java)
            startActivity(intent)
        }

        // Bottom Navigation Setup
        val homeNav: LinearLayout = findViewById(R.id.home_nav)
        val servicesNav: LinearLayout = findViewById(R.id.services_nav)
        val activitiesNav: LinearLayout = findViewById(R.id.activities_nav)
        val profileNav: LinearLayout = findViewById(R.id.profile_nav)

        // Home Navigation
        homeNav.setOnClickListener {
            // Current activity, no action needed
        }

        // Services Navigation
        servicesNav.setOnClickListener {
            val intent = Intent(this, LaundryServices::class.java)
            startActivity(intent)
            finish()
        }

        // Activities Navigation
        activitiesNav.setOnClickListener {

            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
            finish()
        }

        //Profile Navigation
        profileNav.setOnClickListener {

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}