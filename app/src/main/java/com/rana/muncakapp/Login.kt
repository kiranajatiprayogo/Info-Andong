package com.rana.muncakapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.rana.muncakapp.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login : AppCompatActivity() {

    lateinit var i: Intent
    lateinit var sharedpref : PreferencesHelper

    private var user : String = ""
    private var pass : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedpref = PreferencesHelper(this)

        val btn_lupaPassword = findViewById<TextView>(R.id.btn_lupaPass)
        val btn_Register = findViewById<TextView>(R.id.btn_register)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val edUsernameLogin = findViewById<EditText>(R.id.ed_usernameLogin)
        val edPasswordLogin = findViewById<EditText>(R.id.ed_passwordLogin)

        btn_lupaPassword.setOnClickListener({
            val i = Intent(this@Login, LupaPassword::class.java);
            startActivity(i)
        })

        btn_Register.setOnClickListener({
            val i = Intent(this@Login, Register::class.java);
            startActivity(i)
        })

       btnLogin.setOnClickListener{

            user = edUsernameLogin.text.toString()
            pass = edPasswordLogin.text.toString()

            when {
                user == "" -> {
                    edUsernameLogin.error = "Username tidak boleh kosong"
                }
                pass == "" -> {
                    edPasswordLogin.error = "Password tidak boleh kosong"
                }
                edPasswordLogin.text.length < 8 -> {
                    edPasswordLogin.error = "Password harus 8 karakter atau lebih"
                }
                else -> {
                    saveSession(edUsernameLogin.text.toString())
                    getData()
                }
            }
        }

    }

    private fun getData() {
        val api = RetrofitClient().getInstance()
        api.login(user, pass).enqueue(object : Callback<ResponseLogin> {

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful) {
                    if (response.body()?.payload?.tipe_user == "Petugas") {
                        startActivity(Intent(this@Login, DashboardAdmin::class.java))
                        finish()
                    } else if (response.body()?.payload?.tipe_user == "Pendaki") {
                        startActivity(Intent(this@Login, HalamanUser::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@Login,
                            "Login gagal, Periksa kembali username, dan password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@Login,
                        "Login gagal, Terjadi Kesalahan",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("Pesan Error", t.message ?: "Terjadi kesalahan tanpa pesan.")
            }
        })
    }

    private fun saveSession(user: String) {
        sharedpref.put(Constant.PREF_USERNAME, user)
    }


}