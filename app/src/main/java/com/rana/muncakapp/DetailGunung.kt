package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap

class DetailGunung : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gunung)

        val btn_kembali = findViewById<Toolbar>(R.id.btn_kembali)

        btn_kembali.setOnClickListener({
            val i = Intent(this@DetailGunung, HalamanUser::class.java);
            startActivity(i)
        })

    }
}