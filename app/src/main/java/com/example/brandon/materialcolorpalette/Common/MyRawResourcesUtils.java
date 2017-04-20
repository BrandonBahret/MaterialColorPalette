package com.example.brandon.materialcolorpalette.Common;

import android.content.Context;
import android.support.annotation.RawRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Brandon on 4/19/2017.
 * Helper class to fetch resources
 */

public class MyRawResourcesUtils {


    public static String fetchResource(Context context, @RawRes int rawId) {
        InputStream inputStream = context.getResources().openRawResource(rawId);

        StringBuilder stringBuilder = new StringBuilder();
        String accumulatorString = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((accumulatorString = reader.readLine()) != null) {
                stringBuilder.append(accumulatorString);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Throwable ignore) {
            }
        }

        return stringBuilder.toString();
    }

}
