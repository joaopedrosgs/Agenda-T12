package com.example.pedro.agenda.contato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.pedro.agenda.PessoaAdapter;
import com.example.pedro.agenda.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContatosActivity extends AppCompatActivity implements ContatosView {

    @BindView(R.id.pessoas_recycler)
    RecyclerView pessoas_r;

    ContatosPresenter contatosPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_contatos);
        ButterKnife.bind(this);
        contatosPresenter = new ContatosPresenter(this);
    }

    @OnClick(R.id.botao_novo_contato)
    void AddContato() {
        Intent abrirNovoContato = new Intent(ContatosActivity.this, CadastroDeContatoActivity.class);
        startActivity(abrirNovoContato);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        contatosPresenter.addContato(requestCode, resultCode, data);
    }

    @Override
    public void updateList(List<String> PessoaList){
        PessoaAdapter pessoaAdapter = new PessoaAdapter(PessoaList);
        pessoas_r.setAdapter(pessoaAdapter);


    }
}
