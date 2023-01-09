package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogInActivity extends AppCompatActivity {

    EditText LogInEmail,LogInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogInEmail = (EditText)findViewById(R.id.LogInEmail);
        LogInPassword = (EditText)findViewById(R.id.LogInPassword);

    }


    //es el boton qye hay en la activity de login. El boton de logearse
    public void SendDataLogin(View view) {

        new Thread(new Runnable() {
            InputStream stream = null;
            String str = "";
            String result = null;
            public void run() {
                Log.i("Debug :" ,"Debug");

                try {
                    InputStream stream = null;

                    String query = "http://192.168.1.145:9000/Android/Login";
                    //String query = String.format("http://10.192.171.29:9000/Application/hello");
                    URL url = new URL(query);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 );
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.connect();

                    //send parameters in message body
                    String params = "Usuari=lola&pass=lolap";
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(params);
                    writer.flush();
                    writer.close();
                    os.close();

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

                    // n.setText("Resposta rebuda  thread" + sb);
                    TextView n = findViewById(R.id.textView);
                    n.post(new Runnable() {
                        public void run() {
                            n.setText("Resposta rebuda  thread" + sb);
                        }
                    });

                } catch (Exception e) {
                    TextView n = findViewById(R.id.textView);
                    n.post(new Runnable() {
                        public void run() {
                            n.setText("Resposta rebuda  thread" + e);
                        }
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /*
    public void sendData2 (View view)
    {
        String user = LogInEmail.getText().toString();
        String password = LogInPassword.getText().toString();
    }
    */
    public void AtrasBtn(View view){
        Intent main= new Intent (LogInActivity.this, MainActivity.class);
        startActivity(main);
    }
}