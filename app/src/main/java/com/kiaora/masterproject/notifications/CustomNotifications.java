package com.kiaora.masterproject.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.util.Log;
import android.widget.RemoteViews;

import com.kiaora.masterproject.BaseActivity;
import com.kiaora.masterproject.R;
import com.kiaora.masterproject.permissions.receivers.PermissionReceiver;

import java.io.IOException;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class CustomNotifications {

    private static final String CHANNEL_ID = "channel_id";
    private static final String CHANNEL_NAME = "channel_name";
    private static final String CHANNEL_DESCRIPTION = "channel_description";
    private static final int NOTIFICATION_ID = 0;

    private Context mContext;

    public CustomNotifications(Context context) {
        mContext = context;
    }

    public void normalNotification(NotificationData notificationData) {
        Log.e("Data", notificationData.getContentTitle() + "" + notificationData.getContentText());
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setAutoCancel(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000);
         //.setStyle(new NotificationCompat.MessagingStyle("Me"))
        //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), mBuilder.build());
    }

    public void downloadNotification(NotificationData notificationData) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, CHANNEL_ID);
        mBuilder.setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setSmallIcon(notificationData.getSmallIcon())
                .setPriority(NotificationCompat.PRIORITY_LOW);

// Issue the initial notification with zero progress
        int PROGRESS_MAX = 100;
        int PROGRESS_CURRENT = 0;
        mBuilder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);
        notificationManager.notify(notificationData.getNotificationId(), mBuilder.build());

// Do the job here that tracks the progress.
// Usually, this should be in a worker thread
// To show progress, update PROGRESS_CURRENT and update the notification with:
// mBuilder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
// notificationManager.notify(notificationId, mBuilder.build());

// When done, update the notification one more time to remove the progress bar
        mBuilder.setContentText("Download complete").setProgress(0, 0, false);

        notificationManager.notify(notificationData.getNotificationId(), mBuilder.build());
    }

    public void pendingIntentNotification(NotificationData notificationData) {
        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(mContext, BaseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setContentIntent(pendingIntent).setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true);
        //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), mBuilder.build());
    }

    public void actionButtonNotification(NotificationData notificationData) {
        Intent snoozeIntent = new Intent(mContext, PermissionReceiver.class);
        snoozeIntent.setAction(PermissionReceiver.CUSTOM_PERMISSION);
        snoozeIntent.putExtra(EXTRA_NOTIFICATION_ID, 0);
        PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(mContext, 0, snoozeIntent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.mipmap.ic_launcher, "snooze", snoozePendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true);
        //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), mBuilder.build());
    }


    public void largeImageNotification(NotificationData notificationData){
//        Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL("").getContent());

        Notification notification = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setLargeIcon(notificationData.getLargeIcon())
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(notificationData.getLargeIcon()).bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true)
                //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
                .build();

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), notification);
    }

    public void largeTextNotification(NotificationData notificationData){

        // Uri notificationRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationData.getBigText()))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true)
                //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
                .build();

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), notification);
    }

    public void inboxStyleNotification(NotificationData notificationData){
        //  Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL("").getContent());
        //   Uri notificationRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .setLargeIcon(notificationData.getLargeIcon())
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("")
                        .addLine(""))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true)
                //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
                .build();

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), notification);
    }

    public void conversationNotification(NotificationData notificationData) {
        long l = 264 - 1;
        NotificationCompat.MessagingStyle.Message message1 = new NotificationCompat.MessagingStyle.Message("Text", l, "getSender");
        NotificationCompat.MessagingStyle.Message message2 = new NotificationCompat.MessagingStyle.Message("Text", l, "getSender");

        Uri notificationRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setStyle(new NotificationCompat.MessagingStyle("reply_name")
                        .addMessage(message1)
                        .addMessage(message2))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true)
                //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
                .build();

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), notification);
    }

    public void customNotification(NotificationData notificationData) {
        RemoteViews notificationLayout = new RemoteViews(mContext.getPackageName(), R.layout.notification_small);
        RemoteViews notificationLayoutExpanded = new RemoteViews(mContext.getPackageName(), R.layout.notification_large);

        Uri notificationRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification customNotification = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayoutExpanded)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true)
                //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
                .build();

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), customNotification);

    }

    private static final String KEY_TEXT_REPLY = "key_text_reply";

    public void directReplayNotification(NotificationData notificationData) {


        String replyLabel = "Replay";
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .build();

        // Build a PendingIntent for the reply action to trigger.

        Intent intent = new Intent(mContext, BaseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Conversation conversation = new Conversation(1, intent);
        PendingIntent replyPendingIntent = PendingIntent.getBroadcast(mContext,
                conversation.getConversationId(),
                conversation.getMessageReplyIntent(),
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Create the reply action and add the remote input.
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.mipmap.ic_launcher,
                        "Replay", replyPendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();

        Uri notificationRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification newMessageNotification = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(notificationData.getSmallIcon())
                .setContentTitle(notificationData.getContentTitle())
                .setContentText(notificationData.getContentText())
                .addAction(action)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setColor(notificationData.getNotificationColor())
                .setColorized(true)
                .setSound(notificationData.getNotificationRing())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(notificationData.getNotificationColor(), 3000, 3000)
                .setAutoCancel(true)
                //        .setSound(Uri.parse("uri://sadfasdfasdf.mp3"));
                .build();
        newMessageNotification.flags |= Notification.FLAG_AUTO_CANCEL;

// Issue the notification.
        //    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            mChannel.setDescription(CHANNEL_DESCRIPTION);
            mChannel.enableLights(true);
            mChannel.setLightColor(notificationData.getNotificationColor());
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 300, 200, 300});
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationData.getNotificationId(), newMessageNotification);
    }


    public class Conversation {
        private int conversationId;
        private Intent messageReplyIntent;

        public Conversation(int conversationId, Intent messageReplyIntent) {
            this.conversationId = conversationId;
            this.messageReplyIntent = messageReplyIntent;
        }

        public int getConversationId() {
            return conversationId;
        }

        public Intent getMessageReplyIntent() {
            return messageReplyIntent;
        }
    }
}
