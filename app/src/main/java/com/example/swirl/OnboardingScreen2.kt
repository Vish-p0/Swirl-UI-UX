package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class OnboardingScreen2 : AppCompatActivity() {
    // Service card data class to manage card states
    data class ServiceCard(
        val cardViewId: Int,
        val detailsTextViewId: Int,
        val serviceName: String
    )

    // List of all service cards
    private val serviceCards = listOf(
        ServiceCard(R.id.cardWhitesCleans, R.id.tvWhitesCleansDetails, "Whites & Cleans"),
        ServiceCard(R.id.cardDarksColors, R.id.tvDarksColorsDetails, "Darks & Colors"),
        ServiceCard(R.id.cardDelicates, R.id.tvDelicatesDetails, "Delicates"),
        ServiceCard(R.id.cardRegularWear, R.id.tvRegularWearDetails, "Regular Wear"),
        ServiceCard(R.id.cardHeavyLarge, R.id.tvHeavyLargeDetails, "Heavy & Large"),
        ServiceCard(R.id.cardStainedItems, R.id.tvStainedItemsDetails, "Stained Items"),
        ServiceCard(R.id.cardDryClean, R.id.tvDryCleanDetails, "Dry Clean")
    )

    // Navigation destinations
    private val navigationDestinations = mapOf(
        R.id.dot1 to OnboardingScreen1::class.java,
        R.id.dot2 to OnboardingScreen2::class.java,
        R.id.dot3 to OnboardingScreen3::class.java,
        R.id.dot4 to OnboardingScreen4::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screen2)

        // Setup service card interactions
        setupServiceCardListeners()

        // Setup next button navigation
        setupNextButtonNavigation()

        // Setup dot navigation
        setupDotNavigation()
    }

    private fun setupServiceCardListeners() {
        serviceCards.forEach { serviceCard ->
            try {
                val cardView = findViewById<MaterialCardView>(serviceCard.cardViewId)
                val detailsTextView = findViewById<TextView>(serviceCard.detailsTextViewId)

                cardView.setOnClickListener {
                    toggleCardDetails(detailsTextView, serviceCard.serviceName)
                }
            } catch (e: Exception) {
                // Log or handle any view not found exceptions
                Toast.makeText(
                    this,
                    "Error setting up ${serviceCard.serviceName} card",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun toggleCardDetails(detailsTextView: TextView, serviceName: String) {
        detailsTextView.visibility = when (detailsTextView.visibility) {
            View.VISIBLE -> {
                View.GONE
            }
            else -> {
                // Optional: Add a log or toast for user feedback
                Toast.makeText(
                    this,
                    "Showing details for $serviceName",
                    Toast.LENGTH_SHORT
                ).show()
                View.VISIBLE
            }
        }
    }

    private fun setupNextButtonNavigation() {
        try {
            findViewById<TextView>(R.id.btnNext).setOnClickListener {
                val intent = Intent(this, OnboardingScreen3::class.java)
                startActivity(intent)
                // Optional: Add animation or finish current activity
                // finish()
            }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Navigation error. Please try again.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupDotNavigation() {
        navigationDestinations.forEach { (dotId, destination) ->
            try {
                findViewById<View>(dotId).setOnClickListener {
                    val intent = Intent(this, destination)
                    startActivity(intent)
                    // Optional: Add animation or finish current activity if needed
                    // finish()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Navigation dot setup error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}