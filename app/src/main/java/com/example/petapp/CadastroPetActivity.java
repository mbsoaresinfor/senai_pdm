package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroPetActivity extends AppCompatActivity {

    List<Pet> listaPet = new ArrayList<Pet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle("Cadastro Pet");

    }

    public void cadastrar(View view) {
        // buscando os campos da tela.
        EditText nome = findViewById(R.id.editTextTextNomeDog);
        EditText idade = findViewById(R.id.editTextTextIdadeDog);
        String nomeTexto = nome.getText().toString();
        String idadeTexto = idade.getText().toString();

        if(nomeTexto.isEmpty() || idadeTexto.isEmpty()){
            Toast.makeText(this,"Todos os campos devem ser preenchidos",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this,"Sucesso no cadastro",Toast.LENGTH_LONG).show();

        // criando a classe pet
        Pet pet = new Pet();
        pet.nome = nomeTexto; // atribuindo os valores no objeto
        pet.idade = Integer.valueOf(idadeTexto);
        listaPet.add(pet); // salvando na lista o pet.

        // escrevendo na console os valores salvo na lista
        for(Pet p : listaPet){
            Log.i("pet", "-----------------------" );
            Log.i("pet", "nome: " + p.nome);
            Log.i("pet", "idade: " + p.idade);
            Log.i("pet", "-----------------------" );
        }

        // limpeza dos campos da tela.
        nome.setText("");
        idade.setText("");
    }
}