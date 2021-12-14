package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

public class AccountDataBase extends SQLiteOpenHelper {
    public static final int ADB_VERSION = 1;
    public static final String ADB_NAME = "Account.sqlite";
    public static final String TBL_NAME = "Users";
    public static final String COL_A_ID = "A_Id";
    public static final String COL_A_USERNAME = "A_Username";
    public static final String COL_A_PASSWORD = "A_Password";
    public static final String COL_A_FULLNAME = "A_Fullname";
    public static final String COL_A_PHONE = "A_Phone";
    public static final String COL_A_EMAIL = "A_Email";
    public static final String COL_A_BIRTH = "A_Birth";
    public static final String COL_A_PHOTO = "A_Photo";



    public AccountDataBase(@Nullable Context context) {
        super(context, ADB_NAME, null, ADB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_A_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_A_USERNAME + " VARCHAR(100), " + COL_A_PASSWORD + " VARCHAR(50), " + COL_A_FULLNAME + " VARCHAR(50), " + COL_A_PHONE + " INTEGER, " + COL_A_EMAIL + " VARCHAR(100), "
                    + COL_A_BIRTH +" INTEGER, " + COL_A_PHOTO + " BLOB)";
            sqLiteDatabase.execSQL(sql);
        }catch (Exception e){
            Log.e("Error:", e.toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    public  int getCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public  boolean insertData(String username, String password,String fullname, String phone, String email, String birth, byte[] photo){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO " + TBL_NAME + " VALUES(null,?,?,?, ?, ?, ?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.bindString(1, username);
        statement.bindString(2, password);
        statement.bindString(3, fullname);
        statement.bindString(4, phone);
        statement.bindString(5, email);
        statement.bindString(6, birth);
        statement.bindBlob(7, photo);
        statement.executeInsert();
        return true;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TBL_NAME + " WHERE " + COL_A_USERNAME +"=?" , new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public  Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT * FROM " + TBL_NAME + " WHERE " + COL_A_USERNAME +"=?" , new String[]{username});
        Cursor cursor2 = sqLiteDatabase.rawQuery("SELECT * FROM " + TBL_NAME + " WHERE " + COL_A_PASSWORD +"=?" , new String[]{password});
        if (cursor1.getCount() > 0 && cursor2.getCount()>0 &&cursor2.equals(cursor1)) {
            return true;
        }else {
            return false;
        }
    }}

