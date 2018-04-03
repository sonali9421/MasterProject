package com.kiaora.masterproject.notifications;

import android.graphics.Bitmap;
import android.net.Uri;

public class NotificationData {
    private int notificationId;
    private int smallIcon;
    private String contentTitle;
    private String contentText;
    private String bigText;
    private Uri notificationRing;
    private int notificationColor;
    private Bitmap largeIcon;

    public NotificationData(int notificationId,int smallIcon, String contentTitle, String contentText, String bigText,
                            Uri notificationRing, int notificationColor/*, Bitmap largeIcon*/) {
        this.notificationId = notificationId;
        this.smallIcon = smallIcon;
        this.contentTitle = contentTitle;
        this.contentText = contentText;
        this.bigText = bigText;
        this.notificationRing = notificationRing;
        this.notificationColor = notificationColor;
      //  this.largeIcon = largeIcon;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public int getSmallIcon() {
        return smallIcon;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getContentText() {
        return contentText;
    }

    public String getBigText() {
        return bigText;
    }

    public Uri getNotificationRing() {
        return notificationRing;
    }

    public int getNotificationColor() {
        return notificationColor;
    }

    public Bitmap getLargeIcon() {
        return largeIcon;
    }
}
