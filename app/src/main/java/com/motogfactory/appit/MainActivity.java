package com.motogfactory.appit;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    TextView text;
    Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String bal=getPrefs.getString("mainbalance","00.00");
        hide();
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_custom_dialog);
        dialog.setTitle(null);
        text=(TextView) dialog.findViewById(R.id.etText);
        text.setText("Your main account balance left is Rs. "+bal+" .ForMore dial *123*7#");
        dialog.show();
        close=(Button)dialog.findViewById(R.id.btnClick);
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();

            }
        });
    }
    public void hide(){
        ComponentName componentName = new
                ComponentName(getApplicationContext(),
                MainActivity.class);
        getPackageManager().setComponentEnabledSetting(
                componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
