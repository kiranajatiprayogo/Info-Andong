package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class PeralatanMendaki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peralatan_mendaki)

        val btn_kembali = findViewById<Toolbar>(R.id.btn_kembali)

        btn_kembali.setOnClickListener({
            val i = Intent(this@PeralatanMendaki, HalamanUser::class.java);
            startActivity(i)
        })

    }
}