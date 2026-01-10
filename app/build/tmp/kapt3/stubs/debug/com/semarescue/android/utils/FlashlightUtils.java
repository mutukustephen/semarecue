package com.semarescue.android.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/semarescue/android/utils/FlashlightUtils;", "", "()V", "isFlashlightOn", "", "strobeJob", "Lkotlinx/coroutines/Job;", "startStrobe", "", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stopStrobe", "toggleStrobe", "app_debug"})
public final class FlashlightUtils {
    @org.jetbrains.annotations.Nullable()
    private static kotlinx.coroutines.Job strobeJob;
    private static boolean isFlashlightOn = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.semarescue.android.utils.FlashlightUtils INSTANCE = null;
    
    private FlashlightUtils() {
        super();
    }
    
    public final void toggleStrobe(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
    }
    
    private final void startStrobe(android.content.Context context, kotlinx.coroutines.CoroutineScope scope) {
    }
    
    public final void stopStrobe(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}