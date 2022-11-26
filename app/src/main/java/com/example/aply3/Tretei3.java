package com.example.aply3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tretei3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tretei3);
        TextView textView4 = findViewById(R.id.textView4);

        Bundle arg2 = getIntent().getExtras();
        String name = arg2.get("2").toString();

        textView4.setText(name);




    }


    public void backTovist(View view) {
        Intent intentBacktoVist = new Intent(Tretei3.this,MainActivity.class);
        startActivity(intentBacktoVist);
    }
}