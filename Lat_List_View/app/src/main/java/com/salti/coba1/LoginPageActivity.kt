package com.salti.coba1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPageActivity : AppCompatActivity() {

    private lateinit var eUsername: EditText
    private lateinit var ePassword: EditText
    private lateinit var btnLoginn: Button
    private lateinit var btnList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        eUsername = findViewById(R.id.eUsername)
        ePassword = findViewById(R.id.ePassword)
        btnLoginn = findViewById(R.id.btnLoginn)
        btnList = findViewById(R.id.btnList)

        btnLoginn.setOnClickListener() {
            val nUsername = eUsername.text.toString()
            //ini ngambil dari edit text kemudian convert ke string
            val nPassword = ePassword.text.toString()

            /// passing data --> pengiriman data atau value dari satu activity ke activity lain
            //intent --> put extras --> ini untuk penyimpanan dan pengiriman
            //get extras --> ini untuk pengambilan

            val intenPassingData = Intent(
                this@LoginPageActivity,
                welcomePageActivity::class.java
            )
            //proses put data
            intenPassingData.putExtra("username", nUsername)
            intenPassingData.putExtra("password", nPassword)
            //cek data apa ada tidak,  LOGCAT
            Log.d("cek data username", nUsername)
            Log.d("cek data password", nPassword)
            //pindah dan membawa datanya
            startActivity(intenPassingData)

            btnList.setOnClickListener {
                val intent = Intent(this@LoginPageActivity, ListViewActivity::class.java)
                startActivity(intent)
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
