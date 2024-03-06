package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HalamanUser : AppCompatActivity(), OnMapReadyCallback {

    lateinit var googleMaps : GoogleMap

    lateinit var sharedpref : PreferencesHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_user)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        sharedpref = PreferencesHelper(this)


        val btn_info = findViewById<ImageView>(R.id.img_MP)
        val btn_alat = findViewById<ImageView>(R.id.img_alat)
        val btn_panduan = findViewById<ImageView>(R.id.img_panduan)
        val btn_booking= findViewById<ImageView>(R.id.img_booking)
        val btn_tips= findViewById<ImageView>(R.id.img_tips)
        val btn_logistik = findViewById<ImageView>(R.id.img_logistik)
        val btn_survival = findViewById<ImageView>(R.id.img_survival)
        val btn_riwayat= findViewById<ImageView>(R.id.img_riwayat)
        val tv_nama = findViewById<TextView>(R.id.tv_user)
        val btn_profil = findViewById<ImageView>(R.id.img_profil)
        val btn_about = findViewById<ImageView>(R.id.img_about)

        tv_nama.text = sharedpref.getString(Constant.PREF_USERNAME)


        btn_info.setOnClickListener({
            val i = Intent(this@HalamanUser, DetailGunung::class.java);
            startActivity(i)
        })

        btn_alat.setOnClickListener({
            val i = Intent(this@HalamanUser, PeralatanMendaki::class.java);
            startActivity(i)
        })

        btn_panduan.setOnClickListener({
            val i = Intent(this@HalamanUser, PanduanMendaki::class.java);
            startActivity(i)
        })

        btn_tips.setOnClickListener({
            val i = Intent(this@HalamanUser, TipsMendaki::class.java);
            startActivity(i)
        })

        btn_logistik.setOnClickListener({
            val i = Intent(this@HalamanUser, Logistik::class.java);
            startActivity(i)
        })

        btn_survival.setOnClickListener({
            val i = Intent(this@HalamanUser, Survival::class.java);
            startActivity(i)
        })

        btn_booking.setOnClickListener({
            val i = Intent(this@HalamanUser, KelolaRencanaPendakian::class.java);
            startActivity(i)
        })

        btn_riwayat.setOnClickListener({
            val i = Intent(this@HalamanUser, RencanaPendakian::class.java);
            startActivity(i)
        })

        btn_profil.setOnClickListener({
            val i = Intent(this@HalamanUser, ProfilUser::class.java);
            startActivity(i)
        })

        btn_about.setOnClickListener({
            val i = Intent(this@HalamanUser, AboutApp::class.java);
            startActivity(i)
        })
    }

    //set Map
    override fun onMapReady(googleMap: GoogleMap) {
        googleMaps = googleMap
        val latLng = LatLng(-7.394834375340925, 110.3800805358411)
        googleMaps.addMarker(MarkerOptions().position(latLng).title("Basecamp Gunung Andong"))
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
        googleMaps.uiSettings.setAllGesturesEnabled(false)
        googleMaps.uiSettings.isZoomGesturesEnabled = false
        googleMaps.isTrafficEnabled = false
    }


}