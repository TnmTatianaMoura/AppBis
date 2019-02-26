package com.example.tatianamoura.appbis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tatianamoura.appteste.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogar = (Button)findViewById(R.id.loginBtnLogin);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(LoginActivity.this, QRCodeActivity.class);
                startActivity(it);
            }
        });
    }
}
