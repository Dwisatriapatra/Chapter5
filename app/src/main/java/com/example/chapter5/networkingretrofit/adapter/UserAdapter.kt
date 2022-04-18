package com.example.chapter5.networkingretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter5.R
import com.example.chapter5.networkingretrofit.model.GetAllUsersResponseItem
import kotlinx.android.synthetic.main.item_adapter_user.view.*

class UserAdapter(private val listUser : List<GetAllUsersResponseItem>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView){
            with(listUser[position]){
                item_nama_user.text = name
                item_alamat_user.text = address
                item_umur_user.text = umur.toString()
            }
        }

//        holder.itemView.item_nama_user.text = listUser[position].name
//        holder.itemView.item_alamat_user.text = listUser[position].address
//        holder.itemView.item_umur_user.text = listUser[position].umur.toString()
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}