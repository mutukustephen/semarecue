package com.semarescue.android.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/semarescue/android/utils/MetronomeUtils;", "", "()V", "metronomeJob", "Lkotlinx/coroutines/Job;", "isRunning", "", "startMetronome", "", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stopMetronome", "toggleMetronome", "app_debug"})
public final class MetronomeUtils {
    @org.jetbrains.annotations.Nullable()
    private static kotlinx.coroutines.Job metronomeJob;
    @org.jetbrains.annotations.NotNull()
    public static final com.semarescue.android.utils.MetronomeUtils INSTANCE = null;
    
    private MetronomeUtils() {
        super();
    }
    
    public final boolean toggleMetronome(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        return false;
    }
    
    private final void startMetronome(android.content.Context context, kotlinx.coroutines.CoroutineScope scope) {
    }
    
    public final void stopMetronome() {
    }
    
    public final boolean isRunning() {
        return false;
    }
}