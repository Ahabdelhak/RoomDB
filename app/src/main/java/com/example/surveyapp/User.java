package com.example.surveyapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public long _id;

    public String Name;




}