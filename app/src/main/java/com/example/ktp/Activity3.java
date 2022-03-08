package com.example.ktp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private String partie = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        //ouverture de la BDD
        final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();

        partie = db.getpartie("jambes");

        TextView databasetest = (TextView) findViewById(R.id.databasetest);
        databasetest.setText(partie);


        db.close();
    }
}