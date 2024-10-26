package com.rahmi.klinikapps

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailDoctor : AppCompatActivity() {
    private lateinit var imgDoctor : ImageView
    private lateinit var nameDoctor:  TextView
    private lateinit var bidangDoctor : TextView
    private lateinit var totalReview : TextView
    private lateinit var angkaReview :TextView
    private lateinit var date : TextView
    private lateinit var time : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctor)

        val detailImage = intent.getIntExtra("ImageDr",0)
        val detailNama = intent.getStringExtra("NamaDr")
        val detailBidang = intent.getStringExtra("BidangDr")
        val detailreview = intent.getStringExtra("totalReview")
        val detailangka = intent.getStringExtra("angkaReview")
        val detaildate = intent.getStringExtra("date")
        val detailtime = intent.getStringExtra("time")

        imgDoctor = findViewById(R.id.imgDoctor2)
        nameDoctor = findViewById(R.id.nameDoctor)
        bidangDoctor = findViewById(R.id.bidangDoctor)
        totalReview = findViewById(R.id.totalReview)
        angkaReview = findViewById(R.id.angkaReview)
        date = findViewById(R.id.date2)
        time = findViewById(R.id.time2)

        imgDoctor.setImageResource(detailImage)
        nameDoctor.setText(detailNama)
        bidangDoctor.setText(detailBidang)
        totalReview.setText(detailreview)
        angkaReview.setText(detailangka)
        date.setText(detaildate)
        time.setText(detailtime)





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}