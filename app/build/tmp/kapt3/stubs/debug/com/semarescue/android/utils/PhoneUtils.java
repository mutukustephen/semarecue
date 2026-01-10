package com.semarescue.android.utils;

/**
 * Utility functions for phone dialing
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/semarescue/android/utils/PhoneUtils;", "", "()V", "dialEmergencyNumber", "", "context", "Landroid/content/Context;", "number", "", "app_debug"})
public final class PhoneUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.semarescue.android.utils.PhoneUtils INSTANCE = null;
    
    private PhoneUtils() {
        super();
    }
    
    /**
     * Opens the phone dialer with the specified emergency number
     * Uses ACTION_DIAL which opens dialer without auto-calling (safer, no permissions needed)
     */
    public final void dialEmergencyNumber(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String number) {
    }
}