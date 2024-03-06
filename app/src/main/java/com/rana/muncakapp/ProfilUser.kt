package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import java.util.ArrayList

class ProfilUser : AppCompatActivity() {

    private var arrayList = ArrayList<User>()
    private lateinit var rv_User : RecyclerView
    lateinit var sharedpref : PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_user)

        sharedpref = PreferencesHelper(this)

        val btn_logout = findViewById<Button>(R.id.btn_logout)

        btn_logout.setOnClickListener{
            sharedpref.clear()
            showMessage("Anda Berhasil Logout")
            startActivity(Intent(this@ProfilUser, Login::class.java))
            finish()
        }

        loadUser()

    }

    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }


    override fun onResume() {
        super.onResume()
        loadUser()
    }

    private fun loadUser() {
        val loading = ProgressDialog(this)
        loading.setMessage("Tunggu Sebentar...")
        loading.show()

        rv_User = findViewById(R.id.rvUser)
        rv_User.setHasFixedSize(true)
        rv_User.layoutManager = LinearLayoutManager(this)

        AndroidNetworking.post(ApiEndPoint.READ_user)
            .addBodyParameter("username", sharedpref.getString(Constant.PREF_USERNAME))
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    arrayList.clear()
                    val jsonArray = response?.optJSONArray("result")

                        for (i in 0 until jsonArray?.length()!!){
                            val jsonObject = jsonArray.optJSONObject(i)
                            arrayList.add(User(jsonObject.getString("username"),jsonObject.getString("email"),
                                jsonObject.getString("password"), jsonObject.getString("tipe_user")))

                            if (jsonArray.length()-1 == i){
                                loading.dismiss()
                            }
                        }

                        val adapter = RVAdapterUser(applicationContext, arrayList)
                        adapter.notifyDataSetChanged()
                        rv_User.adapter = adapter
                        Log.i("RencanaPendakian ", "Load all notes : "+ arrayList.size.toString())
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ON ERROR", anError?.errorDetail.toString())
                    Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT).show()
                }

            })
    }
}