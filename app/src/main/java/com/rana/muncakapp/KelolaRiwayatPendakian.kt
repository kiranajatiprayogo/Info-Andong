package com.rana.muncakapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
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
import kotlin.math.min

class KelolaRiwayatPendakian : AppCompatActivity() {

    lateinit var i:Intent


    var hour        = 0
    var minute      = 0


    lateinit var ed_idRegu          : EditText
    lateinit var ed_idPendaki         : EditText
    lateinit var ed_statusPendakian : Spinner
    lateinit var ed_waktuMulai      : TextView
    lateinit var ed_naikPos1        : EditText
    lateinit var ed_naikPos2        : EditText
    lateinit var ed_naikPos3        : EditText
    lateinit var ed_turunPos3       : EditText
    lateinit var ed_turunPos2       : EditText
    lateinit var ed_turunPos1       : EditText
    lateinit var ed_waktuSelesai    : EditText
    lateinit var ed_idPendakian     : TextView

    lateinit var tv_idRegu          : TextView
    lateinit var tv_idPendaki       : TextView
    lateinit var tv_statusPendakian : TextView
    lateinit var tv_waktuMulai      : TextView
    lateinit var tv_naikPos1        : TextView
    lateinit var tv_naikPos2        : TextView
    lateinit var tv_naikPos3        : TextView
    lateinit var tv_turunPos3       : TextView
    lateinit var tv_turunPos2       : TextView
    lateinit var tv_turunPos1       : TextView
    lateinit var tv_waktuSelesai    : TextView
    lateinit var tv_idPendakian     : TextView

    lateinit var tv_hapus           : TextView

    lateinit var btn_simpan         : Button
    lateinit var btn_edit           : Button
    lateinit var btn_hapus          : Button

