package com.bm5a.diskonyeyy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.os.Handler
import android.os.Looper

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        // making this activity full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_splash_screen)

        // 1.5 second splash time
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //start main activity
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                //finish this activity
                finish()

            }, 1500
        )
    }
}