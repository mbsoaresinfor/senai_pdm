package com.example.petapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLog extends SQLiteOpenHelper {
    public RepositorioLog(@Nullable Context context) {
        super(context, "log", null, 1);
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

    public List<Log> listarLog(){
        ArrayList<Log> lista = new ArrayList<>();
        String sql = "select * from LOG";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Log log = new Log();
            log.id = cursor.getInt(0);
            log.dataOperacao = cursor.getString(1);
            log.operacao = cursor.getString(2);
            lista.add(log);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }
}
