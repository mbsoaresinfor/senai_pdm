package com.example.petapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPet extends SQLiteOpenHelper {

    public RepositorioPet(@Nullable Context context) {
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

    public List<Pet> listarPet(){
        ArrayList<Pet> lista = new ArrayList<>();
        String sql = "select * from PET";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0);
            pet.nome = cursor.getString(1);
            pet.idade = cursor.getInt(2);
            lista.add(pet);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    public Pet buscarPetPeloId(int id){
        Pet pet = null;
        String sql = "select * from PET where id = " + id;
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            pet = new Pet();
            pet.id = cursor.getInt(0);
            pet.nome = cursor.getString(1);
            pet.idade = cursor.getInt(2);
        }
        cursor.close();
        return pet;
    }

    public List<Pet> buscarPeloNome(String nome){
        ArrayList<Pet> lista = new ArrayList<>();
        String sql = "select * from PET where nome = '" + nome +"'";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Pet pet = new Pet();
            pet.id = cursor.getInt(0);
            pet.nome = cursor.getString(1);
            pet.idade = cursor.getInt(2);
            lista.add(pet);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    public void removerPetPeloNome(String nomePet){
        String sql = "delete from PET where nome = '" + nomePet +"'";
        getWritableDatabase().execSQL(sql);
    }

}
