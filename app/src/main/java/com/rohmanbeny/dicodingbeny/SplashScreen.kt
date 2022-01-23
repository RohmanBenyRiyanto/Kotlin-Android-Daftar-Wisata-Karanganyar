package com.rohmanbeny.dicodingbeny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this@SplashScreen,
                MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}