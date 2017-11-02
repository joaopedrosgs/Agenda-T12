package com.example.pedro.agenda.contato;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pedro.agenda.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroDeContatoActivity extends AppCompatActivity implements CadastroContatoView {
    CadastroContatoPresenter cadastroContatoPresenter;
    @BindView(R.id.text_edit_email)
    TextInputEditText text_endereco;
    @BindView(R.id.foto_contato)
    com.makeramen.roundedimageview.RoundedImageView foto_contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton add_contato_action = (FloatingActionButton) findViewById(R.id.add_contato);
        add_contato_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton add_local_action = (FloatingActionButton) findViewById(R.id.add_contato);
        add_local_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ButterKnife.bind(this);
        cadastroContatoPresenter = new CadastroContatoPresenter(this);
    }
    @OnClick(R.id.add_location)
    void abrirMapas() {
        cadastroContatoPresenter.abrirMapa(text_endereco.getText().toString());
    }

    @OnClick(R.id.foto_contato)
    void abrirCamera() {
        cadastroContatoPresenter.abrirCamera();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap foto = cadastroContatoPresenter.retornoCamera(requestCode, resultCode, data);
        foto_contato.setImageBitmap(foto);

    }

    @Override
    public void MostrarToast(String s) {
        Toast toast = Toast.makeText(this, "Não foi possivel abrir o aplicativo de Mapas", Toast.LENGTH_LONG);
        toast.show();
    }
}
