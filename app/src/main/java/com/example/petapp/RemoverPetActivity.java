package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemoverPetActivity extends AppCompatActivity {

    List<Pet> listaPet ;
    RepositorioPet repositorioPet;
    RepositorioLog repositorioLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_pet);
        setTitle(R.string.remover_pet);
        listaPet = (List<Pet>) getIntent().getSerializableExtra("lista");
        repositorioPet = new RepositorioPet(this);
        repositorioLog = new RepositorioLog(this);
    }

    public void remover(View view) {

        EditText nome = findViewById(R.id.editTextNome);
        String nomeString = nome.getText().toString();
        if(nomeString.equals("")){
            Toast.makeText(this,"Digite um nome para remover",
                    Toast.LENGTH_LONG).show();
            return;
        }

        // remove os elementos da lista
//        if(!listaPet.removeIf(obj -> obj.nome.equals(nomeString))){
//            Toast.makeText(this,"Não foi encontrado o pet com este nome",
//                    Toast.LENGTH_LONG).show();
//            return;
//        }
        repositorioPet.removerPetPeloNome(nomeString);
        // inserido log da operacao de adicionarPet no banco de dados.
        com.example.petapp.Log meuLog = new com.example.petapp.Log();
        meuLog.operacao = "REMOVIDO PET";
        meuLog.dataOperacao = new Date().toString();
        repositorioLog.inserirLog(meuLog);

        // retornando os dados para a activity pai
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",(Serializable) listaPet);
        intent.putExtras(bundle);
        setResult(Constantes.RET_REMOVER_ACTIVITY_LISTA_PET, intent);
        finish();
    }
}