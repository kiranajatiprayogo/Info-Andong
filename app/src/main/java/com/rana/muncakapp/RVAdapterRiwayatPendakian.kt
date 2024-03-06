package com.rana.muncakapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapterRiwayatPendakian (private val context: Context, private var arrayList: ArrayList<RiwayatPerjalanan>)
    : RecyclerView.Adapter<RVAdapterRiwayatPendakian.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat_pendakian, parent, false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvnamaRegu.text = "  "+this.arrayList.get(position).nama_regu.toString()
        holder.tvnamaPendaki.text = "Nama Pendaki : "+arrayList.get(position).nama_pendaki
        holder.tvstatusPendakian.text = "Status Pendakian : "+arrayList.get(position).status_pendakian
        holder.tvnaikPos1.text = "Tiba di POS 1 : "+arrayList.get(position).naik_pos1
        holder.tvnaikPos2.text = "Tiba di POS 2 : "+arrayList.get(position).naik_pos2
        holder.tvnaikPos3.text = "Tiba di POS 3 : "+arrayList.get(position).naik_pos3
        holder.tvturunPos3.text = "Tiba di POS 3 : "+arrayList.get(position).turun_pos3
        holder.tvturunPos2.text = "Tiba di POS 2 : "+arrayList.get(position).turun_pos2
        holder.tvturunPos1.text = "Tiba di POS 1 : "+arrayList.get(position).turun_pos1
        holder.tvwaktuMulai.text = "Waktu Mulai : \n"+arrayList.get(position).waktu_mulai
        holder.tvwaktuSelesai.text = "Waktu Selesai : \n"+arrayList.get(position).waktu_selesai

        holder.btn_edit.setOnClickListener {
            val i = Intent(context, KelolaRiwayatPendakian::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("editmode","1")
            i.putExtra("txtidPendakian", arrayList.get(position).id_pendakian)
            i.putExtra("txtstatusPendakian", arrayList.get(position).status_pendakian)
            i.putExtra("txtnaikPos1", arrayList.get(position).naik_pos1)
            i.putExtra("txtnaikPos2", arrayList.get(position).naik_pos2)
            i.putExtra("txtnaikPos3", arrayList.get(position).naik_pos3)
            i.putExtra("txtturunPos3", arrayList.get(position).turun_pos3)
            i.putExtra("txtturunPos2", arrayList.get(position).turun_pos2)
            i.putExtra("txtturunPos1", arrayList.get(position).turun_pos1)
            i.putExtra("txtwaktuSelesai", arrayList.get(position).waktu_selesai)
            context.startActivity(i)
        }

        holder.btn_hapus.setOnClickListener {
            val i = Intent(context, KelolaRiwayatPendakian::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("hapusmode","1")
            i.putExtra("txtnamaRegu", arrayList.get(position).nama_regu)
            i.putExtra("txtnamaPendaki", arrayList.get(position).nama_pendaki)
            i.putExtra("txtidPendakian", arrayList.get(position).id_pendakian)
            context.startActivity(i)
        }

        Log.d("RVAdapter, ", "onBindViewHolder : " + arrayList.size.toString())
    }

    fun setFilteredList(arrayList: ArrayList<RiwayatPerjalanan>){
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvnamaRegu: TextView
        val tvnamaPendaki: TextView
        val tvstatusPendakian: TextView
        val tvwaktuMulai: TextView
        val tvnaikPos1: TextView
        val tvnaikPos2: TextView
        val tvnaikPos3: TextView
        val tvturunPos3: TextView
        val tvturunPos2: TextView
        val tvturunPos1: TextView
        val tvwaktuSelesai: TextView
        val btn_edit: LinearLayout
        val btn_hapus: LinearLayout

        init {
            tvnamaRegu= view.findViewById(R.id.tv_namaRegu)
            tvnamaPendaki= view.findViewById(R.id.tv_namaPendaki)
            tvstatusPendakian= view.findViewById(R.id.tv_statusPendakian)
            tvwaktuMulai= view.findViewById(R.id.tv_waktuMulai)
            tvnaikPos1= view.findViewById(R.id.tv_naikPos1)
            tvnaikPos2= view.findViewById(R.id.tv_naikPos2)
            tvnaikPos3= view.findViewById(R.id.tv_naikPos3)
            tvturunPos3= view.findViewById(R.id.tv_turunPos3)
            tvturunPos2= view.findViewById(R.id.tv_turunPos2)
            tvturunPos1= view.findViewById(R.id.tv_turunPos1)
            tvwaktuSelesai= view.findViewById(R.id.tv_waktuSelesai)
            btn_edit = view.findViewById(R.id.btn_edit)
            btn_hapus = view.findViewById(R.id.btn_hapus)
        }

    }

}