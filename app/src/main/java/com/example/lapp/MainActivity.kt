package com.example.lapp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.add
import kotlinx.android.synthetic.main.activity_main.deleteAll
import kotlinx.android.synthetic.main.activity_main.recycler_view


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener {
            val intent = Intent(this,CreateCard::class.java)
            startActivity(intent)
        }
        deleteAll.setOnClickListener {
            DataObject.deleteAll()
        }


        recycler_view.adapter = Adapter(DataObject.getAllData())
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}