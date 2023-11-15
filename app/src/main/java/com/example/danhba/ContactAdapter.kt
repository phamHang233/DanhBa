package com.example.danhba

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactList: List<UserInfo>, private val context: Context) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentItem = contactList[position]
        holder.userName.text = currentItem.userName


        holder.itemView.setOnClickListener {
            val intent = Intent(context, UserInfoActivity::class.java)
//            intent.putExtra("id", currentItem.id)
            intent.putExtra("email", currentItem.email)
            intent.putExtra("userName", currentItem.userName)
            intent.putExtra("phone", currentItem.phone)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        val userName: TextView = itemView.findViewById(R.id.user_name)

        init {
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            Log.d("TAG", "onCreateContextMenu: $menuInfo")

            val inflater: MenuInflater = (context as Activity).menuInflater
            inflater.inflate(R.menu.context_menu, menu)


        }

    }
}
