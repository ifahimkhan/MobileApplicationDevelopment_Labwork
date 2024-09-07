package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            Log.e("TAG", "isAirplaneModeOn: "+(context instanceof MainActivity) + isAirplaneModeOn);
            if (isAirplaneModeOn) {
                Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
