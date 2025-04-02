package com.example.swirl

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val splashDisplayLength = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_screen_1)

        val logo = findViewById<ImageView>(R.id.white_logo)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoadingScreen2::class.java)

            val logoPos = IntArray(2)
            logo.getLocationOnScreen(logoPos)
            intent.putExtra("LOGO_X", logoPos[0])
            intent.putExtra("LOGO_Y", logoPos[1])
            intent.putExtra("LOGO_WIDTH", logo.width)
            intent.putExtra("LOGO_HEIGHT", logo.height)

            val options = ActivityOptions.makeCustomAnimation(
                this, R.anim.fade_in, R.anim.fade_out
            )

            startActivity(intent, options.toBundle())
            finish()
        }, splashDisplayLength.toLong())
    }
}