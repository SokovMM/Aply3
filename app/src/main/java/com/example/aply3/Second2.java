package com.example.aply3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Second2 extends AppCompatActivity {

    public class PostAsyncTask extends AsyncTask<String,Void,String>{



        @Override
        protected String doInBackground(String... strings) {




            return null;
        }
        @Override
        protected void onPostExecute(String s){


        }

    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String _cur_select2 = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        ListView listViewSec2 = findViewById(R.id.List2);

        ListView listtest = findViewById(R.id.ListTest);






        final String[] SpisokList2 = new String[]{"Михаил Соковых", "Тажибавев Асад", "Кайфварик Иванов", "Касимов Александр"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SpisokList2);
        listViewSec2.setAdapter(adapter2);

        Intent intent3 = new Intent(Second2.this, Tretei3.class);


        TextView textView12 = findViewById(R.id.textView22);


        Bundle arg = getIntent().getExtras();
        String name = arg.get("1").toString();
        textView12.setText(name);



        ArrayList<String> listtestSpis = new ArrayList<>();
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listtestSpis);
        listtest.setAdapter(adapter3);
        listtestSpis.add(name);



        listViewSec2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {




                String selectedItem2 = SpisokList2[position];
                listtestSpis.add(selectedItem2);
                intent3.putExtra("2", listtestSpis.toString());


                startActivity(intent3);


            }
        });








    }

    public void CLickBAkc(View view) {
        Intent intent2 = new Intent(Second2.this, MainActivity.class);
        startActivity(intent2);
    }
}