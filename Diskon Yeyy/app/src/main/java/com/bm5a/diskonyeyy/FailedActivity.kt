package com.bm5a.diskonyeyy

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FailedActivity : AppCompatActivity() {

    private lateinit var btSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failed)

        btSend = findViewById(R.id.bt_send)

        btSend.setOnClickListener {
            Toast.makeText(
                applicationContext, "Pembayaran Gagal, Tidak Ada Koneksi Internet",
                Toast.LENGTH_SHORT,
            ).show()
        }
    }
}