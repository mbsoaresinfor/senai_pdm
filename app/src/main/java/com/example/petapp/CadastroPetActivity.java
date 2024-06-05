package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastroPetActivity extends AppCompatActivity {

    List<Pet> listaPet;
    BancoDadosPet bancoDadosPet;
    BancoDadosLog bancoDadosLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle(R.string.cadastrar_pet);
        bancoDadosPet = new BancoDadosPet(this);
        bancoDadosLog = new BancoDadosLog(this);

        // pego a variavel que foi passada via bundle
        try {
            String nome = (String) getIntent().getSerializableExtra("nome");
            int idade =(int)getIntent().getSerializableExtra("idade");
            listaPet = (List<Pet>) getIntent().getSerializableExtra("lista");
            Log.i("pet","foi passado o nome: " + nome);
            Log.i("pet","foi passado a idade: " + idade);
            Log.i("pet","conteudo da lista " + listaPet);

        }catch(Exception e){
            Log.e("pet","Ocorreu um erro ao buscar a variavel nome");
        }
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
       // listaPet.add(pet); // salvando na lista o pet.
        bancoDadosPet.adicionarPet(pet); // salvando no banco de dados.

        // inserido log da operacao de adicionarPet no banco de dados.
        com.example.petapp.Log meuLog = new com.example.petapp.Log();
        meuLog.operacao = "CADASTRADO PET";
        meuLog.dataOperacao = new Date().toString();
        bancoDadosLog.inserirLog(meuLog);

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

        // retornando os dados para a activity pai
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",(Serializable) listaPet);
        intent.putExtras(bundle);
        setResult(Constantes.RET_CADASTRO_ACTIVITY_LISTA_PET , intent);
        finish();

    }
}