package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver airplaneModeReceiver = new AirplaneModeReceiver();
    private ConnectivityReceiver connectivityReceiver = new ConnectivityReceiver();

    private TextView textView;
    private Switch airplaneModeSwitch;
    private Switch internetModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        airplaneModeSwitch = findViewById(R.id.switchAirPlaneMode);
        internetModeSwitch = findViewById(R.id.switchInternetMode);

        internetModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    registerReceiver(connectivityReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
                } else {
                    unregisterReceiver(connectivityReceiver);
                }
            }
        });
        airplaneModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                    registerReceiver(airplaneModeReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
                } else {
                    unregisterReceiver(airplaneModeReceiver);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(airplaneModeReceiver);
        unregisterReceiver(connectivityReceiver);
    }
}
