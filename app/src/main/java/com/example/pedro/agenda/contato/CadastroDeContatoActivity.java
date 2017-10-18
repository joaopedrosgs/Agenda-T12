package com.example.pedro.agenda.contato;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pedro.agenda.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroDeContatoActivity extends AppCompatActivity {
    CadastroContatoPresenter cadastroContatoPresenter;
    @BindView(R.id.text_edit_email)
    TextInputEditText text_endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_contato);
        ButterKnife.bind(this);
        cadastroContatoPresenter = new CadastroContatoPresenter(CadastroDeContatoActivity.this);
    }

    @OnClick(R.id.button_add_local)
    void abrirMapas() {
        cadastroContatoPresenter.abrirMapa(text_endereco.getText().toString());
    }

    @OnClick(R.id.button_add_foto)
    void abrirCamera() {
        cadastroContatoPresenter.abrirCamera();
    }
}
