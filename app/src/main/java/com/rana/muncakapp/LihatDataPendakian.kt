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

class LihatDataPendakian : AppCompatActivity() {

    private var arrayList = ArrayList<Pendakian>()
    private lateinit var rvPendakian : RecyclerView
    private lateinit var adapter : RVAdapterPendakian
    lateinit var btn_kembali : ImageView
    lateinit var searchPendakian : SearchView
    lateinit var btn_input : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_data_pendakian)

        rvPendakian = findViewById(R.id.rvPendakian)
        rvPendakian.setHasFixedSize(true)
        rvPendakian.layoutManager = LinearLayoutManager(this)
        loadAllPendakian()
        adapter = RVAdapterPendakian(applicationContext, arrayList)
        rvPendakian.adapter = adapter

        btn_input= findViewById(R.id.btn_Pendakian)
        btn_kembali= findViewById(R.id.iv_back)
        searchPendakian = findViewById(R.id.searchPendakian)

        btn_kembali.setOnClickListener({
            val i = Intent(this@LihatDataPendakian, DashboardAdmin::class.java);
            startActivity(i)
        })

        btn_input.setOnClickListener({
            val i = Intent(this@LihatDataPendakian, KelolaDataPendakian::class.java);
            startActivity(i)
        })

        searchPendakian.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
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
            val filteredList = ArrayList<Pendakian>()
            for(i in arrayList){
                if (i.nama_regu?.lowercase(Locale.ROOT)!!.contains(query)){
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
        loadAllPendakian()
    }

    private fun loadAllPendakian() {
        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ_pendakian)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    arrayList.clear()
                    val jsonArray = response?.optJSONArray("result")

                    if (jsonArray?.length() == 0)  {
                        loading.dismiss()
                        Toast.makeText(applicationContext, "Data Pendakian Kosong", Toast.LENGTH_SHORT).show()
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
                    rvPendakian.adapter = adapter
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