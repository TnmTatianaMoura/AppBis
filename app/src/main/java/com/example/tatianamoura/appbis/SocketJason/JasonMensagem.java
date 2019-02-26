package com.example.tatianamoura.appbis.SocketJason;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class JasonMensagem {

    void criarSocket(){
        try{
            //Abrindo conexão e conectando com o servidor
            Socket  socket = new Socket("172.10.10.49",5000);


            if(socket.isConnected()){
                System.out.print("Conexão realizada com sucesso"+"\n");



                String requestjson = "{\"id\":0,\"jsonrpc\":\"2.0\",\"method\":\"miner_getstat1\"}";


                //Recebendo requisição do servidor
                ObjectInputStream objentrada = new ObjectInputStream(socket.getInputStream());


                try{
                    System.out.print(objentrada.readObject().toString());
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

                byte[] bt = new byte[10000];

                //socket.getReceiveBufferSize(bt);

                obterDados(requestjson);

                //Fechando fluxo de entrada
                objentrada.close();

                //Fecha o socket após a requisição
                socket.close();



            }else {

                System.out.print("Conexão não realizada");
            }
            //Checa pra ver se fechou o socket após a requisição
            if(socket.isClosed()){
                System.out.print("Conexão fechada");

            }else {
                System.out.println("Conexão ainda aberta");
            }

        }catch (UnknownHostException UnknowHost){

            System.out.print("Endereço vázio ou incorreto: "+UnknowHost.getMessage());
        }catch (IllegalArgumentException PortIncorrect){
            System.out.println("Porta fora do intervalo 0 - 65535: "+PortIncorrect.getMessage());

        }
        catch (IOException ErrorCreateSocket){
            System.out.println("Problema ao criar um socket com o servidor: "+ErrorCreateSocket.getMessage());

        }
    }

    private void obterDados(String requestjason){

        //Instancia da class BSCommandJson
        BSCommandJson cmdjson = new BSCommandJson();




       // Minerador minerador = cmdjson.fromJson(requestjson,Minerador.class);
        //System.out.println("id: "+minerador.id);
       // System.out.print("json-rpc: "+minerador.jsonrpc+"\n");
       // System.out.print("method: "+minerador.method+"\n");
    }
}
