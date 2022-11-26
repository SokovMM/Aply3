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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> studentArray = new ArrayList<>();

    public class GetStudents extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {

            HttpURLConnection urlConnection = null;
            String response = "";
            try {
                URL url = new URL("http://192.168.1.62:8081/students");
                //URL url = new URL("http://192.168.1.62:8080");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    // InputStream stream = urlConnection.getInputStream();

                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        response += line;
                    }
                    //         System.out.println(response);
                }


            }
            //catch (IOException e) {
            catch (Exception e) {
                System.out.println(e.toString());

                throw new RuntimeException(e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return response;
        }

        @Override
        protected void onPostExecute(Object res) {
            super.onPostExecute(res);
            String Name = null;
            String resp = (String) res;
            resp = "{\"respone\":"+ resp + "}";
            Integer id = null;
            ArrayList arrayList = null;
            System.out.println(resp);
            try {
                studentArray.clear();
                JSONObject jsonObject = new JSONObject(resp);
                JSONArray jsonArray = jsonObject.getJSONArray("respone");
                for(int i=0; i<jsonArray.length();i++)
                {
                    JSONObject userInfo = jsonArray.getJSONObject(i);
                    id = userInfo.getInt("id");
                    Name = userInfo.getString("name");
                    System.out.println("IDD ID!!!!!!!!!!"+ id);
                    System.out.println("NAME NAME !!!!!!!!!!"+ Name);
                    Student s = new Student();
                    s.setName(userInfo.getString("name"));
                    s.setId(userInfo.getInt("id"));
                    studentArray.add(s);
                    System.out.println(s.toString());

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            createSpisok();
           // String resultStr = " Имя: " +Name + "\n" + "id:" + id;
           // getTextView.setText(resultStr);

            //_students = (String) res;
            //_students.toString();
            //System.out.println(_students);

            //нахожу на моем экране TextView

            //Устанавливаю на мой TextView
        }
    }

    String _cur_select = "";
    String _students = "";

    void createSpisok()
    {
        setContentView(R.layout.activity_main);
        TextView textView2 = findViewById(R.id.textView22);
        ListView listView = findViewById(R.id.list1);
        String[] catNames = new String[studentArray.size()];


        for (int i=0; i<studentArray.size(); i++)
        {
            Student s = new Student();
            s = studentArray.get(i);
            catNames[i] = s.getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, catNames);
        listView.setAdapter(adapter);
        Intent intent = new Intent(MainActivity.this, Second2.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                String selectedItem = catNames[position];
                _cur_select = selectedItem;
                intent.putExtra("1", _cur_select.toString());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("START!!!");

        new GetStudents().execute();





        }
    }
