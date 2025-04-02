package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginScreen : AppCompatActivity() {
    private lateinit var countrySpinner: Spinner
    private lateinit var flagImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        // Initialize spinner and flag image view
        countrySpinner = findViewById(R.id.country_code_spinner)
        flagImageView = findViewById(R.id.flag_image)

        // Create list of countries
        val countries = listOf(
            CountryItem("South Africa", "+27", R.drawable.south_africa),
            CountryItem("South Korea", "+82", R.drawable.south_korea),
            CountryItem("South Sudan", "+211", R.drawable.south_sudan),
            CountryItem("Spain", "+34", R.drawable.spain),
            CountryItem("Sri Lanka", "+94", R.drawable.sri_lanka),
            CountryItem("Sudan", "+249", R.drawable.sudan),
            CountryItem("Suriname", "+597", R.drawable.suriname),
            CountryItem("Svalbard and Jan Mayen", "+47", R.drawable.svalbard_and_jan_mayen)
        )

        // Create custom adapter for spinner
        val adapter = object : ArrayAdapter<CountryItem>(
            this,
            R.layout.country_code_spinner_item,
            countries
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val textView = view as TextView
                val countryItem = getItem(position)

                textView.text = countryItem?.code
                textView.textSize = 14f
                textView.gravity = Gravity.CENTER
                textView.minHeight = 50

                return view
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = LayoutInflater.from(context).inflate(
                    R.layout.spinner_country_dropdown_item,
                    parent,
                    false
                )

                val flagImage: ImageView = view.findViewById(R.id.flag_image)
                val countryNameText: TextView = view.findViewById(R.id.country_name)
                val countryCodeText: TextView = view.findViewById(R.id.country_code)

                val countryItem = getItem(position)
                countryItem?.let {
                    flagImage.setImageResource(it.flagResourceId)
                    countryNameText.text = it.name
                    countryCodeText.text = it.code
                }


                return view
            }
        }

        // Set the adapter to the spinner
        countrySpinner.adapter = adapter

        // Set listener to update flag when a country is selected
        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCountry = countries[position]
                flagImageView.setImageResource(selectedCountry.flagResourceId)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        findViewById<View>(R.id.back_button).setOnClickListener {
            val intent = Intent(this, LandingScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // Set up continue button
        findViewById<View>(R.id.continue_button).setOnClickListener {
            val intent = Intent(this, OtpVerificationScreen2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}