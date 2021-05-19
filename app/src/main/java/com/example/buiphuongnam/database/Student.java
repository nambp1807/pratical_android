package com.example.buiphuongnam.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String username;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "answer")
    public String answer;

    @ColumnInfo(name = "des")
    public String des;

}
