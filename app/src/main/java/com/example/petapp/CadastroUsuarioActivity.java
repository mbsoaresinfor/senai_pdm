package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class CadastroUsuarioActivity extends AppCompatActivity {

    RepositorioUsuario repositorioUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repositorioUsuario = new RepositorioUsuario(this);
        atualizarListaUsuario();

    }

    private void atualizarListaUsuario(){
        List<Usuario> listaUsuario = repositorioUsuario.listarUsuario();
        ListView listView = findViewById(R.id.listViewUsuario);
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this,
                android.R.layout.simple_list_item_1, listaUsuario);
        listView.setAdapter(adapter);
    }

    public void salvar(View view) {

        EditText nome = findViewById(R.id.editTextTextNomeUsuario);
        EditText senha = findViewById(R.id.editTextTextSenhaUsuario);

        if(nome.getText().toString().isEmpty() || senha.getText().toString().isEmpty()){
            Toast.makeText(this,"Todos os campos devem ser preenchidos",
                    Toast.LENGTH_LONG).show();
            return;
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome.getText().toString());
        usuario.setSenha(senha.getText().toString());

        repositorioUsuario.inserirUsuario(usuario);
        Toast.makeText(this,"sucesso no cadastro do usuário",
                Toast.LENGTH_LONG).show();

        nome.setText("");
        senha.setText("");

        atualizarListaUsuario();

    }
}