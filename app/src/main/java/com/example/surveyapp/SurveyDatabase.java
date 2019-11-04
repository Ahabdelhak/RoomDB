package com.example.surveyapp;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Database(entities = {Question.class,User.class},version = 1)
public abstract class SurveyDatabase extends RoomDatabase {

    public abstract UserDAO getUserDAO();
    public abstract QuestionDAO getQuestionDAO();


    private static SurveyDatabase instance;

    private static String DATABASE_NAME="SurveyDemo.db";

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    public static SurveyDatabase getInstance(Context context){

        if (instance == null) {
            copyAttachedDatabase(context, DATABASE_NAME);
            instance = Room.databaseBuilder(context,

                    SurveyDatabase.class, DATABASE_NAME)
//                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    private static void copyAttachedDatabase(Context context, java.lang.String databaseName) {
        final File dbPath = context.getDatabasePath(databaseName);

        // If the database already exists, return
        if (dbPath.exists()) {
            return;
        }

        // Make sure we have a path to the file
        dbPath.getParentFile().mkdirs();

        // Try to copy database file
        try {
            final InputStream inputStream = context.getAssets().open("databases/" + databaseName);
            final OutputStream output = new FileOutputStream(dbPath);

            byte[] buffer = new byte[8192];
            int length;

            while ((length = inputStream.read(buffer, 0, 8192)) > 0) {
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            inputStream.close();
        } catch (IOException e) {
//            Log.d(TAG, "Failed to open file", e);
            e.printStackTrace();
        }

    }
}
