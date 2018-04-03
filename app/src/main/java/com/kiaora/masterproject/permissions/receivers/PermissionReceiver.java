package com.kiaora.masterproject.permissions.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kiaora.masterproject.permissions.PermissionActivity;

public class PermissionReceiver extends BroadcastReceiver {
    public static final String CUSTOM_PERMISSION ="com.kiaora.masterproject.CUSTOM_PERMISSIONS";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent permissionIntent = new Intent(context, PermissionActivity.class);
        context.startActivity(permissionIntent);

      //  throw new UnsupportedOperationException("Not yet implemented");
    }
}

/* Intent intent = new Intent();
   intent.setAction("com.kiaora.masterproject.CUSTOM_PERMISSIONS");
   sendBroadcast(intent);*/
