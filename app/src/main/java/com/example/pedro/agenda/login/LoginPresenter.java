package com.example.pedro.agenda.login;

import android.text.TextUtils;

/**
 * Created by pedro on 18/10/17.
 */

public class LoginPresenter {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            loginView.SetErroUsuario();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            loginView.SetErroSenha();
            return;
        }
        loginView.LoginSucesso();
    }
}
