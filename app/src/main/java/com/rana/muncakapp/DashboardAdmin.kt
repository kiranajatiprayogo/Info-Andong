package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DashboardAdmin : AppCompatActivity() {

    lateinit var sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_admin)

        sharedpref = PreferencesHelper(this)

        val btn_lihatPendakian = findViewById<Button>(R.id.btn_lihatPendakian);
        val btn_lihatPendaki = findViewById<Button>(R.id.btn_lihatPendaki);
        val btn_laporanPendakian = findViewById<Button>(R.id.btn_laporanPendakian);
        val btn_riwayatPendakian = findViewById<Button>(R.id.btn_riwayatPendakian);
        val btn_inputPetugas = findViewById<TextView>(R.id.btn_inputPetugas);
        val tv_nama = findViewById<TextView>(R.id.tv_petugas)
        val btn_profil = findViewById<ImageView>(R.id.img_profil)

        tv_nama.text = sharedpref.getString(Constant.PREF_USERNAME)


        btn_lihatPendakian.setOnClickListener({
            val nextPage = Intent(this, LihatDataPendakian::class.java);
            startActivity(nextPage);
        })

        btn_lihatPendaki.setOnClickListener({
            val nextPage = Intent(this, LihatDataPendaki::class.java);
            startActivity(nextPage);
        })

        btn_laporanPendakian.setOnClickListener({
            val nextPage = Intent(this, LaporanPendakian::class.java);
            startActivity(nextPage);
        })

        btn_riwayatPendakian.setOnClickListener({
            val nextPage = Intent(this, LihatRiwayatPendakian::class.java);
            startActivity(nextPage);
        })

        btn_inputPetugas.setOnClickListener({
            val nextPage = Intent(this, InputDataPetugas::class.java);
            startActivity(nextPage);
        })

        btn_profil.setOnClickListener({
            val i = Intent(this, ProfilUser::class.java);
            startActivity(i)
        })

    }
}