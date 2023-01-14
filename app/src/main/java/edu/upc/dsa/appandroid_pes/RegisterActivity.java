package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    EditText RegisterEmail,RegisterPassword, RegisterName, RegisterDni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterEmail = (EditText)findViewById(R.id.RegisterEmail);
        RegisterPassword = (EditText)findViewById(R.id.RegisterPassword);
        RegisterName = (EditText)findViewById(R.id.RegisterName);
        RegisterDni = (EditText)findViewById(R.id.RegisterDni);


    }

    //es el boton qye hay en la activity de register. El boton de registrarse
    public void SendDataRegister(View view){

        String email = RegisterEmail.getText().toString();
        String password = RegisterPassword.getText().toString();
        String name = RegisterName.getText().toString();
        String dni = RegisterDni .getText().toString();




        new Thread(new Runnable() {
            InputStream stream = null;
            String str = "";
            String result = null;
            public void run() {
                Log.i("Debug :" ,"Debug");

                try {
                    InputStream stream = null;

                    String query = "http://192.168.11.105:9000/Application/RegisterAndroid";
                    //String query = "http://192.168.11.105:9000/Application/LoginAndroid?e="+ LogInEmail + "&p=" + LogInPassword;
                    //String query = String.format("http://10.192.171.29:9000/Application/hello");
                    URL url = new URL(query);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 );
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("POST");
                    //conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);//PEL GET NO CAL
                    conn.connect();

                    //send parameters in message body
                    String params = "e="+email + "&p=" + password + "&n=" + name + "&d=" + dni;
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(params);
                    writer.flush();
                    writer.close();
                    os.close(); //TOT AQUEST BLOC NO CAL PEL GET.

                    // n.setText("Esperant resposta  thread");
                    //receive response from server
                    stream = conn.getInputStream();
                    BufferedReader reader;
                    StringBuilder sb = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(stream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    TextView n = findViewById(R.id.textView2);
                    n.setText(sb); //el sb es lo k le devuelve del intellij
                    n.post(new Runnable() {
                    public void run() {
                    //String msg = "T'has registrat correctament";
                    //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    n.setText(sb);
                    }
                    });

                } catch (Exception e) {
                    TextView n = findViewById(R.id.textView2);
                    n.post(new Runnable() {
                    public void run() {
                    //String msg = "No te has registrado correctamente" + e;
                    //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    n.setText("Resposta rebuda  thread" + e);
                    }
                    });
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public void AtrasBtn(View view){
        Intent main= new Intent (RegisterActivity.this, MainActivity.class);
        startActivity(main);
    }
}