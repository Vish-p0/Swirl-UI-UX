package com.example.swirl

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LoadingScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_screen_2)

        val logo = findViewById<ImageView>(R.id.white_logo)
        val appName = findViewById<ImageView>(R.id.app_name)

        // Initially hide the app name
        appName.alpha = 0f

        val moveUpPixels = -250f

        // Move logo up
        val moveLogoUp = ObjectAnimator.ofFloat(
            logo, View.TRANSLATION_Y, 0f, moveUpPixels
        ).apply {
            duration = 800
            interpolator = DecelerateInterpolator()
        }

        // Fade in the app name
        val fadeInAppName = ObjectAnimator.ofFloat(appName, View.ALPHA, 0f, 1f).apply {
            duration = 800
        }

        // Move app name down from the logo’s original position
        val moveAppNameDown = ObjectAnimator.ofFloat(
            appName, View.TRANSLATION_Y, 0f, 100f
        ).apply {
            duration = 800
            interpolator = DecelerateInterpolator()
        }

        // Group animations together
        val animatorSet = AnimatorSet().apply {
            playTogether(moveLogoUp, fadeInAppName, moveAppNameDown)
        }

        val handler = Handler(Looper.getMainLooper())

        // Start animation after a short delay
        handler.postDelayed({
            animatorSet.start()
        }, 100)

        // Transition to LandingScreen **1 second after** animation completes
        val totalDelay = animatorSet.totalDuration + 1000  // Animation duration + 1s delay

        handler.postDelayed({
            startActivity(Intent(this, LandingScreen::class.java))
            finish()
        }, totalDelay)
    }
}