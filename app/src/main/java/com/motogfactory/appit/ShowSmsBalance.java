package com.motogfactory.appit;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by windows 8 on 04-06-2015.
 */
public class ShowSmsBalance extends Activity {
    TextView text;
    Button close;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String bal=getPrefs.getString("smsbalance","00.00");

        final Dialog dialog=new Dialog(ShowSmsBalance.this);
        dialog.setContentView(R.layout.activity_custom_dialog);
        dialog.setTitle(null);
        text=(TextView) dialog.findViewById(R.id.etText);
        text.setText("Your free sms left are "+bal+" .For more dial *123*10#");
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
}
