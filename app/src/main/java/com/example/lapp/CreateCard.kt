package com.example.lapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_create_card.button
import kotlinx.android.synthetic.main.activity_create_card.create_priority
import kotlinx.android.synthetic.main.activity_create_card.create_title

class CreateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        button.setOnClickListener{
            if (create_title.text.toString().trim{it<=' '}.isNotEmpty()
                && create_priority.text.toString().trim{it<=' '}.isNotEmpty())
            {
                var title = create_title.getText().toString()
                var priority=create_priority.getText().toString()
                DataObject.setData(title, priority)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
        }
    }
}
