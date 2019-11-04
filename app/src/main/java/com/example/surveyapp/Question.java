package com.example.surveyapp;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Questions")
public class Question {

    @PrimaryKey(autoGenerate = true)
    public long _id;

    public String question_content;

}
