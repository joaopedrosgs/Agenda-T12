package com.example.pedro.agenda.contato;

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
    CadastroDeContatoActivity cadastroDeContatoActivity;

    public CadastroContatoPresenter(CadastroDeContatoActivity _cadastroDeContatoActivity) {
        cadastroDeContatoActivity = _cadastroDeContatoActivity;
    }

    void abrirMapa(String endereco) {

        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
        if (intentMapa.resolveActivity(cadastroDeContatoActivity.getPackageManager()) != null) {
            cadastroDeContatoActivity.startActivity(intentMapa);
        } else {
            Toast toast = Toast.makeText(cadastroDeContatoActivity, "Não foi possivel abrir o aplicativo de Mapas", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    void abrirCamera() {

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intentCamera.resolveActivity(cadastroDeContatoActivity.getPackageManager()) != null) {
            cadastroDeContatoActivity.startActivityForResult(intentCamera, cadastroDeContatoActivity.REQUEST_IMAGE_CAPTURE);

        } else {
            Toast toast = Toast.makeText(cadastroDeContatoActivity, "Não foi possivel abrir o aplicativo de Camera", Toast.LENGTH_LONG);
            toast.show();
        }

    }
    Bitmap retornoCamera(int requestCode, int resultCode, Intent data){
        if (requestCode == cadastroDeContatoActivity.REQUEST_IMAGE_CAPTURE && resultCode == cadastroDeContatoActivity.RESULT_OK) {
            Bundle extras = data.getExtras();
            return (Bitmap) extras.get("data");
        }
        return null;
    }
}
