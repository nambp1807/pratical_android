package com.example.buiphuongnam.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static com.example.buiphuongnam.database.AppDatabase appDatabase;
    public abstract StudentDAO studentDAO();

    public static com.example.buiphuongnam.database.AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    com.example.buiphuongnam.database.AppDatabase.class, "Student.db").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}