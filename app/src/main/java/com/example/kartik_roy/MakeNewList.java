package com.example.kartik_roy;

import java.util.ArrayList;
import java.util.HashMap;

public class MakeNewList {

    public static ArrayList< ArrayList<HashMap<String,String>> > rootArrayList;
    public static ArrayList< HashMap<String, String> > catArrayList;
    public static ArrayList< HashMap<String, String> > videoArrayList;
    public static HashMap<String, String> hashMap;


    //--------------------------------------------------------------------------------------------

    public static void createPlayListForVideo(String category_name, Integer drawable){
        rootArrayList.add(videoArrayList);
        hashMap = new HashMap<>();
        hashMap.put("category_name", category_name);
        hashMap.put("img", String.valueOf(drawable));
        catArrayList.add(hashMap);
        videoArrayList = new ArrayList<>();
    }

    public static void createMyAlbums(){

        rootArrayList = new ArrayList();
        catArrayList = new ArrayList<>();
        videoArrayList = new ArrayList<>();

        //=========================
        createPlayListForVideo("JsonParsing", R.drawable.eye);
        createPlayListForVideo("JsonParsing", R.drawable.deviation);
        createPlayListForVideo("JsonParsing", R.drawable.t);






    }




}
