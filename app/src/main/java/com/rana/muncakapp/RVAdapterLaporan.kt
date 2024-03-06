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

class RVAdapterLaporan (private val context: Context, private var arrayList: ArrayList<Laporan>)
    : RecyclerView.Adapter<RVAdapterLaporan.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_laporan, parent, false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvnamaRegu.text = "  "+this.arrayList.get(position).nama_regu
        holder.tvjumlahRegu.text = "Jumlah Regu : "+this.arrayList.get(position).jumlah_regu
        holder.tvnamaPendaki.text = "Nama Pendaki : "+arrayList.get(position).nama_pendaki
        holder.tvalamat.text = "Alamat : "+arrayList.get(position).alamat
        holder.tvnoHP.text = "Nomor HP : "+arrayList.get(position).nohp_pribadi
        holder.tvstatusPendakian.text = "Status Pendakian : "+arrayList.get(position).status_pendakian
        holder.tvwaktuMulai.text = "Mulai : \n"+arrayList.get(position).waktu_mulai
        holder.tvwaktuSelesai.text = "Selesai: \n"+arrayList.get(position).waktu_selesai


        Log.d("RVAdapter, ", "onBindViewHolder : " + arrayList.size.toString())
    }

    fun setFilteredList(arrayList: ArrayList<Laporan>){
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvnamaRegu: TextView
        val tvjumlahRegu: TextView
        val tvnamaPendaki: TextView
        val tvalamat: TextView
        val tvnoHP: TextView
        val tvwaktuMulai: TextView
        val tvwaktuSelesai: TextView
        val tvstatusPendakian: TextView

        init {
            tvnamaRegu= view.findViewById(R.id.tv_namaRegu)
            tvjumlahRegu = view.findViewById(R.id.tv_jumlahRegu)
            tvnamaPendaki = view.findViewById(R.id.tv_namaPendaki)
            tvalamat = view.findViewById(R.id.tv_alamat)
            tvnoHP = view.findViewById(R.id.tv_noHPPribadi)
            tvwaktuMulai = view.findViewById(R.id.tv_waktuMulai)
            tvwaktuSelesai = view.findViewById(R.id.tv_waktuSelesai)
            tvstatusPendakian = view.findViewById(R.id.tv_statusPendakian)
        }

    }

}