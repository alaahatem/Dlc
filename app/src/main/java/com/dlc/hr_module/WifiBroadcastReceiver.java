package com.dlc.hr_module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import com.dlc.hr_module.Constants.Constants;
import com.dlc.hr_module.HomePage.Home;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by hp on 04/09/2018.
 */

public class WifiBroadcastReceiver extends BroadcastReceiver {
    static String bssid;
    static String mac;
    @Override
    public void onReceive(Context context, Intent intent) {
        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        Toast.makeText(context.getApplicationContext(),"hey",Toast.LENGTH_SHORT).show();
        if(info != null && info.isConnected()) {
            Toast.makeText(context.getApplicationContext(),"connected",Toast.LENGTH_SHORT).show();

            WifiManager wifiManager = (WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if(wifiManager.getConnectionInfo()!=null) {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();

                bssid = wifiInfo.getBSSID();
                mac = wifiInfo.getMacAddress();
                Toast.makeText(context.getApplicationContext(), bssid, Toast.LENGTH_LONG).show();
                Toast.makeText(context.getApplicationContext(), mac, Toast.LENGTH_LONG).show();
            }
            if(bssid!=null){
                if(bssid.equals("78:44:76:7f:69:70")){
                    new SweetAlertDialog(context.getApplicationContext(), SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Successfully Checked in!")
                            .setContentText("You have checked in using WIFI!")
                            .show();

                    Toast.makeText(context.getApplicationContext(),"SUCCESSFUL",Toast.LENGTH_LONG).show();
//                    new SweetAlertDialog(context.getApplicationContext(), SweetAlertDialog.SUCCESS_TYPE)
//                            .setTitleText("Successfully Checked in !")
//                            .setContentText("You checked in using WIFI")
//                            .show();
                    long time = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                    Date resultdate = new Date(time);
                    Constants.user.setStatus("Checked in"+" "+ sdf.format(resultdate));
                }
            }

        }
        else{
            Toast.makeText(context.getApplicationContext(),info.getState().toString(),Toast.LENGTH_LONG).show();
        }
        }
}
