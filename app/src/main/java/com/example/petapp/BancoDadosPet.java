package com.example.petapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BancoDadosPet extends SQLiteOpenHelper {

    public BancoDadosPet(@Nullable Context context) {
        super(context, "pet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE PET(id INTEGER NOT NULL PRIMARY KEY, nome TEXT, idade INTEGER)";
        sqLiteDatabase.execSQL(sql);
        Log.i("pet","criado tabela no banco de dados");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * funcao que adiciona um pet no banco de dados.
      */
    public void adicionarPet(Pet pet){
        String sql = "INSERT INTO PET(nome,idade) values('"+ pet.nome+"',"+ pet.idade +")";
        Log.i("pet","sql insert: " + sql);
        super.getWritableDatabase().execSQL(sql);
        Log.i("pet","executado sql insert");
    }
}
