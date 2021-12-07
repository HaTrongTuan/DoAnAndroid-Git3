package com.example.doanck2.com.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountDataBase extends SQLiteOpenHelper {

    public static final int ADB_VERSION = 1;
    public static final String ADB_NAME = "Account.sqlite";
    public static final String TBL_NAME = "User.Info";
    public static final String COL_A_ID = "A_Id";
    public static final String COL_A_USERNAME = "A_Username";
    public static final String COL_A_PASSWORD = "A_Password";
    public static final String COL_A_HOTEN = "A_Hoten";
    public static final String COL_A_SDT = "A_Sdt";
    public static final String COL_A_EMAIL = "A_Email";
    public static final String COL_A_BIRTHDAY = "A_Birthday" ;
    public static final String COL_A_CMND = "A_Cmnd";

    public AccountDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, ADB_NAME, null, ADB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_A_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_A_USERNAME + " VARCHAR(100), " + COL_A_PASSWORD + " VARCHAR(50), " +
                COL_A_HOTEN + " VARCHAR(100), " + COL_A_SDT + " VARCHAR(15), " + COL_A_EMAIL + " VARCHAR(50), " + COL_A_BIRTHDAY + " VARCHAR(20), " + COL_A_CMND + " VARCHAR(15))";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String username, String password, String hoten, String sdt, String email, String birthday, String cmnd){

    }
}
