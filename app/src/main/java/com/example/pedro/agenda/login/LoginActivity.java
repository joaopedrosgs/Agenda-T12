package com.example.pedro.agenda.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pedro.agenda.contato.CadastroDeContatoActivity;
import com.example.pedro.agenda.R;
import com.example.pedro.agenda.contato.ListaDeContatosActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.layout_login)
    TextInputLayout LayoutLogin;
    @BindView(R.id.layout_password)
    TextInputLayout LayoutPassword;
    @BindView(R.id.text_edit_login)
    TextInputEditText TextEditLogin;
    @BindView(R.id.text_edit_password)
    TextInputEditText TextEditPassword;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(LoginActivity.this);


    }

    @OnTextChanged(R.id.text_edit_login)
    public void validaLogin() {
        LayoutLogin.setErrorEnabled(false);
        LayoutLogin.setError("");
    }

    @OnTextChanged(R.id.text_edit_password)
    public void validaSenha() {
        LayoutLogin.setErrorEnabled(false);
        LayoutLogin.setError("");
    }

    @OnClick(R.id.botao_login)
    public void FazLogin() {
        loginPresenter.login(TextEditLogin.getText().toString(), TextEditPassword.getText().toString());
    }

    @Override
    public void SetErroUsuario() {
        LayoutLogin.setErrorEnabled(true);
        LayoutLogin.setError("LoginActivity incorreto!");
    }

    @Override
    public void SetErroSenha() {
        LayoutPassword.setErrorEnabled(true);
        LayoutPassword.setError("Senha incorreta!");
    }

    @Override
    public void LoginSucesso() {
        Intent abrirListaDeContatos = new Intent(LoginActivity.this, ListaDeContatosActivity.class);
        startActivity(abrirListaDeContatos);
    }
}
