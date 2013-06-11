package com.wordpress.mobilecoder.smsautoresponder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.SmsManager;
import android.util.Log;

public class AutoBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "AutoBroadcastReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {

		Log.i(TAG, "new call");
		if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

			Bundle extras = intent.getExtras();
			if (extras != null) {
				Object[] smsextras = (Object[]) extras.get("pdus");
				for (int i = 0; i < smsextras.length; i++) {
					SmsMessage smsmsg = SmsMessage
							.createFromPdu((byte[]) smsextras[i]);
					String strMsgBody = smsmsg.getMessageBody().toString();
					String strMsgSrc = smsmsg.getOriginatingAddress();
					
					//SmsManager smsManager = SmsManager.getDefault();
					//smsManager.sendTextMessage(strMsgSrc, null, context.getString(R.string.autoResponse), null, null);
					Log.i(TAG, "Got sms: " + i + " " + strMsgSrc);
				}
			}
		} else if (intent.getAction() != null) {
			if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)
					|| intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
				context.startService(new Intent(context, SmsAutorespond.class));
			}
		}
	}

}
