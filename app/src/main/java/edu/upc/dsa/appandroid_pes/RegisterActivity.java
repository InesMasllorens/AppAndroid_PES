package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //es el boton qye hay en la activity de register. El boton de registrarse
    public void SendDataRegister(View view){

    }


    public void AtrasBtn(View view){
        Intent main= new Intent (RegisterActivity.this, MainActivity.class);
        startActivity(main);
    }
}