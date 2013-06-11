package com.wordpress.mobilecoder.smsautoresponder;

import com.wordpress.mobilecoder.smsautoresponder.R;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity{
	
	private static final String TAG = "Main";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.i(TAG, "onCreate");
		setContentView(R.layout.main);
//		AutoBroadcastReceiver r = new AutoBroadcastReceiver();
//		
//		try{
//			unregisterReceiver(r);
//		} catch(IllegalArgumentException e){}
//		
//		registerReceiver(r, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
	}
}
