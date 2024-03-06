package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import java.util.ArrayList

class LihatRiwayatPendakianUser : AppCompatActivity() {

    lateinit var i:Intent

    private var arrayList = ArrayList<RiwayatPerjalanan>()
    private lateinit var rvRiwayatPendakianUser : RecyclerView
    lateinit var btn_kembali : ImageView
    lateinit var tv_idRegu : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_riwayat_pendakian_user)

        tv_idRegu= findViewById(R.id.tv_idRegu)

        rvRiwayatPendakianUser = findViewById(R.id.rvRiwayatPendakianUser)
        rvRiwayatPendakianUser.setHasFixedSize(true)
        rvRiwayatPendakianUser.layoutManager = LinearLayoutManager(this)

        btn_kembali= findViewById(R.id.iv_back)

        i=intent
        if (i.hasExtra("riwayatmode")){
            if (i.getStringExtra("riwayatmode").equals("1")){
                onLihatMode()
            }
        }

        btn_kembali.setOnClickListener({
            val i = Intent(this@LihatRiwayatPendakianUser, RencanaPendakian::class.java);
            startActivity(i)
        })

        loadRiwayatPendakianUser()
    }

    private fun onLihatMode() {

        tv_idRegu.setText(i.getStringExtra("txtidRegu"))
        tv_idRegu.visibility = View.GONE

    }

    private fun loadRiwayatPendakianUser() {

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat Data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.READ_riwayat_pendakian_user)
            .addBodyParameter("id_regu", tv_idRegu.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    arrayList.clear()
                    val jsonArray = response?.optJSONArray("result")

                    if (jsonArray?.length() == 0 ) {
                        loading.dismiss()
                        Toast.makeText(applicationContext, "Data Riwayat Pendakian Kosong", Toast.LENGTH_SHORT).show()
                    }

                    for (i in 0 until jsonArray?.length()!!){
                        val jsonObject = jsonArray.optJSONObject(i)
                        arrayList.add(RiwayatPerjalanan(jsonObject.getString("id_pendakian"), jsonObject.getString("nama_regu"),
                            jsonObject.getString("nama_pendaki"), jsonObject.getString("status_pendakian"),
                            jsonObject.getString("waktu_mulai"), jsonObject.getString("naik_pos1"),
                            jsonObject.getString("naik_pos2"), jsonObject.getString("naik_pos3"),
                            jsonObject.getString("turun_pos3"), jsonObject.getString("turun_pos2"),
                            jsonObject.getString("turun_pos1"), jsonObject.getString("waktu_selesai")))

                        if(jsonArray.length()-1 == i){
                            loading.dismiss()
                        }
                    }

                    val adapter = RVAdapterRiwayatPendakianUser(applicationContext, arrayList)
                    adapter.notifyDataSetChanged()
                    rvRiwayatPendakianUser.adapter = adapter
                    Log.i("Lihat Riwayat Pendakian", "Load all notes : " +arrayList.size.toString())

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ON ERROR", anError?.errorDetail.toString())
                    Toast.makeText(applicationContext, "Failure," + anError.toString(), Toast.LENGTH_SHORT).show()
                }
            })
    }

}