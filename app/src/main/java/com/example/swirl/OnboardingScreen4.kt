package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingScreen4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screen4)

        // Next button navigation
        findViewById<TextView>(R.id.btnFreshStart).setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }

        // Page indicator dot navigation
        findViewById<View>(R.id.dot1).setOnClickListener {
            val intent = Intent(this, OnboardingScreen1::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.dot2).setOnClickListener {
            val intent = Intent(this, OnboardingScreen2::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.dot3).setOnClickListener {
            val intent = Intent(this, OnboardingScreen3::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.dot4).setOnClickListener {
            val intent = Intent(this, OnboardingScreen4::class.java)
            startActivity(intent)
        }
    }
}