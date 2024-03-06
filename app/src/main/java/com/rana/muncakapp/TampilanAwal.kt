package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TampilanAwal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilan_awal)

        val btn_user = findViewById<Button>(R.id.btn_mulai)

        btn_user.setOnClickListener({
            val i = Intent(this@TampilanAwal, Login::class.java);
            startActivity(i)
        })

    }
}