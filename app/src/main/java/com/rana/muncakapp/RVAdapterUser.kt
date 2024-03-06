package com.rana.muncakapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapterUser (private val context: Context, private val arrayList: ArrayList<User>)
    : RecyclerView.Adapter<RVAdapterUser.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvusernameUser.text = "Halo, "+arrayList.get(position).username.toString()
        holder.tvemailUser.text = "Email : "+arrayList.get(position).email
        holder.tvtipeUser.text = "Tipe User : "+arrayList.get(position).tipe_user

        Log.d("RVAdapter, ", "onBindViewHolder : " + arrayList.size.toString())
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvusernameUser: TextView
        val tvemailUser: TextView
        val tvtipeUser: TextView

        init {
            tvusernameUser= view.findViewById(R.id.profilUser)
            tvemailUser = view.findViewById(R.id.emailUser)
            tvtipeUser = view.findViewById(R.id.tipeUser)
        }

    }

}