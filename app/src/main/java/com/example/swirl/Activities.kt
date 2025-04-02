package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Activities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activities)

        // Bottom Navigation Setup
        val homeNav: LinearLayout = findViewById(R.id.home_nav)
        val servicesNav: LinearLayout = findViewById(R.id.services_nav)
        val activitiesNav: LinearLayout = findViewById(R.id.activities_nav)
        val profileNav: LinearLayout = findViewById(R.id.profile_nav)

        // Home Navigation
        homeNav.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        // Services Navigation
        servicesNav.setOnClickListener {
            val intent = Intent(this, LaundryServices::class.java)
            startActivity(intent)
            finish()
        }

        // Activities Navigation
        activitiesNav.setOnClickListener {
            // Current activity, no action needed
        }


        profileNav.setOnClickListener {

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}