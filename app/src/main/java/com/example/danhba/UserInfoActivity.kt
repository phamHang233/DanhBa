package com.example.danhba

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        try {
            val userName = intent.getStringExtra("userName")
            val phone = intent.getStringExtra("phone")
            val email = intent.getStringExtra("email")
            Log.d("UserInfoActivity", "UserName: $userName, Phone: $phone, Email: $email")

            val name = findViewById<TextView>(R.id.name_detail)
            val phone_view = findViewById<TextView>(R.id.phone)
            val email_view = findViewById<TextView>(R.id.email)
            name.text = userName
            phone_view.text = phone
            email_view.text = email

            setResult(Activity.RESULT_OK, intent)
        } catch (ex: Exception) {
            setResult(Activity.RESULT_CANCELED)
        }
    }

}

