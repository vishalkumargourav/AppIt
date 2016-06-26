package com.motogfactory.appit;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

/**
 * Created by windows 8 on 03-06-2015.
 */


public class OpenPassword extends BroadcastReceiver
{

    String phoneno;
    protected SQLiteDatabase db;
    protected Cursor cursor;
    String password="*111#";
    MainActivity ph=new MainActivity();
    @Override
    public void onReceive(Context context, final Intent intent)
    {
        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL))
        {
            phoneno = intent.getExtras().getString(Intent.EXTRA_PHONE_NUMBER);
        }
        if(phoneno.equals("*123#") || phoneno.equals("*121*2#") || phoneno.equals("*111#") || phoneno.equals("*191*2#"))
        {
            setResultData("*1#");
            ComponentName componentName = new ComponentName(context,
                    MainActivity.class);
            context.getPackageManager().setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);


            Intent intent1 = new Intent(context , MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            context.startActivity(intent1);
            context.stopService(intent);
        }else if(phoneno.equals("*12345#")){
            setResultData("*1#");
            ComponentName componentName = new ComponentName(context,
                    Prefs.class);
            context.getPackageManager().setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            Intent p=new Intent(context,Prefs.class);
            p.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(p);
            context.stopService(intent);
        }else if(phoneno.equals("*123*10#") || phoneno.equals("*123*21#") || phoneno.equals("*123*11#") || phoneno.equals("*111*1#") || phoneno.equals("*111*2#")){
            setResultData("*1#");
            ComponentName componentName = new ComponentName(context,
                    ShowNetBalance.class);
            context.getPackageManager().setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            Intent intent2 = new Intent(context , ShowNetBalance.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            context.startActivity(intent2);
            context.stopService(intent);
        }else if(phoneno.equals("*123*7#")){
            setResultData("*1#");
            ComponentName componentName = new ComponentName(context,
                    ShowSmsBalance.class);
            context.getPackageManager().setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            Intent intent3 = new Intent(context , ShowSmsBalance.class);
            intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            context.startActivity(intent3);
            context.stopService(intent);
        }else if(phoneno.equals("*121#") || phoneno.equals("*191*5#")){
            setResultData(null);
            context.stopService(intent);
        }
    }
}