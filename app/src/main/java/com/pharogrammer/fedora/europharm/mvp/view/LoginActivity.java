package com.pharogrammer.fedora.europharm.mvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.LoginMVP;
import com.pharogrammer.fedora.europharm.root.App;
import com.pharogrammer.fedora.europharm.utils.Consts;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    @Inject
    LoginMVP.Presenter presenter;

    @BindView(R.id.btn_login)
    Button loginButton;

    @BindView(R.id.et_username)
    EditText usernameEditText;

    @BindView(R.id.et_password)
    EditText passwordEditText;

    EuroClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        ((App)getApplication()).getComponent().inject(this);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                client = new EuroClient();
                client.setUsername(usernameEditText.getText().toString().trim());
                client.setPassword(passwordEditText.getText().toString().trim());
                presenter.checkClientData(client);
            }
        });

    }


    @Override
    public void test(String test) {

        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login(EuroClient client) {



    }

    @Override
    public void showFailureMessage() {

        Toast.makeText(this, "Failed to login check you connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayMainActivity(EuroClient client) {
        Intent intent = new Intent(this , MainActivity.class);
        intent.putExtra(Consts.INTENT_CLIENT_KEY,client);
        startActivity(intent);
    }

    @Override
    public void showWrongInputMessage() {
        Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishLoginActivity() {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unSubscribe();
    }
}
