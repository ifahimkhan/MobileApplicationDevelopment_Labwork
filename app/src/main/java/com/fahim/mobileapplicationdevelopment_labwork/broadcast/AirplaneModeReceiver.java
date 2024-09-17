package com.fahim.mobileapplicationdevelopment_labwork.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if (isAirplaneModeOn) {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show();
        }
    }
}
