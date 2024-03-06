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

class RVAdapterPendaki(private val context: Context, private var arrayList: ArrayList<Pendaki>)
    : RecyclerView.Adapter<RVAdapterPendaki.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_pendaki, parent, false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvidPendaki.text = "ID Pendaki : "+this.arrayList.get(position).id_pendaki.toString()
        holder.tvidRegu.text = "ID Regu : "+this.arrayList.get(position).id_regu.toString()
        holder.tvnamaRegu.text = ""+arrayList.get(position).nama_regu
        holder.tvnamaPendaki.text = "Nama Pendaki : "+arrayList.get(position).nama_pendaki
        holder.tvumurPendaki.text = "Umur : "+arrayList.get(position).umur
        holder.tvnoHPPribadi.text = "No HP Pribadi : "+arrayList.get(position).nohp_pribadi
        holder.tvnoHPKeluarga.text = "No HP Keluarga : "+arrayList.get(position).nohp_keluarga
        holder.tvalamat.text = "Alamat : "+arrayList.get(position).alamat

        holder.btn_edit.setOnClickListener {
            val i = Intent(context, KelolaDataPendaki::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("editmode","1")
            i.putExtra("txtidPendaki", arrayList.get(position).id_pendaki)
            i.putExtra("txtnamaPendaki", arrayList.get(position).nama_pendaki)
            i.putExtra("txtumurPendaki", arrayList.get(position).umur)
            i.putExtra("txtnoHPPribadi", arrayList.get(position).nohp_pribadi)
            i.putExtra("txtnoHPKeluarga", arrayList.get(position).nohp_keluarga)
            i.putExtra("txtalamat", arrayList.get(position).alamat)
            context.startActivity(i)
        }

        holder.btn_hapus.setOnClickListener {
            val i = Intent(context, KelolaDataPendaki::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("hapusmode","1")
            i.putExtra("txtidPendaki", arrayList.get(position).id_pendaki)
            i.putExtra("txtnamaPendaki", arrayList.get(position).nama_pendaki)
            context.startActivity(i)
        }

        Log.d("RVAdapter, ", "onBindViewHolder : " + arrayList.size.toString())
    }

    fun setFilteredList(arrayList: ArrayList<Pendaki>){
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvidPendaki: TextView
        val tvidRegu: TextView
        val tvnamaPendaki: TextView
        val tvumurPendaki: TextView
        val tvnoHPPribadi: TextView
        val tvnoHPKeluarga: TextView
        val tvalamat: TextView
        val tvnamaRegu: TextView
        val btn_edit: LinearLayout
        val btn_hapus: LinearLayout

        init {
            tvidPendaki = view.findViewById(R.id.tv_idPendaki)
            tvidRegu = view.findViewById(R.id.tv_idRegu)
            tvnamaPendaki= view.findViewById(R.id.tv_namaPendaki)
            tvumurPendaki = view.findViewById(R.id.tv_umurPendaki)
            tvnoHPPribadi = view.findViewById(R.id.tv_noHPPribadi)
            tvnoHPKeluarga = view.findViewById(R.id.tv_noHPKeluarga)
            tvalamat = view.findViewById(R.id.tv_alamatPendaki)
            tvnamaRegu = view.findViewById(R.id.tv_namaRegu)
            btn_edit = view.findViewById(R.id.btn_edit)
            btn_hapus = view.findViewById(R.id.btn_hapus)
        }

    }

}