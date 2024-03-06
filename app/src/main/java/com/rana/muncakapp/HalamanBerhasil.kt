package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class HalamanBerhasil : AppCompatActivity() {

    lateinit var btn_kembali: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berhasil)

        btn_kembali = findViewById(R.id.btn_backToLogin)

        btn_kembali.setOnClickListener({
            val nextPage = Intent(this, Login::class.java);
            startActivity(nextPage);
        })
    }
}