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

class KelolaDataPendaki : AppCompatActivity() {

    lateinit var i: Intent

    lateinit var ed_idPendaki: TextView
    lateinit var ed_namaPendaki: EditText
    lateinit var ed_umurPendaki: EditText
    lateinit var ed_noHPPribadi: EditText
    lateinit var ed_noHPKeluarga: EditText
    lateinit var ed_alamat: EditText
    lateinit var ed_idRegu: EditText

    lateinit var tv_id: TextView
    lateinit var tv_idRegu: TextView
    lateinit var tv_umur: TextView
    lateinit var tv_hpPribadi: TextView
    lateinit var tv_hpKeluarga: TextView
    lateinit var tv_alamat: TextView
    lateinit var tv_hapus: TextView

    lateinit var btn_simpan: Button
    lateinit var btn_edit : Button
    lateinit var btn_hapus : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_data_pendaki)

        btn_edit = findViewById(R.id.btn_editPendaki)
        btn_hapus = findViewById(R.id.btn_hapusPendaki)
        btn_simpan = findViewById(R.id.btn_simpan)

        ed_idPendaki = findViewById(R.id.ed_idPendaki)
        ed_namaPendaki = findViewById(R.id.ed_namaPendaki)
        ed_umurPendaki = findViewById(R.id.ed_umurPendaki)
        ed_noHPPribadi = findViewById(R.id.ed_noHPPribadi)
        ed_noHPKeluarga = findViewById(R.id.ed_noHPKeluarga)
        ed_alamat = findViewById(R.id.ed_alamat)
        ed_idRegu = findViewById(R.id.ed_idRegu)

        tv_id = findViewById(R.id.tv_id)
        tv_idRegu = findViewById(R.id.tv_idRegu)
        tv_umur = findViewById(R.id.tv_umur)
        tv_hpKeluarga = findViewById(R.id.tv_hpKeluarga)
        tv_hpPribadi = findViewById(R.id.tv_hpPribadi)
        tv_alamat = findViewById(R.id.tv_alamat)
        tv_hapus = findViewById(R.id.tv_yakin)

        btn_simpan.visibility = View.VISIBLE
        ed_idPendaki.visibility = View.GONE
        btn_edit.visibility = View.GONE
        btn_hapus.visibility = View.GONE
        tv_hapus.visibility = View.GONE
        tv_id.visibility = View.GONE


        i = intent
        if (i.hasExtra("editmode")) {
            if (i.getStringExtra("editmode").equals("1")) {
                onEditMode()
            }
        }

        if (i.hasExtra("hapusmode")) {
            if (i.getStringExtra("hapusmode").equals("1")) {
                onHapusMode()
            }
        }

        btn_simpan.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Menambahkan data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.CREATE_pendaki)
                .addBodyParameter("id_pendaki", ed_idPendaki.text.toString())
                .addBodyParameter("nama_pendaki", ed_namaPendaki.text.toString())
                .addBodyParameter("umur", ed_umurPendaki.text.toString())
                .addBodyParameter("nohp_pribadi", ed_noHPPribadi.text.toString())
                .addBodyParameter("nohp_keluarga", ed_noHPKeluarga.text.toString())
                .addBodyParameter("alamat", ed_alamat.text.toString())
                .addBodyParameter("id_regu",ed_idRegu.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Diri Pendaki Berhasil di Tambahkan"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaDataPendaki, LihatDataPendaki::class.java))
                            finish()
                        }else {
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ON ERROR", anError?.errorDetail.toString())
                        Toast.makeText(applicationContext, "Data Diri Pendaki Gagal di Tambahkan", Toast.LENGTH_SHORT).show()
                    }

                })
        }

        btn_edit.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Mengubah data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.UPDATE_pendaki)
                .addBodyParameter("id_pendaki", ed_idPendaki.text.toString())
                .addBodyParameter("nama_pendaki", ed_namaPendaki.text.toString())
                .addBodyParameter("umur", ed_umurPendaki.text.toString())
                .addBodyParameter("nohp_pribadi", ed_noHPPribadi.text.toString())
                .addBodyParameter("nohp_keluarga", ed_noHPKeluarga.text.toString())
                .addBodyParameter("alamat", ed_alamat.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Diri Pendaki Berhasil di Update"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaDataPendaki, LihatDataPendaki::class.java))
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

        btn_hapus.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Menghapus data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.DELETE_pendaki)
                .addBodyParameter("id_pendaki", ed_idPendaki.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Diri Pendaki Berhasil di Hapus"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaDataPendaki, LihatDataPendaki::class.java))
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

    private fun onEditMode() {

        ed_idPendaki.setText(i.getStringExtra("txtidPendaki"))
        ed_namaPendaki.setText(i.getStringExtra("txtnamaPendaki"))
        ed_umurPendaki.setText(i.getStringExtra("txtumurPendaki"))
        ed_noHPPribadi.setText(i.getStringExtra("txtnoHPPribadi"))
        ed_noHPKeluarga.setText(i.getStringExtra("txtnoHPKeluarga"))
        ed_alamat.setText(i.getStringExtra("txtalamat"))

        btn_simpan.visibility = View.GONE
        ed_idPendaki.isEnabled = false
        tv_id.visibility = View.GONE
        btn_edit.visibility = View.VISIBLE
        btn_hapus.visibility = View.GONE
        tv_hapus.visibility = View.GONE
        tv_idRegu.visibility = View.GONE
        ed_idRegu.visibility = View.GONE
    }

    private fun onHapusMode() {

        ed_idPendaki.setText(i.getStringExtra("txtidPendaki"))
        ed_namaPendaki.setText(i.getStringExtra("txtnamaPendaki"))

        tv_hapus.visibility = View.VISIBLE
        tv_id.visibility = View.VISIBLE
        btn_hapus.visibility = View.VISIBLE

        ed_idPendaki.visibility = View.VISIBLE

        btn_simpan.visibility = View.GONE
        ed_umurPendaki.visibility = View.GONE
        ed_noHPPribadi.visibility = View.GONE
        ed_noHPKeluarga.visibility = View.GONE
        ed_alamat.visibility = View.GONE
        tv_umur.visibility = View.GONE
        tv_hpPribadi.visibility = View.GONE
        tv_hpKeluarga.visibility = View.GONE
        tv_alamat.visibility = View.GONE
        btn_edit.visibility = View.GONE
        tv_idRegu.visibility = View.GONE
        ed_idRegu.visibility = View.GONE

    }

}
