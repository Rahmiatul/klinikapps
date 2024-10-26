package com.rahmi.klinikapps

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PageLogin : AppCompatActivity() {
    private lateinit var signup : TextView
    private lateinit var buttonDr : Button
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_login)
        signup = findViewById(R.id.account)
        buttonDr = findViewById(R.id.btnSignin)

        signup.setOnClickListener(){
            val intent = Intent(this, PageRegister::class.java)
            startActivity(intent)
        }

        buttonDr.setOnClickListener(){
            val intent = Intent(this, doctorpage::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}