package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
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

class LihatDataPendaki : AppCompatActivity() {

    private var arrayList = ArrayList<Pendaki>()
    private lateinit var rvPendaki : RecyclerView
    private lateinit var adapter : RVAdapterPendaki
    lateinit var btn_kembali : ImageView
    lateinit var searchPendaki : SearchView
    lateinit var btn_input : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_data_pendaki)

        rvPendaki = findViewById(R.id.rvPendaki)
        rvPendaki.setHasFixedSize(true)
        rvPendaki.layoutManager = LinearLayoutManager(this)
        loadAllPendaki()
        adapter = RVAdapterPendaki(applicationContext, arrayList)
        rvPendaki.adapter = adapter

        btn_input = findViewById(R.id.btn_Pendaki)
        btn_kembali = findViewById(R.id.iv_back)
        searchPendaki = findViewById(R.id.searchPendaki)

        btn_kembali.setOnClickListener({
            val i = Intent(this@LihatDataPendaki, DashboardAdmin::class.java);
            startActivity(i)
        })

        btn_input.setOnClickListener({
            val i = Intent(this@LihatDataPendaki, KelolaDataPendaki::class.java);
            startActivity(i)
        })

        searchPendaki.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList (query : String?){

        if(query!= null){
            val filteredList = ArrayList<Pendaki>()
                for(i in arrayList){
                    if (i.nama_pendaki?.lowercase(Locale.ROOT)!!.contains(query)){
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

    private fun loadAllPendaki() {

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat Data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ_pendaki)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    arrayList.clear()
                    val jsonArray = response?.optJSONArray("result")

                    if (jsonArray?.length() == 0 ) {
                        loading.dismiss()
                        Toast.makeText(applicationContext, "Data Pendaki Kosong", Toast.LENGTH_SHORT).show()
                    }

                    for (i in 0 until jsonArray?.length()!!){
                        val jsonObject = jsonArray.optJSONObject(i)
                        arrayList.add(Pendaki(jsonObject.getString("id_pendaki"),jsonObject.getString("nama_pendaki"),
                            jsonObject.getString("umur"),jsonObject.getString("nohp_pribadi"),
                            jsonObject.getString("nohp_keluarga"),jsonObject.getString("alamat"),
                            jsonObject.getString("id_regu"),jsonObject.getString("nama_regu")))

                        if(jsonArray.length()-1 == i){
                            loading.dismiss()
                        }
                    }
                    rvPendaki.adapter = adapter
                    Log.i("LihatDataPendaki", "Load all notes : " +arrayList.size.toString())

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ON ERROR", anError?.errorDetail.toString())
                    Toast.makeText(applicationContext, "Failure," + anError.toString(), Toast.LENGTH_SHORT).show()
                }
            })
    }


}
