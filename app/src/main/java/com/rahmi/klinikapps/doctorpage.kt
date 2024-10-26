package com.rahmi.klinikapps

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rahmi.klinikapps.adapter.AdapterListDoctor
import com.rahmi.klinikapps.adapter.AdapterMenuIcon
import com.rahmi.klinikapps.model.ModelIcon
import com.rahmi.klinikapps.model.ModelListDoctor

class doctorpage : AppCompatActivity() {
    private lateinit var txtBack : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctorpage)

        txtBack = findViewById(R.id.txtBack)

        txtBack.setOnClickListener(){
            val intent = Intent(this, PageLogin::class.java)
            startActivity(intent)
        }

        val rvMenu : RecyclerView = findViewById(R.id.RvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        val menuList = listOf(
            ModelIcon(R.drawable.iconheart,"Cardiologyst"),
            ModelIcon(R.drawable.iconeye1,"Opthalmologyst"),
            ModelIcon(R.drawable.icontooth,"Dentist"),
            ModelIcon(R.drawable.iconheart,"Cardiologyst"),

            )
        rvMenu.adapter = AdapterMenuIcon(menuList)

        val rvDoctor : RecyclerView = findViewById(R.id.RvDoctor)
        rvDoctor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val doctorList = listOf(
            ModelListDoctor("Dr. Floyd Miles", R.drawable.dokter1,"Pediatrics", "(123 reviews)", "4.9", "23 oct 2024", "09.00pm"),
            ModelListDoctor("Dr. Guy Hawkinds", R.drawable.dokter2,"Dentist", "(85 reviews)", "4.9", "07 may 2024", "09.45am"),
            ModelListDoctor("Dr. Jane Cooper", R.drawable.dokter3,"Pediatrics", "(44 reviews)", "4.8", "02 feb 2024", "10.15am"),
            ModelListDoctor("Dr. Jacob Jones", R.drawable.dokter4,"Nephrologyst", "(101 reviews)", "5.0", "09 june 2024", "7.30pm"),
            ModelListDoctor("Dr. Jacob Jones", R.drawable.dokter5,"Nephrologyst", "(99 reviews)", "4.9","01 jan 2024", "06.00am")
        )
        rvDoctor.adapter = AdapterListDoctor(this,doctorList)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}