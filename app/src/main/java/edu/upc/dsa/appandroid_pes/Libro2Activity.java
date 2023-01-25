package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Libro2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro2);
    }

    public void AtrasBtn(View view){
        Intent b2= new Intent (Libro2Activity.this, TiendaActivity.class);
        startActivity(b2);
    }
}