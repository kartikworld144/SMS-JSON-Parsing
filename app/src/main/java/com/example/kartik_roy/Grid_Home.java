package com.example.kartik_roy;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Grid_Home extends AppCompatActivity {



    public static int CategoryClicked = -10;
    ExpandableHeightGridView mainGrid;
    Intent targetActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_home);
        mainGrid = findViewById(R.id.mainGrid);



        MakeNewList.createMyAlbums();

        MyAdapter adapter = new MyAdapter();
        mainGrid.setExpanded(true);
        mainGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public  MyAdapter(){
            this.inflater = (LayoutInflater)
                    Grid_Home.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return MakeNewList.catArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);


            ImageView imgIcon = convertView.findViewById(R.id.imgIcon);
            TextView tvTitle = convertView.findViewById(R.id.tvTitle);
            LinearLayout layItem = convertView.findViewById(R.id.layItem);

            HashMap<String, String> mHashMap = MakeNewList.catArrayList.get(position);
            String catName = mHashMap.get("category_name");
            String img = mHashMap.get("img");




            if (tvTitle!=null) tvTitle.setText(catName);
            if (imgIcon!=null && img!=null) {
                int drawable = Integer.parseInt(img);
                imgIcon.setImageResource( drawable );
            }


            if (layItem!=null){
                layItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //We are tracking the category position. So that we can call the intent after ad loads


                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        if (catName != null && catName.contains("JsonParsing")) {
                            targetActivity = new Intent(Grid_Home.this, JsonParsing.class);
                            startActivity(targetActivity);

                        }
                        //----------------------------------------------------------------


                        else if (catName != null && catName.contains("JsonParsing")) {
                            targetActivity = new Intent(Grid_Home.this, JsonParsing.class);
                            startActivity(targetActivity);

                        }
                        //----------------------------------------------------------------




                        else {
                            targetActivity = new Intent(Grid_Home.this, JsonParsing.class);
                            startActivity(targetActivity);

                        }

                    }
                });
            }



            return convertView;
        }
    }



}