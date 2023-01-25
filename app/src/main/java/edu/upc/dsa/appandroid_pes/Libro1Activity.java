package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Libro1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro1);
    }

    public void AtrasBtn(View view){
        Intent b1= new Intent (Libro1Activity.this, TiendaActivity.class);
        startActivity(b1);
    }
}