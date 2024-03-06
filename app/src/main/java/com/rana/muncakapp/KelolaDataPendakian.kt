package com.rana.muncakapp

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject
import java.text.SimpleDateFormat

class KelolaDataPendakian : AppCompatActivity() {

    lateinit var i:Intent

    lateinit var sharedpref : PreferencesHelper
    private var tgl_Pesan : String = ""

    lateinit var ed_tglPesan : TextView
    lateinit var ed_namaRegu : EditText
    lateinit var ed_jumlahRegu : EditText
    lateinit var ed_tglNaik : EditText
    lateinit var ed_tglTurun : EditText
    lateinit var ed_status : Spinner
    lateinit var ed_username : TextView
    lateinit var ed_idRegu : TextView

    lateinit var tv_username : TextView
    lateinit var tv_namaRegu : TextView
    lateinit var tv_jumlahRegu : TextView
    lateinit var tv_tglPesan : TextView
    lateinit var tv_tglNaik : TextView
    lateinit var tv_tglTurun : TextView
    lateinit var tv_status : TextView
    lateinit var tv_hapus : TextView
    lateinit var tv_id : TextView

    lateinit var btn_simpan : Button
    lateinit var btn_editPendakian : Button
    lateinit var btn_hapusPendakian : Button

    private var c = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_data_pendakian)

        sharedpref = PreferencesHelper(this)

        ed_status = findViewById(R.id.sp_statusPemesanan)
        btn_simpan = findViewById(R.id.btn_simpanPendakian)
        btn_editPendakian = findViewById(R.id.btn_editPendakian)
        btn_hapusPendakian = findViewById(R.id.btn_hapusPendakian)

        ed_tglPesan     = findViewById(R.id.ed_tglPesan)
        ed_username     = findViewById(R.id.ed_username)
        ed_namaRegu     = findViewById(R.id.ed_namaRegu)
        ed_jumlahRegu   = findViewById(R.id.ed_jumlahRegu)
        ed_tglNaik      = findViewById(R.id.ed_tglNaik)
        ed_tglTurun     = findViewById(R.id.ed_tglTurun)
        ed_idRegu       = findViewById(R.id.ed_idRegu)

        tv_id = findViewById(R.id.tv_id)
        tv_username     = findViewById(R.id.tv_username)
        tv_namaRegu     = findViewById(R.id.tv_namaRegu)
        tv_jumlahRegu   = findViewById(R.id.tv_jumlahRegu)
        tv_tglPesan     = findViewById(R.id.tv_tglPesan)
        tv_tglNaik      = findViewById(R.id.tv_tglNaik)
        tv_tglTurun     = findViewById(R.id.tv_tglTurun)
        tv_status       = findViewById(R.id.tv_status)
        tv_hapus     = findViewById(R.id.tv_yakin)

        ed_username.text = sharedpref.getString(Constant.PREF_USERNAME)

        btn_simpan.visibility = View.VISIBLE
        btn_editPendakian.visibility = View.GONE
        btn_hapusPendakian.visibility = View.GONE
        tv_hapus.visibility = View.GONE
        tv_id.visibility = View.GONE
        ed_idRegu.visibility = View.GONE

        i=intent
        if (i.hasExtra("editmode")){
            if (i.getStringExtra("editmode").equals("1")){
                onEditPendakian()
            }
        }

        if (i.hasExtra("hapusmode")){
            if (i.getStringExtra("hapusmode").equals("1")){
                onHapusPendakian()
            }
        }

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dateTime = simpleDateFormat.format(c.time)
        ed_tglPesan.text = dateTime
        tgl_Pesan = ed_tglPesan.text.toString()

        val dateSetListener_tglNaik = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewtglNaik()
            }


        }
        val dateSetListener_tglTurun = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewtglTurun()
            }
        }


            ed_tglNaik.setOnClickListener {
                DatePickerDialog(
                    this,
                    dateSetListener_tglNaik,
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

            ed_tglTurun.setOnClickListener {
                DatePickerDialog(
                    this,
                    dateSetListener_tglTurun,
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
                ).show()
            }


        btn_simpan.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Menambahkan data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.CREATE_pendakian)
                .addBodyParameter("nama_regu", ed_namaRegu.text.toString())
                .addBodyParameter("jumlah_regu", ed_jumlahRegu.text.toString())
                .addBodyParameter("tanggal_pemesanan", ed_tglPesan.text.toString())
                .addBodyParameter("tanggal_naik", ed_tglNaik.text.toString())
                .addBodyParameter("tanggal_turun", ed_tglTurun.text.toString())
                .addBodyParameter("status_pemesanan", ed_status.selectedItem.toString())
                .addBodyParameter("username", ed_username.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Rencana Pendakian Berhasil di Tambahkan"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaDataPendakian, LihatDataPendakian::class.java))
                            finish()
                        }else {
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ON ERROR", anError?.errorDetail.toString())
                        Toast.makeText(applicationContext, "Data Rencana Pendakian Gagal di Tambahkan", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        btn_editPendakian.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Mengubah data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.UPDATE_pendakian)
                .addBodyParameter("id_regu", ed_idRegu.text.toString())
                .addBodyParameter("nama_regu", ed_namaRegu.text.toString())
                .addBodyParameter("jumlah_regu", ed_jumlahRegu.text.toString())
                .addBodyParameter("tanggal_naik", ed_tglNaik.text.toString())
                .addBodyParameter("tanggal_turun", ed_tglTurun.text.toString())
                .addBodyParameter("status_pemesanan", ed_status.selectedItem.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Rencana Pendakian Berhasil di Update"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaDataPendakian, LihatDataPendakian::class.java))
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

        btn_hapusPendakian.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Menghapus data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.DELETE_pendakian)
                .addBodyParameter("id_regu", ed_idRegu.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Rencana Pendakian Berhasil di Hapus"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaDataPendakian, LihatDataPendakian::class.java))
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

        private fun updateDateinViewtglNaik() {
            val newFormat = "yyyy/MM/dd"
            val sdf = SimpleDateFormat(newFormat, Locale.US)
            ed_tglNaik.setText(sdf.format(c.time))
        }

        private fun updateDateinViewtglTurun() {
            val newFormat = "yyyy/MM/dd"
            val sdf = SimpleDateFormat(newFormat, Locale.US)
            ed_tglTurun.setText(sdf.format(c.time))
        }

        private fun onEditPendakian() {

            // Mendapatkan daftar status yang tersedia dari resources strings.xml
            val statusPemesananArray = resources.getStringArray(R.array.status_pemesanan)

            // Membuat ArrayAdapter untuk menampilkan pilihan status
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, statusPemesananArray)

            // Menentukan tata letak saat drop down muncul
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Mengisi Spinner dengan data dari ArrayAdapter
            ed_status.adapter = adapter

            // Mendapatkan status yang sudah ada (dalam mode edit)
            val existingStatus = i.getStringExtra("txtstatusPemesanan")

            // Mencari indeks status yang sudah ada dalam daftar statusPemesananArray
            val position = statusPemesananArray.indexOf(existingStatus)

            // Mengatur posisi pilihan pada Spinner
            ed_status.setSelection(position)

            ed_idRegu.setText(i.getStringExtra("txtidRegu"))
            ed_namaRegu.setText(i.getStringExtra("txtnamaRegu"))
            ed_jumlahRegu.setText(i.getStringExtra("txtjumlahRegu"))
            ed_tglNaik.setText(i.getStringExtra("txttglNaik"))
            ed_tglTurun.setText(i.getStringExtra("txttglTurun"))

            tv_username.visibility = View.GONE
            ed_username.visibility = View.GONE
            btn_simpan.visibility = View.GONE
            ed_tglPesan.visibility = View.GONE
            tv_tglPesan.visibility = View.GONE
            btn_editPendakian.visibility = View.VISIBLE
            btn_hapusPendakian.visibility = View.GONE
            tv_id.visibility = View.VISIBLE
            ed_idRegu.visibility = View.VISIBLE
        }

        private fun onHapusPendakian() {

            ed_namaRegu.setText(i.getStringExtra("txtnamaRegu"))
            ed_idRegu.setText(i.getStringExtra("txtidRegu"))

            ed_tglPesan.visibility = View.GONE
            ed_jumlahRegu.visibility = View.GONE
            ed_tglPesan.visibility = View.GONE
            ed_tglNaik.visibility = View.GONE
            ed_tglTurun.visibility = View.GONE
            ed_status.visibility = View.GONE

            tv_tglPesan.visibility = View.GONE
            tv_jumlahRegu.visibility = View.GONE
            tv_tglPesan.visibility = View.GONE
            tv_tglNaik.visibility = View.GONE
            tv_tglTurun.visibility = View.GONE
            tv_status.visibility = View.GONE

            tv_username.visibility = View.GONE
            ed_username.visibility = View.GONE
            btn_simpan.visibility = View.GONE
            btn_editPendakian.visibility = View.GONE
            btn_hapusPendakian.visibility = View.VISIBLE
            tv_hapus.visibility = View.VISIBLE
            tv_id.visibility = View.VISIBLE
            ed_idRegu.visibility = View.VISIBLE
        }

}


