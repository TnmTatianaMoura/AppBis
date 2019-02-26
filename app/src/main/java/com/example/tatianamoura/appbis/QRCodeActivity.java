package com.example.tatianamoura.appbis;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tatianamoura.appteste.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCodeActivity extends AppCompatActivity {

    //Atributos declarados
    private Button scan_btn;

    private ImageButton btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

       scan_btn = (Button) findViewById(R.id.scanbtnid);
       final Activity activity = this;

       btnadd = (ImageButton) findViewById(R.id.btnAdd);

       //Criando eventos de botoes
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QRCodeActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });


        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrador = new IntentIntegrator(activity);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrador.setPrompt("Scan");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(false);
                integrador.setBarcodeImageEnabled(false);
                integrador.initiateScan();

                }
        });
    }

    //sobrescrevendo metodos
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //create condição
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Você cancelou a varredura", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
            }

        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
