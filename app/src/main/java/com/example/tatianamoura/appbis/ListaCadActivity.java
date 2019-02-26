package com.example.tatianamoura.appbis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.tatianamoura.appteste.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ListaCadActivity extends AppCompatActivity{

    private static final String hostname = "localhost";
    private static final int portaServidor = 6789;
    Socket socket = null;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cad);

        button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }){

                @Override
                public void run(){

                    try{
                        socket = new Socket(hostname, portaServidor);


                        //dados enviados para o servidor
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        bw.write("Dados enviados para o servidor");
                        bw.newLine();
                        bw.flush();


                        //dados reebidos pelo servidor
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        System.out.println("Dados cadastrados " + br.readLine()); //retornar ok

                        socket.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }

            });.start();
        }
    });











    }
}