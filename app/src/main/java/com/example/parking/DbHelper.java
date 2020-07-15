package com.example.parking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static int VERSION = 3;
    private static String DB_NAME = "DB_VEICULOS";
    public static String TABLE_VEICULOS = "veiculos";


    public DbHelper( Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_VEICULOS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " tipo VARCHAR(10)," +
                " nome VARCHAR(30)," +
                " marca VARCHAR(30)," +
                " cor VARCHAR(30)," +
                " ano VARCHAR(4)," +
                " dataE VARCHAR(13)," +
                " dataS VARCHAR(13)," +
                " horarioE VARCHAR(13)," +
                " horarioS VARCHAR(13)); ";

        try{
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");
        }catch(Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = " DROP TABLE IF EXISTS " + TABLE_VEICULOS + ";";
        try{
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualziar app");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualziar app" + e.getMessage());
        }

    }
}
