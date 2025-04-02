package com.example.swirl

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.regex.Pattern

class SignupForm : AppCompatActivity() {
    // UI Elements
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etDateOfBirth: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var checkboxTerms: CheckBox
    private lateinit var btnStartJourney: Button
    private lateinit var tvBackButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_form)

        initializeViews()

        setupListeners()
    }

    private fun initializeViews() {
        etFullName = findViewById(R.id.et_full_name)
        etEmail = findViewById(R.id.et_email)
        etDateOfBirth = findViewById(R.id.et_date_of_birth)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        checkboxTerms = findViewById(R.id.checkbox_terms)
        btnStartJourney = findViewById(R.id.btn_start_journey)
        tvBackButton = findViewById(R.id.back_button)
    }

    private fun setupListeners() {
        // Date of Birth picker
        etDateOfBirth.setOnClickListener { showDatePickerDialog() }

        // Back button navigation
        tvBackButton.setOnClickListener {
            val intent = Intent(this, VerificationSuccessful::class.java)
            startActivity(intent)
            finish()
        }

        // Start Journey button
        btnStartJourney.setOnClickListener { validateAndSubmit() }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                // Month is 0-indexed, so add 1 for actual month
                val formattedDate = String.format(
                    "%02d/%02d/%04d",
                    selectedDayOfMonth,
                    selectedMonth + 1,
                    selectedYear
                )
                etDateOfBirth.setText(formattedDate)
            },
            year, month, day
        )

        // Set maximum date to current date
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()
    }

    private fun validateAndSubmit() {
        // Reset errors
        resetErrors()

        // Validate each field
        val isFullNameValid = validateFullName()
        val isEmailValid = validateEmail()
        val isDateOfBirthValid = validateDateOfBirth()
        val isPasswordValid = validatePassword()
        val isTermsAccepted = validateTerms()

        // If all validations pass
        if (isFullNameValid && isEmailValid && isDateOfBirthValid &&
            isPasswordValid && isTermsAccepted) {
            // Proceed with registration
            performRegistration()
        }
    }

    private fun resetErrors() {
        etFullName.error = null
        etEmail.error = null
        etDateOfBirth.error = null
        etPassword.error = null
        etConfirmPassword.error = null
    }

    private fun validateFullName(): Boolean {
        val fullName = etFullName.text.toString().trim()
        return when {
            fullName.isEmpty() -> {
                etFullName.error = "Full name is required"
                false
            }
            fullName.length < 2 -> {
                etFullName.error = "Name is too short"
                false
            }
            !fullName.matches(Regex("^[a-zA-Z ]+$")) -> {
                etFullName.error = "Invalid name format"
                false
            }
            else -> true
        }
    }

    private fun validateEmail(): Boolean {
        val email = etEmail.text.toString().trim()
        return when {
            email.isEmpty() -> {
                etEmail.error = "Email is required"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                etEmail.error = "Invalid email format"
                false
            }
            else -> true
        }
    }

    private fun validateDateOfBirth(): Boolean {
        val dob = etDateOfBirth.text.toString().trim()
        return when {
            dob.isEmpty() -> {
                etDateOfBirth.error = "Date of Birth is required"
                false
            }
            !isValidDateFormat(dob) -> {
                etDateOfBirth.error = "Invalid date format"
                false
            }
            else -> true
        }
    }

    private fun validatePassword(): Boolean {
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        return when {
            password.isEmpty() -> {
                etPassword.error = "Password is required"
                false
            }
            password.length < 8 -> {
                etPassword.error = "Password must be at least 8 characters"
                false
            }
            !isStrongPassword(password) -> {
                etPassword.error = "Password must contain uppercase, lowercase, number, and special character"
                false
            }
            confirmPassword.isEmpty() -> {
                etConfirmPassword.error = "Please confirm your password"
                false
            }
            password != confirmPassword -> {
                etConfirmPassword.error = "Passwords do not match"
                false
            }
            else -> true
        }
    }

    private fun validateTerms(): Boolean {
        return if (!checkboxTerms.isChecked) {
            Toast.makeText(this, "Please accept Terms & Conditions", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    private fun isValidDateFormat(date: String): Boolean {
        val datePattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$")
        return datePattern.matcher(date).matches()
    }

    private fun isStrongPassword(password: String): Boolean {
        val passwordPattern = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        )
        return passwordPattern.matcher(password).matches()
    }

    private fun performRegistration() {

        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

         val intent = Intent(this, OnboardingScreen1::class.java)
         startActivity(intent)
         finish()
    }
}