package com.example.kartik_roy;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class Utils {

    private static Activity context;

    public static String getFileData(Context context2, String str) {
        try {
            return convertStreamToString(context2.getAssets().open(str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String convertStreamToString(InputStream inputStream) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[2048];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,
                    "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    inputStream.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}
