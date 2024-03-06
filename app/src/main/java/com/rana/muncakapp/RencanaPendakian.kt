package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import java.util.ArrayList

class RencanaPendakian: AppCompatActivity() {

    lateinit var i : Intent
    private var arrayList = ArrayList<Pendakian>()
    private lateinit var rv_Riwayat : RecyclerView
    lateinit var sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rencana_pendakian)

        sharedpref = PreferencesHelper(this)

        val btn_kembali = findViewById<ImageView>(R.id.iv_back)

        btn_kembali.setOnClickListener({
            val i = Intent(this@RencanaPendakian, HalamanUser::class.java);
            startActivity(i)
        })

        loadAllHistory()

    }


    override fun onResume() {
        super.onResume()
        loadAllHistory()
    }

    private fun loadAllHistory() {
        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        rv_Riwayat = findViewById(R.id.rvRiwayat)
        rv_Riwayat.setHasFixedSize(true)
        rv_Riwayat.layoutManager = LinearLayoutManager(this)

        AndroidNetworking.post(ApiEndPoint.READ_riwayat)
            .addBodyParameter("username", sharedpref.getString(Constant.PREF_USERNAME))
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    arrayList.clear()
                    val jsonArray = response?.optJSONArray("result")

                    if (jsonArray?.length() == 0)  {
                        loading.dismiss()
                        Toast.makeText(applicationContext, "Data Rencana Pendakian Kosong", Toast.LENGTH_SHORT).show()
                    }

                    for (i in 0 until jsonArray?.length()!!){
                        val jsonObject = jsonArray.optJSONObject(i)
                        arrayList.add(Pendakian(jsonObject.getString("id_regu"),jsonObject.getString("nama_regu"),
                            jsonObject.getString("jumlah_regu"),jsonObject.getString("tanggal_pemesanan"),
                            jsonObject.getString("tanggal_naik"), jsonObject.getString("tanggal_turun"),
                            jsonObject.getString("status_pemesanan"), jsonObject.getString("username")))

                        if (jsonArray.length()-1 == i){
                            loading.dismiss()
                        }
                    }

                    val adapter = RVAdapterRencanaPendakian(applicationContext, arrayList)
                    adapter.notifyDataSetChanged()
                    rv_Riwayat.adapter = adapter
                    Log.i("RencanaPendakian ", "Load all notes : "+ arrayList.size.toString())
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ON ERROR", anError?.errorDetail.toString())
                    Toast.makeText(applicationContext, "Failure," + anError.toString(), Toast.LENGTH_SHORT).show()
                }
            })
    }

}