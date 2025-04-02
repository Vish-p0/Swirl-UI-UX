package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class OrderSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_summary)

        // Back button
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {

            val intent = Intent(this, DriverFound::class.java)
            startActivity(intent)


        }

        // Make Payment button
        val btnMakePayment: Button = findViewById(R.id.btnMakePayment)
        btnMakePayment.setOnClickListener {
            // Navigate to Checkout activity
            val intent = Intent(this, Checkout::class.java)
            startActivity(intent)
        }
    }
}