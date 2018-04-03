package com.kiaora.masterproject.utility;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.kiaora.masterproject.R;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by sonalilawande on 3/31/2018.
 */
public class LibUtils {

    public static void showAsPopup(Activity activity, int hw_per) {
        //To show activity as dialog and dim the background, you need to declare android:theme="@style/PopupTheme" on for the chosen activity on the manifest
        activity.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        //params.height = WindowManager.LayoutParams.FILL_PARENT;
        //params.width = 850; //fixed width

        if (hw_per != 100) {
            params.height = getHeightInPercentage(activity, hw_per);
            params.width = getWidthInPercentage(activity, hw_per); //fixed width
        } else {
            params.width = WindowManager.LayoutParams.FILL_PARENT;
        }

        params.alpha = 1.0f;
        params.dimAmount = 0.5f;
        activity.getWindow().setAttributes((WindowManager.LayoutParams) params);
    }

    public static int getWidthInPercentage(Context context, int percentage) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int screen_width = display.getWidth();
        int control_width = (screen_width * percentage) / 100;
        return control_width;
    }

    public static int getHeightInPercentage(Context context, int percentage) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int screen_height = display.getHeight();
        int control_height = (screen_height * percentage) / 100;
        return control_height;
    }

    public static void setViewAndChildrenEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewAndChildrenEnabled(child, enabled);
            }
        }
    }

    public static String getStringDate(long date, String format) {
        String formatedDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        formatedDate = sdf.format(date);
        return formatedDate;
    }

    public static void exitApp(final Activity context) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(context.getString(R.string.exit_app_string));
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(startMain);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    context.finishAffinity();
                } else {
                    context.finish();
                }
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public static void goToDialPad(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }

    public static void stopApp(Activity context) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            context.finishAffinity();
        } else {
            context.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static LinearLayout.LayoutParams getLayoutParam(Context context, int width, int height) {
        int widthParam = getWidthInPercentage(context, width);
        int heightParam = getWidthInPercentage(context, height);
        return new LinearLayout.LayoutParams(widthParam, heightParam);
    }

    public static boolean isMyServiceRunning(Class<?> serviceClass, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.e("Service already", "running" + serviceClass.getName());

                return true;
            }
        }
        Log.e("Service not", "running");
        return false;
    }

    @SuppressWarnings("WrongConstant")
    public static void restart(Context context, int delay) {
        if (delay == 0) {
            delay = 1;
        }
        Log.e("", "restarting app");
        Intent restartIntent = context.getPackageManager()
                .getLaunchIntentForPackage(context.getPackageName() );
        PendingIntent intent = PendingIntent.getActivity(context, 0, restartIntent, Intent.FLAG_ACTIVITY_CLEAR_TOP);
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.set(AlarmManager.RTC, System.currentTimeMillis() + delay, intent);
        System.exit(2);
    }

    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String device_id = tm.getDeviceId();
        return device_id;
    }
}
