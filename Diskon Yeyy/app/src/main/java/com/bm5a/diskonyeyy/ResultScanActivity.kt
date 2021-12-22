package com.bm5a.diskonyeyy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultScanActivity : AppCompatActivity() {

    private lateinit var btBack: Button
    private lateinit var tvResult: TextView

    companion object {
        var resultScan: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_scan)

        btBack = findViewById(R.id.bt_back)
        tvResult = findViewById(R.id.tv_result)

        tvResult.text = "Diskon Sudah Dipakay Yeyy!\nKode Diskon: $resultScan"

        btBack.setOnClickListener {
            val intent = Intent(this@ResultScanActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}