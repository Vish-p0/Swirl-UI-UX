package com.example.swirl

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class OtpVerificationScreen2 : AppCompatActivity() {
    private lateinit var backButton: TextView
    private lateinit var phoneNumberDisplay: TextView
    private lateinit var otpDigit1: EditText
    private lateinit var otpDigit2: EditText
    private lateinit var otpDigit3: EditText
    private lateinit var otpDigit4: EditText
    private lateinit var submitButton: TextView
    private lateinit var resendOtp: TextView
    private lateinit var otpTimer: TextView

    private var countDownTimer: CountDownTimer? = null
    private val otpExpirationTimeInMillis = 5 * 60 * 1000L // 5 minutes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_screen2)

        // Initialize views
        backButton = findViewById(R.id.back_button)
        phoneNumberDisplay = findViewById(R.id.phone_number_display)
        otpDigit1 = findViewById(R.id.otp_digit1)
        otpDigit2 = findViewById(R.id.otp_digit2)
        otpDigit3 = findViewById(R.id.otp_digit3)
        otpDigit4 = findViewById(R.id.otp_digit4)
        submitButton = findViewById(R.id.submit_button)
        resendOtp = findViewById(R.id.resend_otp)
        otpTimer = findViewById(R.id.otp_timer)

        // Get phone number from previous screen
        val phoneNumber = intent.getStringExtra("PHONE_NUMBER") ?: "07* *** **67"
        phoneNumberDisplay.text = phoneNumber

        // Set up OTP input fields
        setupOtpInputFields()

        // Back button click listener
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Submit button click listener
        submitButton.setOnClickListener {
            verifyOtp()
        }

        // Resend OTP click listener
        resendOtp.setOnClickListener {
            resendOtpCode()
        }

        // Start OTP countdown timer
        startOtpTimer()
    }

    private fun setupOtpInputFields() {
        val otpFields = listOf(otpDigit1, otpDigit2, otpDigit3, otpDigit4)

        for (i in 0 until otpFields.size - 1) {
            otpFields[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1) {
                        otpFields[i + 1].requestFocus()
                    }
                }
            })
        }
    }

    private fun verifyOtp() {
        val otp = otpDigit1.text.toString() +
                otpDigit2.text.toString() +
                otpDigit3.text.toString() +
                otpDigit4.text.toString()

        if (otp.length == 4) {
            // Successful OTP verification
            Toast.makeText(this, "OTP Verified Successfully", Toast.LENGTH_SHORT).show()

            // Navigate to WelcomeBack screen
            val intent = Intent(this, WelcomeBack::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Please enter a complete OTP", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resendOtpCode() {
        // TODO: Implement OTP resend logic
        Toast.makeText(this, "OTP Resent", Toast.LENGTH_SHORT).show()
        startOtpTimer()
    }

    private fun startOtpTimer() {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(otpExpirationTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / (60 * 1000)
                val seconds = (millisUntilFinished % (60 * 1000)) / 1000
                otpTimer.text = "OTP Expires in - ${String.format("%02d:%02d", minutes, seconds)}"
            }

            override fun onFinish() {
                otpTimer.text = "OTP Expired"
                // TODO: Handle OTP expiration (disable submit, show resend option)
            }
        }.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)
        finish()
    }



    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }
}