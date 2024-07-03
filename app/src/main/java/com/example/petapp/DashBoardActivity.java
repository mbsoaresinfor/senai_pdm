package com.example.petapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {

    List<Pet> listaPet = new ArrayList<Pet>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        setTitle(R.string.dashboard);
    }

    public void abreCadastroPet(View view) {
        // abrindo a tela de cadastro de pet.
        Intent intent = new Intent(this,CadastroPetActivity.class);

        // cria o bundle para passar as variaveis para CadastroPetActivity
        Bundle bundle = new Bundle();
        bundle.putString("nome","marcelo");
        bundle.putInt("idade",41);
        bundle.putSerializable("lista", (Serializable) listaPet);

        intent.putExtras(bundle);
        startActivityForResult(intent,Constantes.REQ_CADASTRO_ACTIVITY);

    }


    public void abrirRemover(View view) {

        // abrindo a tela de removeção de pet.
        Intent intent = new Intent(this,RemoverPetActivity.class);

        // cria o bundle para passar as variaveis para RemoverPetActivity
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) listaPet);
        intent.putExtras(bundle);

        startActivityForResult(intent,Constantes.REQ_REMOVER_ACTIVITY);

    }

    public void listagemPet(View view) {

        // abrindo a tela de Listagem de pet
        Intent intent = new Intent(this,ListagemPetActivity.class);

        // cria o bundle para passar as variaveis para ListagemPetActivity
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) listaPet);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constantes.REQ_CADASTRO_ACTIVITY &&
                    resultCode == Constantes.RET_CADASTRO_ACTIVITY_LISTA_PET){
            listaPet = (List<Pet>) data.getSerializableExtra("lista");
        }

        if(requestCode == Constantes.REQ_REMOVER_ACTIVITY &&
                resultCode == Constantes.RET_REMOVER_ACTIVITY_LISTA_PET){
            listaPet = (List<Pet>) data.getSerializableExtra("lista");
        }
    }

    public void abrirCalculadora(View view) {
        Intent intent = new Intent(this,RetornoAulaActivity.class);
        startActivity(intent);
    }

    public void atualizar(View view) {
        Intent intent = new Intent(this,AtualizarActivity.class);
        startActivity(intent);
    }

    public void abrirCadastroUsuario(View view) {
        Intent intent = new Intent(this,CadastroUsuarioActivity.class);
        startActivity(intent);
    }
}