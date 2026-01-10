package com.semarescue.android.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Utility functions for phone dialing
 */
object PhoneUtils {
    /**
     * Opens the phone dialer with the specified emergency number
     * Uses ACTION_DIAL which opens dialer without auto-calling (safer, no permissions needed)
     */
    fun dialEmergencyNumber(context: Context, number: String) {
        try {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$number")
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            // Silently fail if no dialer app available
        }
    }
}
