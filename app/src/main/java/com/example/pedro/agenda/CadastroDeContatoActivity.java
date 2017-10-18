package com.example.pedro.agenda;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroDeContatoActivity extends AppCompatActivity {

    @BindView(R.id.text_edit_email)
    TextInputEditText text_endereco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_contato);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.button_add_local)
    void abrirMapas(){

        String endereco = text_endereco.getText().toString();
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q="+endereco));
        if(intentMapa.resolveActivity(getPackageManager())!=null) {
            startActivity(intentMapa);
        } else {
            Toast toast = Toast.makeText(CadastroDeContatoActivity.this, "Não foi possivel abrir o aplicativo de Mapas", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    @OnClick(R.id.button_add_foto)
    void abrirCamera(){

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentCamera.resolveActivity(getPackageManager())!=null) {
            startActivity(intentCamera);
        } else {
            Toast toast = Toast.makeText(CadastroDeContatoActivity.this, "Não foi possivel abrir o aplicativo de Camera", Toast.LENGTH_LONG);
            toast.show();
        }

    }

}
