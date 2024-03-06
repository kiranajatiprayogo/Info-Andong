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

class LihatRiwayatPendaki : AppCompatActivity() {

    lateinit var i:Intent

    private var arrayList = ArrayList<Pendaki>()
    private lateinit var rvPendakiUser : RecyclerView
    lateinit var btn_kembali : ImageView
    lateinit var btn_input : CardView
    lateinit var tv_idRegu : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_riwayat_pendaki)

        tv_idRegu= findViewById(R.id.tv_idRegu)

        rvPendakiUser = findViewById(R.id.rvPendakiUser)
        rvPendakiUser.setHasFixedSize(true)
        rvPendakiUser.layoutManager = LinearLayoutManager(this)

        btn_kembali= findViewById(R.id.iv_back)
        btn_input= findViewById(R.id.btn_inputPendaki)

        i=intent
        if (i.hasExtra("lihatmode")){
            if (i.getStringExtra("lihatmode").equals("1")){
                onLihatMode()
            }
        }

        btn_kembali.setOnClickListener({
            val i = Intent(this@LihatRiwayatPendaki, RencanaPendakian::class.java);
            startActivity(i)
        })

        btn_input.setOnClickListener({
            val i = Intent(this@LihatRiwayatPendaki, KelolaRiwayatPendaki::class.java);
            startActivity(i)
        })

        loadPendakiUser()
    }

    private fun onLihatMode() {

        tv_idRegu.setText(i.getStringExtra("txtidRegu"))
        tv_idRegu.visibility = View.GONE

    }

    private fun loadPendakiUser() {

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat Data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.READ_riwayat_pendaki)
            .addBodyParameter("id_regu", tv_idRegu.text.toString())
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

                    val adapter = RVAdapterRiwayatPendaki(applicationContext, arrayList)
                    adapter.notifyDataSetChanged()
                    rvPendakiUser.adapter = adapter
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