package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListagemPetActivity extends AppCompatActivity {

    List<Pet> listaPet;
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle(R.string.listagem_pet);
        repositorioPet = new RepositorioPet(this);

        //listaPet = (List<Pet>) getIntent().getSerializableExtra("lista");

        // pegando os dados do banco
        listaPet = repositorioPet.listarPet();

        // pega o listview da tela
        ListView listView = findViewById(R.id.listview);

        ArrayAdapter<Pet> adapter = new ArrayAdapter<Pet>(this,
                android.R.layout.simple_list_item_1, listaPet );

        listView.setAdapter(adapter);

        for(Pet p : listaPet){
            Log.i("pet", "-----------------------" );
            Log.i("pet", p.toString());
            Log.i("pet", "-----------------------" );
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}