package com.example.buiphuongnam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {

    public  static final String DB_NAME = "USER";
    public static final int DB_VERSION = 1;

    public  static String TABLE_NAME = "TBL_STUDENT";
    public  static String ID = "_id";
    public  static String NAME = "name";
    public  static String ANSWER = "answer";
    public  static String DES = "des";
    public  DBHelper(Context context){
        super(context, DB_NAME, null , DB_VERSION);
    }


    public String addStudent(String user , String answer , String des){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,user);
        contentValues.put(ANSWER,answer);
        contentValues.put(DES,des);

        long isAdd  = db.insert(TABLE_NAME, null ,contentValues);
        if (isAdd == -1 ){
            return  "Add fail";
        }
        db.close();
        return  "Add success";
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
