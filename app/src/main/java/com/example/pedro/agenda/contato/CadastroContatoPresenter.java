package com.example.pedro.agenda.contato;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

/**
 * Created by pedro on 18/10/17.
 */

public class CadastroContatoPresenter {
    CadastroContatoView cadastroContatoView;

    public CadastroContatoPresenter(CadastroContatoView _cadastroDeContatoActivity) {
        cadastroContatoView = _cadastroDeContatoActivity;
    }

    void abrirMapa(String endereco) {

        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
        if (intentMapa.resolveActivity(cadastroContatoView.getPackageManager()) != null) {
            cadastroContatoView.startActivity(intentMapa);
        } else {
            cadastroContatoView.MostrarToast("Impossivel abrir o mapa");
        }
    }

    void abrirCamera() {

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intentCamera.resolveActivity(cadastroContatoView.getPackageManager()) != null) {
            cadastroContatoView.startActivityForResult(intentCamera, cadastroContatoView.REQUEST_IMAGE_CAPTURE);

        } else {
            cadastroContatoView.MostrarToast("Impossivel abrir a camera");
        }

    }
    Bitmap retornoCamera(int requestCode, int resultCode, Intent data){
        if (requestCode == cadastroContatoView.REQUEST_IMAGE_CAPTURE && resultCode == cadastroContatoView.RESULT_OK) {
            Bundle extras = data.getExtras();
            return (Bitmap) extras.get("data");
        }
        return null;
    }
}
