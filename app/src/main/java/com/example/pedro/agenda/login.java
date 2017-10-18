package com.example.pedro.agenda;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class login extends AppCompatActivity {

    @BindView(R.id.layout_login) TextInputLayout LayoutLogin;
    @BindView(R.id.layout_password) TextInputLayout LayoutPassword;
    @BindView(R.id.text_edit_login) TextInputEditText TextEditLogin;
    @BindView(R.id.text_edit_password) TextInputEditText TextEditPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }
    @OnTextChanged(R.id.text_edit_login)
    public void validaLogin () {
        LayoutLogin.setErrorEnabled(false);
        LayoutLogin.setError("");
    }
    @OnTextChanged(R.id.text_edit_password)
    public void validaSenha () {
        LayoutLogin.setErrorEnabled(false);
        LayoutLogin.setError("");
    }
    @OnClick(R.id.botao_login)
    public void login() {
        if(TextUtils.isEmpty(TextEditLogin.getText().toString())) {
            LayoutLogin.setErrorEnabled(true);
            LayoutLogin.setError("Login incorreto!");
            return;
        }
        if(TextUtils.isEmpty(TextEditPassword.getText().toString())) {
            LayoutPassword.setErrorEnabled(true);
            LayoutPassword.setError("Senha incorreta!");
            return;
        }
        Intent abrirListaDeContatos = new Intent(login.this, cadastro_de_contato.class);
        startActivity(abrirListaDeContatos);
    }
}
