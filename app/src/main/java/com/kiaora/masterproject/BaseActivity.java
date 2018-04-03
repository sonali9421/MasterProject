package com.kiaora.masterproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kiaora.masterproject.notifications.NotificationData;
import com.kiaora.masterproject.permissions.PermissionActivity;
import com.kiaora.masterproject.notifications.CustomNotifications;
import com.kiaora.masterproject.permissions.PermissionHelper;
import com.kiaora.masterproject.permissions.receivers.PermissionReceiver;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_base);

        if (PermissionHelper.checkPermission(this, PermissionActivity.permissionArray)) {
            Toast.makeText(this, "grant", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.setAction(PermissionReceiver.CUSTOM_PERMISSION);
            sendBroadcast(intent);
        }

        Uri notificationRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap bitmap = null;
       /* try {
             bitmap = BitmapFactory.decodeStream((InputStream) new URL("https://www.androidheadlines.com/wp-content/uploads/2018/04/LG-G7-OnLeaks-Mr-Phone-10.jpg").getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        NotificationData notificationData = new NotificationData(0, R.mipmap.ic_launcher, "Notification", "Notification Data",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/);

        CustomNotifications customNotifications = new CustomNotifications(this);
        customNotifications.normalNotification(new NotificationData(0, R.mipmap.ic_launcher, "Notification", "normalNotification",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.downloadNotification(new NotificationData(1, R.mipmap.ic_launcher, "Notification", "downloadNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.pendingIntentNotification(new NotificationData(2, R.mipmap.ic_launcher, "Notification", "pendingIntentNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.actionButtonNotification(new NotificationData(3, R.mipmap.ic_launcher, "Notification", "actionButtonNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.largeTextNotification(new NotificationData(4, R.mipmap.ic_launcher, "Notification", "largeTextNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.inboxStyleNotification(new NotificationData(5, R.mipmap.ic_launcher, "Notification", "inboxStyleNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.conversationNotification(new NotificationData(6, R.mipmap.ic_launcher, "Notification", "conversationNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
        customNotifications.customNotification(new NotificationData(7, R.mipmap.ic_launcher, "Notification", "customNotification ",
                "Notification big text", notificationRing, Color.RED/*,bitmap*/));
    }
}
