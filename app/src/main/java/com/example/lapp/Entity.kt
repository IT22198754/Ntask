package com.example.lapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_task")
class Entity (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority:String){
}