package io.github.rianjara.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button login_btn_login;
    TextView login_lbl_forgot_password, login_lbl_new_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn_login = (Button)findViewById(R.id.login_btn_login);
        login_lbl_forgot_password = (TextView)findViewById(R.id.login_lbl_forgot_password);
        login_lbl_new_account = (TextView)findViewById(R.id.login_lbl_new_account);

        login_btn_login.setOnClickListener(this);
        login_lbl_forgot_password.setOnClickListener(this);
        login_lbl_new_account.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;
        Class name = null;

        switch (view.getId()){
            case R.id.login_btn_login:
                name = Main.class;
                break;

            case R.id.login_lbl_forgot_password:
                name = ResetPassword.class;
                break;

            case R.id.login_lbl_new_account:
                name = Registro.class;
                break;
        }
        i = new Intent(this, name);
        startActivity(i);
    }
}
