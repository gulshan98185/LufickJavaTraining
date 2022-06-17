package com.lufick.training.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.lufick.training.Database.model.DeveloperDetails;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper( Context context) {
        super(context, Params.DATABASE_NAME, null, Params.DATABASE_VERSION);
        Log.d("myTag", "DatabaseHelper constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("myTag", "database onCreate called ");
        String create = "CREATE TABLE "+Params.TABLE_NAME+"("
                +Params.DEV_ID+" INTEGER PRIMARY KEY, "
                +Params.DEV_NAME+" TEXT, "
                +Params.DEV_EXPERIENCE+ " INTEGER, "
                +Params.DEV_SKILLS+ " TEXT,"
                +Params.DEV_PHONE_NO+" TEXT,"
                +Params.MISLANEOUS +" TEXT )";
        db.execSQL(create);
        Log.d("myTag", "table created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("myTag", "onUpgrade called ");
        if(newVersion>3) {
            String alterTable = "ALTER TABLE " + Params.TABLE_NAME
                    + " ADD COLUMN " + Params.DEV_PHONE_NO + " TEXT";
            db.execSQL(alterTable);
        }
    }

    //INSERT ,ContentValues
    public void insertData(DeveloperDetails developerDetails){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.DEV_NAME,developerDetails.getDev_name());
        values.put(Params.DEV_EXPERIENCE,developerDetails.getDev_exp());
        values.put(Params.DEV_SKILLS,developerDetails.getDev_skill());
        values.put(Params.MISLANEOUS, developerDetails.getMislaneous());
        db.insert(Params.TABLE_NAME,null,values);

        db.close();
        Log.d("myTag", "insertData completed ");
    }


//SELECT STATEMENT , CURSOR
    public ArrayList<DeveloperDetails> getAllDevelopers(){
        ArrayList<DeveloperDetails> developerDetailsArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String select = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                String devName = cursor.getString(cursor.getColumnIndex(Params.DEV_NAME));
                String devSkill = cursor.getString(cursor.getColumnIndex(Params.DEV_SKILLS));
                int devExp = cursor.getInt(cursor.getColumnIndex(Params.DEV_EXPERIENCE));

                DeveloperDetails developerDetails1 = new DeveloperDetails();
                developerDetails1.setDev_id(cursor.getInt(cursor.getColumnIndex(Params.DEV_ID)));
                developerDetails1.setDev_name(devName);
                developerDetails1.setDev_skill(devSkill);
                developerDetails1.setDev_exp(devExp);
                developerDetails1.setMislaneous(cursor.getString(cursor.getColumnIndex(Params.MISLANEOUS)));

                developerDetailsArrayList.add(developerDetails1);

            }while (cursor.moveToNext());
        }
        return developerDetailsArrayList;
    }


    public void updateById(DeveloperDetails developerDetails){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.DEV_NAME,developerDetails.getDev_name());
        values.put(Params.DEV_SKILLS,developerDetails.getDev_skill());
        values.put(Params.DEV_EXPERIENCE,developerDetails.getDev_exp());
       db.update(Params.TABLE_NAME,values,Params.DEV_ID +"=?",new String[]{String.valueOf(developerDetails.getDev_id())});
    }


}
