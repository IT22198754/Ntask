package com.example.lapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.lapp.databinding.ActivityCreateCardBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCardBinding
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database=Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"my_task"
        ).build()
        binding.saveButton.setOnClickListener{
            var title=binding.createTitle.text.toString()
            var priority=binding.createPriority.text.toString()
            if(title.trim{it<=' '}.isNotEmpty() && priority.trim{it<=' '}.isNotEmpty()){
                DataObject.setData(title,priority)
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title,priority))
                    //Log.i("harsh", database.dao().getTask().toString())
                }
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}