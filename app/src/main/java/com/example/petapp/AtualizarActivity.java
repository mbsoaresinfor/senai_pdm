package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AtualizarActivity extends AppCompatActivity {

    RepositorioPet repositorioPet;
    RepositorioLog repositorioLog;
    Pet pet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atualizar);
        repositorioPet = new RepositorioPet(this);
        repositorioLog = new RepositorioLog(this);
    }

    public void atualizar(View view) {
        if(pet == null){
            Toast.makeText(this,"favor buscar um pet " ,Toast.LENGTH_LONG).show();
            return;
        }
        EditText nome = findViewById(R.id.editTextNomePet);
        EditText idade = findViewById(R.id.editTextIdadePet);
        if(nome.getText().toString().equals("")){
            Toast.makeText(this,"favor digitar o campo nome do pet " ,Toast.LENGTH_LONG).show();
            return;
        }
        if(idade.getText().toString().equals("")){
            Toast.makeText(this,"favor digitar o campo idade do pet " ,Toast.LENGTH_LONG).show();
            return;
        }
        pet.nome = nome.getText().toString();
        pet.idade = Integer.parseInt(idade.getText().toString());
        repositorioPet.atualizarPet(pet);
        Toast.makeText(this,"atualização realizada com sucesso" ,Toast.LENGTH_LONG).show();

        // inserido log da operacao de adicionarPet no banco de dados.
        com.example.petapp.Log meuLog = new com.example.petapp.Log();
        meuLog.operacao = "ATUALIZAÇÃO PET";
        meuLog.dataOperacao = new Date().toString();
        repositorioLog.inserirLog(meuLog);

        // LIMPANDO A TELA
        nome.setText("");
        idade.setText("");
        pet =null;

    }

    public void buscar(View view) {
        EditText id = findViewById(R.id.editTextIdPet);
        if(id.getText().toString().equals("")){
            Toast.makeText(this,"favor digitar um id",Toast.LENGTH_LONG).show();
            return;
        }

        pet = repositorioPet.buscarPetPeloId(Integer.parseInt(id.getText().toString()));
        if(pet == null){
            Toast.makeText(this,"Nao localizado pet pelo ID " + id.getText().toString(),Toast.LENGTH_LONG).show();
            return;
        }

        EditText nome = findViewById(R.id.editTextNomePet);
        EditText idade = findViewById(R.id.editTextIdadePet);
        // colocando os dados do objeto pet na tela
        nome.setText(pet.nome);
        idade.setText(pet.idade);
    }
}