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

class Register : AppCompatActivity() {

    lateinit var i: Intent
    private var email : String = ""

    lateinit var ed_usernameUser: EditText
    lateinit var ed_emailUser: EditText
    lateinit var ed_passwordUser: EditText
    lateinit var ed_hint: EditText

    lateinit var btn_simpan: Button
    lateinit var tv_tipe: TextView
    lateinit var tv_pendaki: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_simpan = findViewById(R.id.btn_register)

        ed_usernameUser = findViewById(R.id.ed_usernameUser)
        ed_emailUser = findViewById(R.id.ed_emailUser)
        ed_passwordUser = findViewById(R.id.ed_passwordUser)
        ed_hint = findViewById(R.id.ed_hint)
        tv_tipe = findViewById(R.id.tv_text)
        tv_pendaki = findViewById(R.id.tv_tipeUser)

        tv_tipe.visibility = View.GONE
        tv_pendaki.visibility = View.GONE

        btn_simpan.setOnClickListener {

            email = ed_emailUser.text.toString()

            when {
                !isValidEmail(email) -> {
                    ed_emailUser.error = "Invalid email format"
                }
                ed_passwordUser.text.length < 8 -> {
                    ed_passwordUser.error = "Password harus 8 karakter atau lebih"
                }
                else -> {
                    val loading = ProgressDialog(this)
                    loading.setMessage("Menambahkan data...")
                    loading.show()

                    AndroidNetworking.post(ApiEndPoint.CREATE_user)
                        .addBodyParameter("username", ed_usernameUser.text.toString())
                        .addBodyParameter("email", ed_emailUser.text.toString())
                        .addBodyParameter("password", ed_passwordUser.text.toString())
                        .addBodyParameter("tipe_user", tv_pendaki.text.toString())
                        .addBodyParameter("jawaban_hint", ed_hint.text.toString())
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(object : JSONObjectRequestListener {
                            override fun onResponse(response: JSONObject?) {
                                loading.dismiss()
                                if(response?.getString("message")=="Data User Berhasil di Tambahkan"){
                                    Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this@Register, HalamanBerhasil::class.java))
                                    finish()
                                }else {
                                    Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                                }
                            }

                            override fun onError(anError: ANError?) {
                                loading.dismiss()
                                Log.d("ON ERROR", anError?.errorDetail.toString())
                                Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT).show()
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