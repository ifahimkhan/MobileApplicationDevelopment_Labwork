package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void launchMap(View view) {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:19.0760, 72.8777"));
        Intent chooserIntent = Intent.createChooser(intent, "Launch Map");
        startActivity(chooserIntent);
    }

    public void launchMarket(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.gdscmpstme.mpstme_ontrack"));
        Intent chooserIntent = Intent.createChooser(intent, "Launch Market");
        startActivity(chooserIntent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"youremail@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hi, From my App");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, What's up? \n" +
                "This email sent from my app");
        intent.setType("message/rfc822");
        Intent chooserIntent = Intent.createChooser(intent, "Send Email");
        startActivity(chooserIntent);
    }
}