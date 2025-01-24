package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.text.format.Formatter;
import android.util.Log;

public class Util {
    public static void checkMemory(Context context){
        Runtime runtime = Runtime.getRuntime();
        long maxMemory=runtime.maxMemory();
//        Getting how much of the heap your app currently uses:

        long usedMemory=runtime.totalMemory() - runtime.freeMemory();
//        Getting how much of the heap your app can now use (available memory) :

        long availableMemory=maxMemory-usedMemory;
//        And, to format each of them nicely, you can use:

        String formattedMemorySize= Formatter.formatShortFileSize(context,availableMemory);
        Log.e("TAG", "maxMemory: "+maxMemory);
        Log.e("TAG", "usedMemory: "+usedMemory);
        Log.e("TAG", "availableMemory: "+availableMemory);
        Log.e("TAG", "availableMemory: "+formattedMemorySize);
    }
}
