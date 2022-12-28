package com.example.kartik_roy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonParsing extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing);

        listView = findViewById(R.id.listView);
        ParseJSON();

    }
     private void ParseJSON() {
        try {
            JSONArray jsonArray = new JSONArray(Utils.getFileData(this, "data/sad_sms.json"));

            for (int i = 0; i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String worlds = jsonObject.getString("worlds");
                String url = jsonObject.getString("url");
                String phone = jsonObject.getString("phone");


                arrayList.add(worlds + ")" +url + "||" + phone);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

         arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
         listView.setAdapter(arrayAdapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 Intent intent = new Intent(JsonParsing.this, DetailActivity.class);
                 //Toast.makeText(JsonParsing.this, "" + arrayList.get(position), Toast.LENGTH_SHORT).show();
                 intent.putExtra("names", arrayAdapter.getItem(position));
                 startActivity(intent);
             }
         });
    }
}