package com.salti.coba1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ListViewActivity : AppCompatActivity() {
    private lateinit var lv_data1: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        lv_data1 = findViewById(R.id.lv_data1)

        //Listview
        //widget listview --> Array adapter --> data source (array/list/database)

        //bikin array list
        val namaHewan = listOf(
            "Ayam",
            "Bebek",
            "Domba",
            "Elang",
            "Gajah",
            "Harimau",
            "Ikan Cupang",
            "Ikan Lele",
            "Ikan Mujair",
            "Ikan Patin"
        )

        //memasukkan data array ini ke dalam adapter
        //android layout --> layout bawaan untuk di adapter
        lv_data1.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaHewan)

        //untuk bisa di klik dari list
        lv_data1.setOnItemClickListener {
                parent, view, position, id ->
            Toast.makeText(this, "anda memilih : ${namaHewan[position]}",
                    Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}