    private var c = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_riwayat_pendakian)

        btn_simpan              = findViewById(R.id.btn_simpanRiwayatPendakian)
        btn_edit                = findViewById(R.id.btn_editRiwayatPendakian)
        btn_hapus               = findViewById(R.id.btn_hapusRiwayatPendakian)
        tv_hapus                = findViewById(R.id.tv_yakin)

        tv_idRegu               = findViewById(R.id.tv_idRegu)
        tv_idPendaki            = findViewById(R.id.tv_idPendaki)
        tv_statusPendakian      = findViewById(R.id.tv_statusPendakian)
        tv_waktuMulai           = findViewById(R.id.tv_waktuMulai)
        tv_naikPos1             = findViewById(R.id.tv_NaikPos1)
        tv_naikPos2             = findViewById(R.id.tv_NaikPos2)
        tv_naikPos3             = findViewById(R.id.tv_NaikPos3)
        tv_turunPos3            = findViewById(R.id.tv_TurunPos3)
        tv_turunPos2            = findViewById(R.id.tv_TurunPos2)
        tv_turunPos1            = findViewById(R.id.tv_TurunPos1)
        tv_waktuSelesai         = findViewById(R.id.tv_waktuSelesai)
        tv_idPendakian          = findViewById(R.id.tv_id)

        ed_idRegu             = findViewById(R.id.ed_idRegu)
        ed_idPendaki            = findViewById(R.id.ed_idPendaki)
        ed_statusPendakian      = findViewById(R.id.sp_statusPendakian)
        ed_waktuMulai           = findViewById(R.id.ed_waktuMulai)
        ed_naikPos1             = findViewById(R.id.ed_NaikPos1)
        ed_naikPos2             = findViewById(R.id.ed_NaikPos2)
        ed_naikPos3             = findViewById(R.id.ed_NaikPos3)
        ed_turunPos3            = findViewById(R.id.ed_TurunPos3)
        ed_turunPos2            = findViewById(R.id.ed_TurunPos2)
        ed_turunPos1            = findViewById(R.id.ed_TurunPos1)
        ed_waktuSelesai         = findViewById(R.id.ed_waktuSelesai)
        ed_idPendakian          = findViewById(R.id.tv_idPendakian)

        btn_simpan.visibility       = View.VISIBLE
        btn_edit.visibility         = View.GONE
        btn_hapus.visibility        = View.GONE
        tv_hapus.visibility         = View.GONE

        ed_idPendakian.visibility   = View.GONE
        ed_naikPos1.visibility      = View.GONE
        ed_naikPos2.visibility      = View.GONE
        ed_naikPos3.visibility      = View.GONE
        ed_turunPos3.visibility     = View.GONE
        ed_turunPos2.visibility     = View.GONE
        ed_turunPos1.visibility     = View.GONE
        ed_waktuSelesai.visibility  = View.GONE

        tv_idPendakian.visibility   = View.GONE
        tv_naikPos1.visibility      = View.GONE
        tv_naikPos2.visibility      = View.GONE
        tv_naikPos3.visibility      = View.GONE
        tv_turunPos3.visibility     = View.GONE
        tv_turunPos2.visibility     = View.GONE
        tv_turunPos1.visibility     = View.GONE
        tv_waktuSelesai.visibility  = View.GONE


        i=intent
        if (i.hasExtra("editmode")){
            if (i.getStringExtra("editmode").equals("1")){
                onEditRiwayatPendakian()
            }
        }

        if (i.hasExtra("hapusmode")){
            if (i.getStringExtra("hapusmode").equals("1")){
                onHapusRiwayatPendakian()
            }
        }

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dateTime = simpleDateFormat.format(c.time)
        ed_waktuMulai.text = dateTime

        val dateSetListener_NaikPos1 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewNaikPos1()

            }
        }

        val timeSetListener_NaikPos1 = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewNaikPos1()
            }
        }

        ed_naikPos1.setOnClickListener {

            TimePickerDialog(this, timeSetListener_NaikPos1, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_NaikPos1,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dateSetListener_NaikPos2 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewNaikPos2()

            }
        }

        val timeSetListener_NaikPos2 = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewNaikPos2()
            }
        }

        ed_naikPos2.setOnClickListener {

            TimePickerDialog(this, timeSetListener_NaikPos2, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_NaikPos2,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dateSetListener_NaikPos3 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewNaikPos3()

            }
        }

        val timeSetListener_NaikPos3 = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewNaikPos3()
            }
        }

        ed_naikPos3.setOnClickListener {

            TimePickerDialog(this, timeSetListener_NaikPos3, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_NaikPos3,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dateSetListener_TurunPos3 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewTurunPos3()

            }
        }

        val timeSetListener_TurunPos3  = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewTurunPos3()
            }
        }

        ed_turunPos3.setOnClickListener {

            TimePickerDialog(this, timeSetListener_TurunPos3, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_TurunPos3,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dateSetListener_TurunPos2 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewTurunPos2()

            }
        }

        val timeSetListener_TurunPos2  = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewTurunPos2()
            }
        }

        ed_turunPos2.setOnClickListener {

            TimePickerDialog(this, timeSetListener_TurunPos2, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_TurunPos2,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dateSetListener_TurunPos1 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewTurunPos1()

            }
        }

        val timeSetListener_TurunPos1  = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewTurunPos1()
            }
        }

        ed_turunPos1.setOnClickListener {

            TimePickerDialog(this, timeSetListener_TurunPos1, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_TurunPos1,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val dateSetListener_WaktuSelesai = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewNaikPos2()

            }
        }

        val timeSetListener_WaktuSelesai = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                c.set(Calendar.HOUR_OF_DAY, hourOfDay)
                c.set(Calendar.MINUTE, minute)
                updateDateinViewWaktuSelesai()
            }
        }

        ed_waktuSelesai.setOnClickListener {

            TimePickerDialog(this, timeSetListener_WaktuSelesai, hour, minute, true).show()

            DatePickerDialog(
                this,
                dateSetListener_WaktuSelesai,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        btn_simpan.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Menambahkan data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.CREATE_riwayat_pendakian)
                .addBodyParameter("id_pendakian", ed_idPendakian.text.toString())
                .addBodyParameter("id_regu", ed_idRegu.text.toString())
                .addBodyParameter("id_pendaki", ed_idPendaki.text.toString())
                .addBodyParameter("status_pendakian", ed_statusPendakian.selectedItem.toString())
                .addBodyParameter("waktu_mulai", ed_waktuMulai.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Riwayat Pendakian Berhasil di Tambahkan"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaRiwayatPendakian, LihatRiwayatPendakian::class.java))
                            finish()
                        }else {
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ON ERROR", anError?.errorDetail.toString())
                        Toast.makeText(applicationContext, "Data Riwayat Pendakian Gagal di Tambahkan", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        btn_edit.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Mengubah data...")
            loading.show()

            AndroidNetworking.post(ApiEndPoint.UPDATE_riwayat_pendakian)
                .addBodyParameter("id_pendakian", ed_idPendakian.text.toString())
                .addBodyParameter("status_pendakian", ed_statusPendakian.selectedItem.toString())
                .addBodyParameter("naik_pos1", ed_naikPos1.text.toString())
                .addBodyParameter("naik_pos2", ed_naikPos2.text.toString())
                .addBodyParameter("naik_pos3", ed_naikPos3.text.toString())
                .addBodyParameter("turun_pos3", ed_turunPos3.text.toString())
                .addBodyParameter("turun_pos2", ed_turunPos2.text.toString())
                .addBodyParameter("turun_pos1", ed_turunPos1.text.toString())
                .addBodyParameter("waktu_selesai", ed_waktuSelesai.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Riwayat Pendakian Berhasil di Update"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaRiwayatPendakian, LihatRiwayatPendakian::class.java))
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

            AndroidNetworking.post(ApiEndPoint.DELETE_riwayat_pendakian)
                .addBodyParameter("id_pendakian", ed_idPendakian.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        loading.dismiss()
                        if(response?.getString("message")=="Data Riwayat Pendakian Berhasil di Hapus"){
                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@KelolaRiwayatPendakian, LihatRiwayatPendakian::class.java))
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

    private fun onEditRiwayatPendakian() {

        // Mendapatkan daftar status yang tersedia dari resources strings.xm
        val statusPendakianArray = resources.getStringArray(R.array.status_pendakian)

        // Membuat ArrayAdapter untuk menampilkan pilihan status
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, statusPendakianArray)

        // Menentukan tata letak saat drop down muncul
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Mengisi Spinner dengan data dari ArrayAdapter
        ed_statusPendakian.adapter = adapter

        // Mendapatkan status yang sudah ada (dalam mode edit)
        val existingStatus = i.getStringExtra("txtstatusPendakian")

        // Mencari indeks status yang sudah ada dalam daftar statusPemesananArray
        val position = statusPendakianArray.indexOf(existingStatus)

        // Mengatur posisi pilihan pada Spinner
        ed_statusPendakian.setSelection(position)

        ed_idPendakian.setText(i.getStringExtra("txtidPendakian"))
        ed_naikPos1.setText(i.getStringExtra("txtnaikPos1"))
        ed_naikPos2.setText(i.getStringExtra("txtnaikPos2"))
        ed_naikPos3.setText(i.getStringExtra("txtnaikPos3"))
        ed_turunPos3.setText(i.getStringExtra("txtturunPos3"))
        ed_turunPos2.setText(i.getStringExtra("txtturunPos2"))
        ed_turunPos1.setText(i.getStringExtra("txtturunPos1"))
        ed_waktuSelesai.setText(i.getStringExtra("txtwaktuSelesai"))

        btn_simpan.visibility       = View.GONE
        btn_edit.visibility         = View.VISIBLE
        btn_hapus.visibility        = View.GONE
        tv_hapus.visibility         = View.GONE

        ed_idPendakian.visibility   = View.VISIBLE
        ed_waktuMulai.visibility    = View.GONE
        ed_naikPos1.visibility      = View.VISIBLE
        ed_naikPos2.visibility      = View.VISIBLE
        ed_naikPos3.visibility      = View.VISIBLE
        ed_turunPos3.visibility     = View.VISIBLE
        ed_turunPos2.visibility     = View.VISIBLE
        ed_turunPos1.visibility     = View.VISIBLE
        ed_waktuSelesai.visibility  = View.VISIBLE
        ed_idPendaki.visibility     = View.GONE
        ed_idRegu.visibility        = View.GONE

        tv_idPendakian.visibility   = View.VISIBLE
        tv_waktuMulai.visibility    = View.GONE
        tv_naikPos1.visibility      = View.VISIBLE
        tv_naikPos2.visibility      = View.VISIBLE
        tv_naikPos3.visibility      = View.VISIBLE
        tv_turunPos3.visibility     = View.VISIBLE
        tv_turunPos2.visibility     = View.VISIBLE
        tv_turunPos1.visibility     = View.VISIBLE
        tv_waktuSelesai.visibility  = View.VISIBLE
        tv_idRegu.visibility        = View.GONE
        tv_idPendaki.visibility     = View.GONE
    }

    private fun onHapusRiwayatPendakian() {

        ed_idRegu.setText(i.getStringExtra("txtnamaRegu"))
        ed_idPendaki.setText(i.getStringExtra("txtnamaPendaki"))
        ed_idPendakian.setText(i.getStringExtra("txtidPendakian"))

        btn_simpan.visibility       = View.GONE
        btn_edit.visibility         = View.GONE
        btn_hapus.visibility        = View.VISIBLE
        tv_hapus.visibility         = View.VISIBLE

        ed_idPendakian.visibility       = View.VISIBLE
        ed_waktuMulai.visibility        = View.GONE
        ed_naikPos1.visibility          = View.GONE
        ed_naikPos2.visibility          = View.GONE
        ed_naikPos3.visibility          = View.GONE
        ed_turunPos3.visibility         = View.GONE
        ed_turunPos2.visibility         = View.GONE
        ed_turunPos1.visibility         = View.GONE
        ed_statusPendakian.visibility   = View.GONE
        ed_idPendaki.visibility         = View.GONE
        ed_idRegu.visibility            = View.GONE

        tv_idPendakian.visibility   = View.VISIBLE
        tv_waktuMulai.visibility     = View.GONE
        tv_naikPos1.visibility      = View.GONE
        tv_naikPos2.visibility      = View.GONE
        tv_naikPos3.visibility      = View.GONE
        tv_turunPos3.visibility     = View.GONE
        tv_turunPos2.visibility     = View.GONE
        tv_turunPos1.visibility     = View.GONE
        tv_waktuSelesai.visibility  = View.GONE
        tv_statusPendakian.visibility  = View.GONE
        tv_idRegu.visibility      = View.GONE
        tv_idPendaki.visibility   = View.GONE
    }

    private fun updateDateinViewNaikPos1() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_naikPos1.setText(sdf.format(c.time))
    }

    private fun updateDateinViewNaikPos2() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_naikPos2.setText(sdf.format(c.time))
    }

    private fun updateDateinViewNaikPos3() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_naikPos3.setText(sdf.format(c.time))
    }

    private fun updateDateinViewTurunPos3() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_turunPos3.setText(sdf.format(c.time))
    }

    private fun updateDateinViewTurunPos2() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_turunPos2.setText(sdf.format(c.time))
    }

    private fun updateDateinViewTurunPos1() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_turunPos1.setText(sdf.format(c.time))
    }

    private fun updateDateinViewWaktuSelesai() {
        val newFormat = "yyyy/MM/dd HH:mm:ss"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_waktuSelesai.setText(sdf.format(c.time))
    }

}


