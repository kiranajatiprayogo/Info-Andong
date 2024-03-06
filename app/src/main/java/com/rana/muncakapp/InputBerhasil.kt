package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InputBerhasil : AppCompatActivity() {

    lateinit var btn_ya : TextView
    lateinit var btn_no : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_berhasil)

        btn_ya = findViewById(R.id.btn_ya)
        btn_no = findViewById(R.id.btn_tidak)

        btn_ya.setOnClickListener({
            val i = Intent(this@InputBerhasil, KelolaRiwayatPendaki::class.java)
            startActivity(i)
        })

        btn_no.setOnClickListener({
            val i = Intent(this@InputBerhasil, RencanaPendakian::class.java)
            startActivity(i)
        })
    }
}