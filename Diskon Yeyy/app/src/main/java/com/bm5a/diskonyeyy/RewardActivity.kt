package com.bm5a.diskonyeyy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class RewardActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        val pref = getSharedPreferences("DiskonYey", MODE_PRIVATE)
        val itemsPref = pref.getString("reward", null)

        if (itemsPref != null) {
            val items = itemsPref.split("#")

            val dates = mutableListOf<String>()
            val codes = mutableListOf<String>()

            for (item in items) {
                val itemValues = item.split(":")
                if (itemValues.isNotEmpty()) {

                    val date: String = itemValues[1]
                    val codeRedeem: String = itemValues[0]

                    if (codeRedeem.isNotEmpty() && date.isNotEmpty()) {
                        dates.add("Tanggal $date")
                        codes.add("Code $codeRedeem")
                    }
                }
            }

            val adapter = MyListAdapter(this, dates.toTypedArray(), codes.toTypedArray())
            listView = findViewById(R.id.lv_items)
            listView.adapter = adapter
        }
    }
}