package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.fahim.mobileapplicationdevelopment_labwork.broadcast.AirplaneModeReceiver;
import com.fahim.mobileapplicationdevelopment_labwork.broadcast.BatteryLevelReceiver;
import com.fahim.mobileapplicationdevelopment_labwork.broadcast.ConnectivityReceiver;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver airplaneModeReceiver = new AirplaneModeReceiver();
    private ConnectivityReceiver connectivityReceiver = new ConnectivityReceiver();
    private BatteryLevelReceiver batteryLevelReceiver = new BatteryLevelReceiver();

    private Switch airplaneModeSwitch;
    private Switch internetModeSwitch;
    private Switch batteryLevelSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        airplaneModeSwitch = findViewById(R.id.switchAirPlaneMode);
        internetModeSwitch = findViewById(R.id.switchInternetMode);
        batteryLevelSwitch = findViewById(R.id.switchBatteryLevel);

        internetModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        registerReceiver(connectivityReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
                    } else registerReceiver(connectivityReceiver, filter);
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
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        registerReceiver(airplaneModeReceiver, filter, Context.RECEIVER_NOT_EXPORTED);
                    } else
                        registerReceiver(airplaneModeReceiver, filter);
                } else {
                    unregisterReceiver(airplaneModeReceiver);
                }
            }
        });
        batteryLevelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        registerReceiver(batteryLevelReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED), Context.RECEIVER_NOT_EXPORTED);
                    } else
                        registerReceiver(batteryLevelReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                } else {
                    unregisterReceiver(batteryLevelReceiver);
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(airplaneModeReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            unregisterReceiver(connectivityReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            unregisterReceiver(batteryLevelReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
