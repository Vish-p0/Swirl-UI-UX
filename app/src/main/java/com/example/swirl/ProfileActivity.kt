package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_page)

        // Logout functionality
        val logoutTextView: TextView = findViewById(R.id.logout)
        logoutTextView.setOnClickListener {
            val intent = Intent(this, LandingScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

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
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
            finish()
        }


        profileNav.setOnClickListener {
            // Current activity, no action needed
        }
    }
}