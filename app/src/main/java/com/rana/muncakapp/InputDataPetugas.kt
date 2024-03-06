package com.rana.muncakapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject

class InputDataPetugas : AppCompatActivity() {

    lateinit var ed_namaPetugas: EditText
    lateinit var ed_emailPetugas: EditText
    lateinit var ed_passwordPetugas: EditText
    lateinit var ed_hint: EditText
    lateinit var ed_tipe: TextView

    private var email : String = ""

    lateinit var btn_simpan: Button
    lateinit var btn_kembali : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_petugas)

        btn_simpan = findViewById(R.id.btn_simpanPetugas)
        btn_kembali = findViewById(R.id.btn_kembali)

        ed_namaPetugas = findViewById(R.id.ed_namaPetugas)
        ed_emailPetugas = findViewById(R.id.ed_emailPetugas)
        ed_passwordPetugas = findViewById(R.id.ed_passwordPetugas)
        ed_hint = findViewById(R.id.ed_hint)
        ed_tipe = findViewById(R.id.ed_tipeUser)

        btn_kembali.setOnClickListener({
            val nextPage = Intent(this, DashboardAdmin::class.java);
            startActivity(nextPage);
        })

        btn_simpan.setOnClickListener {

            email = ed_emailPetugas.text.toString()

            when {
                !isValidEmail(email) -> {
                    ed_emailPetugas.error = "Invalid email format"
                }
                ed_passwordPetugas.text.length < 8 -> {
                    ed_passwordPetugas.error = "Password harus 8 karakter atau lebih"
                }
                else -> {


                    val loading = ProgressDialog(this)
                    loading.setMessage("Menambahkan data...")
                    loading.show()

                    AndroidNetworking.post(ApiEndPoint.CREATE_user)
                        .addBodyParameter("username", ed_namaPetugas.text.toString())
                        .addBodyParameter("email", ed_emailPetugas.text.toString())
                        .addBodyParameter("password", ed_passwordPetugas.text.toString())
                        .addBodyParameter("tipe_user", ed_tipe.text.toString())
                        .addBodyParameter("jawaban_hint", ed_hint.text.toString())
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(object : JSONObjectRequestListener {
                            override fun onResponse(response: JSONObject?) {
                                loading.dismiss()
                                if (response?.getString("message") == "Data User Berhasil di Tambahkan") {
                                    Toast.makeText(
                                        applicationContext,
                                        response?.getString("message"),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(
                                        Intent(
                                            this@InputDataPetugas,
                                            DashboardAdmin::class.java
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

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}