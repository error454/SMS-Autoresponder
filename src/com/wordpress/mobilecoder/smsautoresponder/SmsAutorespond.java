package com.wordpress.mobilecoder.smsautoresponder;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class SmsAutorespond extends Service {

	private static final String TAG = "SmsAutorespond";
	
	@Override
	public ComponentName startService(Intent service) {
		return super.startService(service);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "registering receiver");
		AutoBroadcastReceiver r = new AutoBroadcastReceiver();
		
		try{
			unregisterReceiver(r);
		} catch(IllegalArgumentException e){}
		
		registerReceiver(r, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
	}
}
