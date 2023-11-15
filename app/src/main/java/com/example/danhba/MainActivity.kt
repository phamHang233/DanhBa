package com.example.danhba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    val contactList = listOf(
        UserInfo(1, "John Doe", "0123456789", "JohnDoe@gmail.com"),
        UserInfo(2, "Alice Smith", "0324356723", "aliceSmith@gmail.com"),
        UserInfo(3, "Bob Johnson", "0324568999", "@bobjohnson@gmail.com"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = ContactAdapter(contactList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        registerForContextMenu(recyclerView)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Lấy thông tin về item được chọn từ ContextMenu
        val menuInfo = item.menuInfo
//        Log.d("TAG", "$menuInfo")

        if (menuInfo != null && menuInfo is AdapterView.AdapterContextMenuInfo) {
            // Lấy thông tin về item được chọn từ ContextMenu
            val position = menuInfo.position

            // Lấy dữ liệu từ danh sách tại vị trí được chọn
            val selectedItem = contactList[position]

            // Xử lý các hành động dựa trên MenuItem được chọn
            when (item.itemId) {
                R.id.action_call -> {
                    Log.v("TAG", "action_call $selectedItem")
                    return true
                }
                R.id.action_sms -> {
                    Log.v("TAG", "Share $selectedItem")
                    return true
                }
                // Xử lý các hành động khác
            }
        }

        // Trả về false nếu không xử lý được
        return super.onContextItemSelected(item)
    }


}

