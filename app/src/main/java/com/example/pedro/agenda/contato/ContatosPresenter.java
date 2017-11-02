package com.example.pedro.agenda.contato;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 01/11/17.
 */

public class ContatosPresenter {

    private ContatosView contatosView;
    private List<String> listaDeContatos = new ArrayList<>();

    ContatosPresenter(ContatosView _contatosView){
        this.contatosView = _contatosView;
    }

    void addContato(int requestCode, int resultCode, Intent data){
        if(requestCode == 123 && resultCode == Activity.RESULT_OK){
            String nomeContato = data.getStringExtra("movie_name");
            listaDeContatos.add(nomeContato);
            contatosView.updateList(listaDeContatos);
        }
    }
}
