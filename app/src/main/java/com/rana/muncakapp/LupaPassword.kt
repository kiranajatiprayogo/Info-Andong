package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import org.w3c.dom.Text

class LupaPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_password)

        val btn_ubah = findViewById<Button>(R.id.btn_ubah)
        val ed_username = findViewById<TextView>(R.id.ed_username)
        val ed_hint = findViewById<TextView>(R.id.ed_hint)
        val ed_password = findViewById<TextView>(R.id.ed_password)

        btn_ubah.setOnClickListener {

            when {
                ed_password.text.length < 8 -> {
                    ed_password.error = "Password harus 8 karakter atau lebih"
                }
                else -> {
                    val loading = ProgressDialog(this)
                    loading.setMessage("Mengubah data...")
                    loading.show()

                    AndroidNetworking.post(ApiEndPoint.UPDATE_user)
                        .addBodyParameter("username", ed_username.text.toString())
                        .addBodyParameter("jawaban_hint", ed_hint.text.toString())
                        .addBodyParameter("password", ed_password.text.toString())
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(object : JSONObjectRequestListener {
                            override fun onResponse(response: JSONObject?) {
                                loading.dismiss()

                                if (response?.getString("message") == "Data User Berhasil di Update") {
                                    Toast.makeText(
                                        applicationContext,
                                        response?.getString("message"),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(
                                        Intent(
                                            this@LupaPassword,
                                            HalamanBerhasil::class.java
                                        )
                                    )
                                    finish()
                                } else {
                                    Toast.makeText(
                                        applicationContext,
                                        response?.getString("message"),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                            }

                            override fun onError(anError: ANError?) {
                                loading.dismiss()
                                Log.d("ON ERROR", anError?.errorDetail.toString())
                                Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT)
                                    .show()
                            }

                        })
                }
            }
        }
    }
}