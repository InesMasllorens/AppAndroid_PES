package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.upc.dsa.appandroid_pes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (android.os.Build.VERSION.SDK_INT > 9) //permis operacions bloquejants
//        {
//            StrictMode.ThreadPolicy gfgPolicy =
//                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(gfgPolicy);
//        }
//
//        Log.i("Debug :" ,"Debug");
//        TextView n = findViewById (R.id.debugText);
//        n.setText("Iniciem la connexió");
//
//        try {
//        InputStream stream = null;
//
//        n.setText("Iniciem la connexió- enviant petició");
//        String query = "http://192.168.1.145:9000/Android/Login";
//        //String query = String.format("http://10.192.171.29:9000/Application/hello");
//        URL url = new URL(query);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setReadTimeout(10000 );
//        conn.setConnectTimeout(15000 /* milliseconds */);
//        conn.setRequestMethod("POST");
//        conn.setDoInput(true);
//        conn.setDoOutput(true);
//        conn.connect();
//
//        //send parameters in message body
//        String params = "Usuari=lola&pass=lolap";
//        OutputStream os = conn.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(os, "UTF-8"));
//        writer.write(params);
//        writer.flush();
//        writer.close();
//        os.close();
//
//        n.setText("Esperant resposta  ");
//        //receive response from server
//        stream = conn.getInputStream();
//        BufferedReader reader;
//        StringBuilder sb = new StringBuilder();
//        reader = new BufferedReader(new InputStreamReader(stream));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//
//        n.setText("Resposta rebuda  " + sb);
//
//        } catch (Exception e) {
//
//            n.setText("Excepcio! " + e);
//            e.printStackTrace();
//        }

    }

    //es el boton que hay en el main
    public void loginBtn(View view){
        Intent loginMain= new Intent (MainActivity.this, LogInActivity.class);
        startActivity(loginMain);
    }

    //es el boton que hay en el main
    public void registerBtn(View view){
        Intent registerMain= new Intent (MainActivity.this, RegisterActivity.class);
        startActivity(registerMain);
    }

    public void tiendaBtn(View view){
        Intent tiendaMain= new Intent (MainActivity.this, TiendaActivity.class);
        startActivity(tiendaMain);
    }




}