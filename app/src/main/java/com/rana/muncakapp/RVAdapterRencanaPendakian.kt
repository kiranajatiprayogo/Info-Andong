package com.rana.muncakapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapterRencanaPendakian (private val context: Context, private val arrayList: ArrayList<Pendakian>)
    : RecyclerView.Adapter<RVAdapterRencanaPendakian.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat, parent, false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvidRegu.text = "ID Regu : "+this.arrayList.get(position).id_regu.toString()
        holder.tvnamaRegu.text = "  "+this.arrayList.get(position).nama_regu
        holder.tvjumlahRegu.text = "Jumlah Regu : "+arrayList.get(position).jumlah_regu
        holder.tvtglPesan.text = "Tanggal Pemesanan : "+arrayList.get(position).tanggal_pemesanan
        holder.tvtglNaik.text = "Tanggal Naik : \n"+arrayList.get(position).tanggal_naik
        holder.tvtglTurun.text = "Tanggal Turun : \n"+arrayList.get(position).tanggal_turun
        holder.tvstatusPemesanan.text = "Status Pemesanan : "+arrayList.get(position).status_pemesanan

        holder.btn_lihatPendaki.setOnClickListener {
            val i = Intent(context, LihatRiwayatPendaki::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("lihatmode","1")
            i.putExtra("txtidRegu", arrayList.get(position).id_regu)
            context.startActivity(i)
        }

        holder.btn_lihatRiwayat.setOnClickListener {
            val i = Intent(context, LihatRiwayatPendakianUser::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("riwayatmode","1")
            i.putExtra("txtidRegu", arrayList.get(position).id_regu)
            context.startActivity(i)
        }

        holder.cv_rencanaPendakian.setOnClickListener {
            val i = Intent(context, KelolaRencanaPendakian::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("editmode","1")
            i.putExtra("txtidRegu", arrayList.get(position).id_regu)
            i.putExtra("txtnamaRegu", arrayList.get(position).nama_regu)
            i.putExtra("txtjumlahRegu", arrayList.get(position).jumlah_regu)
            i.putExtra("txttglNaik", arrayList.get(position).tanggal_naik)
            i.putExtra("txttglTurun", arrayList.get(position).tanggal_turun)
            i.putExtra("txtstatusPemesanan", arrayList.get(position).status_pemesanan)
            context.startActivity(i)
        }

        Log.d("RVAdapter, ", "onBindViewHolder : " + arrayList.size.toString())
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        val tvidRegu: TextView
        val tvnamaRegu: TextView
        val tvjumlahRegu: TextView
        val tvtglPesan: TextView
        val tvtglNaik: TextView
        val tvtglTurun: TextView
        val tvstatusPemesanan: TextView
        val btn_lihatRiwayat : LinearLayout
        val btn_lihatPendaki : LinearLayout
        val cv_rencanaPendakian : CardView

        init {
            tvidRegu= view.findViewById(R.id.tv_idRegu)
            tvnamaRegu= view.findViewById(R.id.tv_namaRegu)
            tvjumlahRegu = view.findViewById(R.id.tv_jumlahRegu)
            tvtglPesan = view.findViewById(R.id.tv_tglPesan)
            tvtglNaik = view.findViewById(R.id.tv_tglNaik)
            tvtglTurun = view.findViewById(R.id.tv_tglTurun)
            tvstatusPemesanan = view.findViewById(R.id.tv_statusPemesanan)
            btn_lihatRiwayat = view.findViewById(R.id.btn_lihatRiwayat)
            btn_lihatPendaki = view.findViewById(R.id.btn_lihatPendaki)
            cv_rencanaPendakian = view.findViewById(R.id.cv_riwayat)
        }

    }

}