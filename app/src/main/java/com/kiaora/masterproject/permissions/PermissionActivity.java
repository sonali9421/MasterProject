package com.kiaora.masterproject.permissions;

import android.Manifest;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PermissionActivity extends AppCompatActivity {

    public static final int PERMISSIONS_MULTIPLE_REQUEST = 123;

    public static  String[] permissionArray = new String[]{Manifest.permission.INTERNET,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
    }

    @SuppressLint("NewApi")
    private void checkPermission() {
        if (PermissionHelper.checkPermission(this, permissionArray)) {
            // write your logic code if permission already granted
        } else {

            if (PermissionHelper.activityCompatPermission(this, permissionArray)) {

                Snackbar.make(this.findViewById(android.R.id.content),
                        "Please Grant Permissions.",
                        Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                requestPermissions(permissionArray, PERMISSIONS_MULTIPLE_REQUEST);
                            }
                        }).show();
            } else {
                requestPermissions(permissionArray, PERMISSIONS_MULTIPLE_REQUEST);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSIONS_MULTIPLE_REQUEST:
                if (grantResults.length > 0) {
                /*    boolean cameraPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean readExternalFile = grantResults[0] == PackageManager.PERMISSION_GRANTED;
*/
                    if (PermissionHelper.checkPermission(this, permissions)) {
                        Snackbar.make(this.findViewById(android.R.id.content),
                                "Please Grant Permissions.",
                                Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                                new View.OnClickListener() {
                                    @SuppressLint("NewApi")
                                    @Override
                                    public void onClick(View v) {
                                       /* requestPermissions(
                                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                                Manifest.permission.CAMERA},
                                                PERMISSIONS_MULTIPLE_REQUEST);*/
                                        finish();
                                    }
                                }).show();
                    } else {

                    }
                }
                break;
        }
    }
}
