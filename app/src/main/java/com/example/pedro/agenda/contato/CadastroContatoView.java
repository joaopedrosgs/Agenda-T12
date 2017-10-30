package com.example.pedro.agenda.contato;

import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * Created by pedro on 18/10/17.
 */

public interface CadastroContatoView {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int RESULT_OK = -1;


    void startActivity(Intent intentMapa);

    PackageManager getPackageManager();

    void startActivityForResult(Intent intentCamera, int requestImageCapture);

    void MostrarToast(String s);
}
