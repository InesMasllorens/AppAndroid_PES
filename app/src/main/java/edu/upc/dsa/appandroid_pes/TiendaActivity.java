package edu.upc.dsa.appandroid_pes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TiendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
    }

    public void AtrasBtn(View view){
        Intent main= new Intent (TiendaActivity.this, MainActivity.class);
        startActivity(main);
    }

    public void Libro1Btn(View view){
        Intent libro1= new Intent (TiendaActivity.this, Libro1Activity.class);
        startActivity(libro1);
    }

    public void Libro2Btn(View view){
        Intent libro2= new Intent (TiendaActivity.this, Libro2Activity.class);
        startActivity(libro2);
    }
}