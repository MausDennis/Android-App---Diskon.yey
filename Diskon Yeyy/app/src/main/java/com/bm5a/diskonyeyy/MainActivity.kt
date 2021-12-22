package com.bm5a.diskonyeyy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btPay: RelativeLayout
    private lateinit var btAbout: Button
    private lateinit var btReward: RelativeLayout
    private lateinit var btCar: RelativeLayout
    private lateinit var btMotorcycle: RelativeLayout
    private lateinit var btFood: RelativeLayout
    private lateinit var btShop: RelativeLayout
    private lateinit var btOrder: RelativeLayout
    private lateinit var btPayment: RelativeLayout
    private lateinit var btTicket: RelativeLayout
    private lateinit var btHotel: RelativeLayout
    private lateinit var btShopping: RelativeLayout
    private lateinit var btTopUp: RelativeLayout
    private lateinit var greetImg: ImageView
    private lateinit var greetText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPay = findViewById(R.id.bt_pay)
        btAbout = findViewById(R.id.btn_about)
        btReward = findViewById(R.id.bt_reward)
        btTopUp = findViewById(R.id.bt_top_up)
        btCar = findViewById(R.id.bt_car)
        btMotorcycle = findViewById(R.id.bt_motorcycle)
        btFood = findViewById(R.id.bt_food)
        btShop = findViewById(R.id.bt_shop)
        btOrder = findViewById(R.id.bt_order)
        btPayment = findViewById(R.id.bt_payment)
        btTicket = findViewById(R.id.bt_ticket)
        btHotel = findViewById(R.id.bt_hotel)
        btShopping = findViewById(R.id.bt_shopping)

        btAbout.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        btPay.setOnClickListener {
            navigateToScanBarcode()
        }

        btReward.setOnClickListener {
            val intent = Intent(this@MainActivity, RewardActivity::class.java)
            startActivity(intent)
        }

        btCar.setOnClickListener {
            navigateToScanBarcode()
        }

        btMotorcycle.setOnClickListener {
            navigateToScanBarcode()
        }

        btFood.setOnClickListener {
            navigateToScanBarcode()
        }

        btShop.setOnClickListener {
            navigateToScanBarcode()
        }

        btOrder.setOnClickListener {
            navigateToScanBarcode()
        }

        btPayment.setOnClickListener {
            navigateToScanBarcode()
        }

        btTicket.setOnClickListener {
            navigateToScanBarcode()
        }

        btHotel.setOnClickListener {
            navigateToScanBarcode()
        }

        btShopping.setOnClickListener {
            navigateToScanBarcode()
        }

        btTopUp.setOnClickListener {
            val intent = Intent(this@MainActivity, FailedActivity::class.java)
            startActivity(intent)
        }

        greetImg = findViewById(R.id.greeting_img)
        greetText = findViewById(R.id.greeting_text)
        greeting()
    }

    private fun navigateToScanBarcode() {
        val intent = Intent(this@MainActivity, ScanActivity::class.java)
        startActivity(intent)
    }

    private fun greeting() {
        val calendar = Calendar.getInstance()
        val timeOfDay = calendar[Calendar.HOUR_OF_DAY]
        when {
            timeOfDay < 12 -> {
                greetText.text = "Selamat Pagi\nThareq"
                greetImg.setImageResource(R.drawable.img_default_half_morning)
            }
            timeOfDay < 15 -> {
                greetText.text = "Selamat Siang\nThareq"
                greetImg.setImageResource(R.drawable.img_default_half_afternoon)
            }
            timeOfDay < 18 -> {
                greetText.text = "Selamat Sore\nThareq"
                greetImg.setImageResource(R.drawable.img_default_half_without_sun)
            }
            else -> {
                greetText.text = "Selamat Malam\nThareq"
                greetText.setTextColor(Color.WHITE)
                greetImg.setImageResource(R.drawable.img_default_half_night)
            }
        }
    }
}