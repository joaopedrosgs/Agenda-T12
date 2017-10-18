package com.example.pedro.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class lista_de_contatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_contatos);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.botao_novo_contato)
    void botao_novo_contato_click(){
        Intent abrirNovoContato = new Intent(lista_de_contatos.this, cadastro_de_contato.class);
        startActivity(abrirNovoContato);
    }
}