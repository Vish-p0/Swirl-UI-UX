package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView

class LaundryServices: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.laundry_services)

        val backToTopButton: Button = findViewById(R.id.back_to_top)
        val scrollView: NestedScrollView = findViewById(R.id.services_scroll_view)

        backToTopButton.setOnClickListener {
            scrollView.smoothScrollTo(0, 0)
        }

        // Bottom Navigation Setup
        val homeNav: LinearLayout = findViewById(R.id.home_nav)
        val servicesNav: LinearLayout = findViewById(R.id.services_nav)
        val activitiesNav: LinearLayout = findViewById(R.id.activities_nav)
        val profileNav: LinearLayout = findViewById(R.id.profile_nav)

        // Home Navigationq
        homeNav.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        // Services Navigation
        servicesNav.setOnClickListener {
            // Current activity, no action needed
        }

        // Activities Navigation
        activitiesNav.setOnClickListener {

            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
            finish()
        }

    //Profile Navigation
        profileNav.setOnClickListener {

            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }
}