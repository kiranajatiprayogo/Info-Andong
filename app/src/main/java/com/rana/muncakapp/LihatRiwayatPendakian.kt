package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import java.util.*

class LihatRiwayatPendakian : AppCompatActivity() {

    private var arrayList = ArrayList<RiwayatPerjalanan>()
    private lateinit var rvRiwayatPendakian : RecyclerView
    private lateinit var adapter : RVAdapterRiwayatPendakian
    lateinit var btn_kembali : ImageView
    lateinit var search : SearchView
    lateinit var btn_input : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_riwayat_pendakian)

        rvRiwayatPendakian = findViewById(R.id.rvRiwayatPendakian)
        rvRiwayatPendakian.setHasFixedSize(true)
        rvRiwayatPendakian.layoutManager = LinearLayoutManager(this)
        loadAllRiwayatPendakian()
        adapter = RVAdapterRiwayatPendakian(applicationContext, arrayList)
        rvRiwayatPendakian.adapter = adapter

        btn_input= findViewById(R.id.btn_RiwayatPendakian)
        btn_kembali= findViewById(R.id.iv_back)
        search = findViewById(R.id.searchRiwayatPendakian)

        btn_kembali.setOnClickListener({
            val i = Intent(this@LihatRiwayatPendakian, DashboardAdmin::class.java);
            startActivity(i)
        })

        btn_input.setOnClickListener({
            val i = Intent(this@LihatRiwayatPendakian, KelolaRiwayatPendakian::class.java);
            startActivity(i)
        })

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList(query: String?) {

        if(query!= null){
            val filteredList = ArrayList<RiwayatPerjalanan>()
            for(i in arrayList){
                if (i.nama_regu?.lowercase(Locale.ROOT)!!.contains(query)){
                    filteredList.add(i)
                } else if(i.nama_pendaki?.lowercase(Locale.ROOT)!!.contains(query)) {
                    filteredList.add(i)
                }
            }

            if(filteredList.isEmpty()){
                Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }


    override fun onResume() {
        super.onResume()
        loadAllRiwayatPendakian()
    }

    private fun loadAllRiwayatPendakian() {
        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ_riwayat_pendakian)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    arrayList.clear()
                    val jsonArray = response?.optJSONArray("result")

                    if (jsonArray?.length() == 0)  {
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

                        if (jsonArray.length()-1 == i){
                            loading.dismiss()
                        }
                    }
                    rvRiwayatPendakian.adapter = adapter
                    Log.i("LihatDataPendakian ", "Load all notes : "+ arrayList.size.toString())
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ON ERROR", anError?.errorDetail.toString())
                    Toast.makeText(applicationContext, "Failure," + anError.toString(), Toast.LENGTH_SHORT).show()
                }
            })
    }
}