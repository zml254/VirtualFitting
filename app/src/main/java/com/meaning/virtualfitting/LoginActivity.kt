package com.meaning.virtualfitting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_login_login.setOnClickListener {
//            var userName = et_login_user_name.text.toString()
//            var password = et_login_password.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}