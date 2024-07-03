package com.example.petapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario extends SQLiteOpenHelper {
    public RepositorioUsuario(@Nullable Context context) {
        super(context, "usuario", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE USUARIO(id INTEGER NOT NULL PRIMARY KEY, nome TEXT, senha TEXT)";
        sqLiteDatabase.execSQL(sql);
        android.util.Log.i("pet","criado tabela no banco de dados USUARIO");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirUsuario(Usuario usuario){
        String sql = "INSERT INTO USUARIO(nome,senha) values('"+ usuario.getNome() + "','"+ usuario.getSenha() +"')";
        android.util.Log.i("pet","sql insert: " + sql);
        super.getWritableDatabase().execSQL(sql);
        android.util.Log.i("pet","executado sql insert");
    }

    public List<Usuario> listarUsuario(){
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "select * from USUARIO";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome( cursor.getString(1));
            usuario.setSenha(cursor.getString(2));
            lista.add(usuario);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }
}
