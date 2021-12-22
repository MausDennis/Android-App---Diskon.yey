package com.bm5a.diskonyeyy

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.text.SimpleDateFormat
import java.util.*

class ScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var mScannerView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mScannerView = ZXingScannerView(this)
        setContentView(mScannerView)
    }

    override fun onStart() {
        mScannerView.startCamera()
        doRequestPermission()
        super.onStart()
    }

    private fun doRequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) requestPermissions(
                arrayOf(Manifest.permission.CAMERA),
                100
            )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != 100)
            onBackPressed()
    }

    override fun onPause() {
        mScannerView.stopCamera()
        super.onPause()
    }

    public override fun onResume() {
        /** Register ourselves as a handler for scan results. */
        mScannerView.setResultHandler(this)

        /** Start camera on resume */
        mScannerView.startCamera()

        super.onResume()
    }

    override fun handleResult(rawResult: Result?) {

        if (rawResult != null) {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)

            var codeRedeem = rawResult.text
            val dateRedeem = simpleDateFormat.format(Date())

            if (codeRedeem.contains("#"))
                codeRedeem = codeRedeem.replace("#", " ")

            val dataRedeem = "$codeRedeem:$dateRedeem"

            /** Ini manggil fungsi untuk simpan data ke cache */
            val pref = getSharedPreferences("DiskonYey", MODE_PRIVATE)

            /** Ini ambil data "reward" atau code code yang udah pernah diredeem dari cache */
            var dataPref = pref.getString("reward", null)

            /** Ini ngecek, apakah dia ada datanya atau engga, kalau ga ada maka dia insert
             *  untuk pertama kalinya yaitu "codeRedeem:dateRedeem"
             *
             *  Jika data reward ada, maka tambahkan data dengan pembatas '#'
             *  ex: codeRedeem:dateRedeem#codeRedeem1:dateRedeem1#codeRedeem2:dateRedeem2
             *
             *  Gunanya untuk nanti di tampilan reward agar datanya jadi list
             * */
            dataPref = if (dataPref == null)
                dataRedeem
            else
                "$dataPref#$dataRedeem"


            /** Ini fungsi untuk insert data yang tadi discan ke cache*/
            val prefEdit = pref.edit()
            prefEdit.putString("data", dataPref)
            prefEdit.apply()


            /** Ini pindah ke halaman sukses*/
            ResultScanActivity.resultScan = codeRedeem
            val intent = Intent(this@ScanActivity, ResultScanActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}