package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ListagemPetActivity extends AppCompatActivity {

    List<Pet> listaPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle(R.string.listagem_pet);
        listaPet = (List<Pet>) getIntent().getSerializableExtra("lista");
        for(Pet p : listaPet){
            Log.i("pet", "-----------------------" );
            Log.i("pet", "nome: " + p.nome);
            Log.i("pet", "idade: " + p.idade);
            Log.i("pet", "-----------------------" );
        }
    }
}