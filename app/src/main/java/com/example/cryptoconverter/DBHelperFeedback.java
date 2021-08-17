package com.example.cryptoconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperFeedback extends SQLiteOpenHelper {

    public static final String DBNAME = "Feedback.db";

    public DBHelperFeedback(Context context) {
        super(context, "Feedback.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDBFeed) {
        MyDBFeed.execSQL("create Table feed(feedback TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDBFeed, int oldVersion, int newVersion) {
        MyDBFeed.execSQL("drop Table if exists feed");
    }

    public boolean insertData(String feedback){
        SQLiteDatabase MyDBFeed = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("feedback", feedback);
        long result = MyDBFeed.insert("feed", null, contentValues);
        if(result==1) return false;
        else
            return true;
    }

    public Boolean checkfeedback(String feed){
        SQLiteDatabase MyDBFeed = this.getWritableDatabase();
        Cursor cursor = MyDBFeed.rawQuery("Select * from feed where feedback = ?", new String[] {feed});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
