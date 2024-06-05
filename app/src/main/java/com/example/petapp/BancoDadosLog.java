package com.example.petapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.petapp.Log;

import androidx.annotation.Nullable;

public class BancoDadosLog  extends SQLiteOpenHelper {
    public BancoDadosLog(@Nullable Context context) {
        super(context, "pet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE LOG(id INTEGER NOT NULL PRIMARY KEY, dataOperacao TEXT, operacao TEXT)";
        sqLiteDatabase.execSQL(sql);
        android.util.Log.i("pet","criado tabela no banco de dados");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirLog(Log log){
        String sql = "INSERT INTO LOG(dataOperacao,operacao) values('"+ log.dataOperacao + "','"+ log.operacao +"')";
        android.util.Log.i("pet","sql insert: " + sql);
        super.getWritableDatabase().execSQL(sql);
        android.util.Log.i("pet","executado sql insert");
    }
}
