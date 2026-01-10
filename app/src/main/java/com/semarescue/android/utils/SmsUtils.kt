package com.semarescue.android.utils

import android.telephony.SmsManager
import android.util.Log

object SmsUtils {
    fun sendSms(phoneNumber: String, message: String) {
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            Log.d("SmsUtils", "SMS sent to $phoneNumber")
        } catch (e: Exception) {
            Log.e("SmsUtils", "Failed to send SMS", e)
            e.printStackTrace()
        }
    }
}
