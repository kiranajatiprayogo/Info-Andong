package com.rana.muncakapp

import AppPermissions.Companion.permissionGranted
import AppPermissions.Companion.requestManageAllFilesPermission
import android.Manifest
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.itextpdf.text.*
import com.itextpdf.text.pdf.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import java.io.File as File1

class LaporanPendakian : AppCompatActivity() {

    private var arrayList = ArrayList<Laporan>()
    private lateinit var rvLaporan : RecyclerView

    private val STORAGE_PERMISSION_REQUEST = 1

    lateinit var btn_kembali : ImageView
    lateinit var ed_tglPesan1 : EditText
    lateinit var ed_tglPesan2 : EditText
    lateinit var btn_tampil : Button
    lateinit var btn_buat : CardView
    private var tgl1 : String = ""
    private var tgl2 : String = ""

    private var c = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_pendakian)

        if (!permissionGranted(this)) requestManageAllFilesPermission(this)

        rvLaporan = findViewById(R.id.rvLaporan)
        rvLaporan.setHasFixedSize(true)
        rvLaporan.layoutManager = LinearLayoutManager(this)

        btn_kembali= findViewById(R.id.iv_back)
        ed_tglPesan1= findViewById(R.id.tglPesan1)
        ed_tglPesan2= findViewById(R.id.tglPesan2)
        btn_tampil= findViewById(R.id.btn_tampil)
        btn_buat= findViewById(R.id.btn_buatPDF)

        val dateSetListener_tglPesan1 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewtglPesan1()
            }


        }
        val dateSetListener_tglPesan2 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateinViewtglPesan2()
            }
        }


        ed_tglPesan1.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener_tglPesan1,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        ed_tglPesan2.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener_tglPesan2,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        btn_kembali.setOnClickListener({
            val i = Intent(this@LaporanPendakian, DashboardAdmin::class.java);
            startActivity(i)
        })

        btn_buat.setOnClickListener {
            val startDate = ed_tglPesan1.text.toString()
            val endDate = ed_tglPesan2.text.toString()
            tgl1 = ed_tglPesan1.text.toString()
            tgl2 = ed_tglPesan2.text.toString()

            when {
                tgl1 == "" -> {
                    ed_tglPesan1.error = "Tidak boleh kosong"
                }
                tgl2 == "" -> {
                    ed_tglPesan2.error = "Tidak boleh kosong"
                }
                else -> {
                    createPDFFile(startDate, endDate)
                }
            }
        }


        btn_tampil.setOnClickListener {
            val loading = ProgressDialog(this)
            loading.setMessage("Memuat data...")
            loading.show()
            AndroidNetworking.post(ApiEndPoint.READ_laporan_pendakian)
                .addBodyParameter("tanggal1", ed_tglPesan1.text.toString())
                .addBodyParameter("tanggal2", ed_tglPesan2.text.toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        arrayList.clear()
                        val jsonArray = response?.optJSONArray("result")

                        if (jsonArray?.length() == 0)  {
                            loading.dismiss()
                            Toast.makeText(applicationContext, "Data Pendakian Kosong", Toast.LENGTH_SHORT).show()
                        }

                        for (i in 0 until jsonArray?.length()!!){
                            val jsonObject = jsonArray.optJSONObject(i)
                            arrayList.add(Laporan(jsonObject.getString("nama_regu"),jsonObject.getString("jumlah_regu"),
                                jsonObject.getString("nama_pendaki"),jsonObject.getString("alamat"),
                                jsonObject.getString("nohp_pribadi"), jsonObject.getString("waktu_mulai"),
                                jsonObject.getString("waktu_selesai"), jsonObject.getString("status_pendakian"))
                            )

                            if (jsonArray.length()-1 == i){
                                loading.dismiss()
                            }
                        }

                        val adapter = RVAdapterLaporan(applicationContext, arrayList)
                        adapter.notifyDataSetChanged()
                        rvLaporan.adapter = adapter
                        Log.d("LaporanPendakian ", "Load all notes : "+ arrayList.size.toString())
                    }

                    override fun onError(anError: ANError?) {
                        loading.dismiss()
                        Log.d("ON ERROR", anError?.errorDetail.toString())
                        Toast.makeText(applicationContext, "Failure," + anError.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == AppPermissions.REQUEST_MANAGE_ALL_FILES_PERMISSION) {
            // Handle the result of the permission request
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (android.os.Environment.isExternalStorageManager()) {
                    // Permission granted, you can proceed with file management operations
                    val startDate = ed_tglPesan1.text.toString()
                    val endDate = ed_tglPesan2.text.toString()

                    createPDFFile(startDate, endDate)// Retry creating the PDF after permission granted.
                } else {
                    // Permission denied
                    toastErrorMessage("Permission denied, cannot create PDF.")
                }
            }
        }
    }

    private fun createPDFFile(startDate: String, endDate: String) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission not granted, request it.
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                STORAGE_PERMISSION_REQUEST
            )
            return
        }

        // Permission granted, proceed with creating the PDF.
        val onError: (Exception) -> Unit = { toastErrorMessage(it.message.toString()) }
        val onFinish: (File1) -> Unit = { openFile(it) }

        val pdfService = PdfService()
        pdfService.createUserTable(
            data = arrayList,
            startDate = startDate,
            endDate = endDate,
            onFinish = { file ->
                openFile(file)
            },
            onError = { error ->
                toastErrorMessage(error.message.toString())
            }
        )
    }

    private fun openFile(file: java.io.File) {
        val path = FileHandler().getPathFromUri(this, file.toUri())

        // Buat intent untuk membuka file PDF dengan aplikasi PDF reader
        val pdfIntent = Intent(Intent.ACTION_VIEW)
        pdfIntent.setDataAndType(FileProvider.getUriForFile(this, "${BuildConfig.APPLICATION_ID}.fileprovider", file), "application/pdf")
        pdfIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION

        try {
            startActivity(pdfIntent)
        } catch (e: ActivityNotFoundException) {
            toastErrorMessage("Tidak dapat membuka file PDF")
        }
    }

    private fun toastErrorMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun updateDateinViewtglPesan1() {
        val newFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_tglPesan1.setText(sdf.format(c.time))
    }

    private fun updateDateinViewtglPesan2() {
        val newFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(newFormat, Locale.US)
        ed_tglPesan2.setText(sdf.format(c.time))
    }
}






