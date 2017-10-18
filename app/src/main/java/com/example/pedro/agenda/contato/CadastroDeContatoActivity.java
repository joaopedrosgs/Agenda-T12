package com.example.pedro.agenda.contato;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pedro.agenda.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroDeContatoActivity extends AppCompatActivity {
    CadastroContatoPresenter cadastroContatoPresenter;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @BindView(R.id.text_edit_email)
    TextInputEditText text_endereco;
    @BindView(R.id.foto_contato)
    ImageView foto_contato;

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cadastroContatoPresenter.retornoCamera(requestCode, resultCode, data);
    }
}
