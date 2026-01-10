package com.semarescue.android.ui.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\n\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "GuideDetail", "GuideList", "HealthLibrary", "Home", "HospitalLocator", "IncidentLog", "MedicalID", "PanicMode", "Quiz", "Settings", "Lcom/semarescue/android/ui/navigation/Screen$GuideDetail;", "Lcom/semarescue/android/ui/navigation/Screen$GuideList;", "Lcom/semarescue/android/ui/navigation/Screen$HealthLibrary;", "Lcom/semarescue/android/ui/navigation/Screen$Home;", "Lcom/semarescue/android/ui/navigation/Screen$HospitalLocator;", "Lcom/semarescue/android/ui/navigation/Screen$IncidentLog;", "Lcom/semarescue/android/ui/navigation/Screen$MedicalID;", "Lcom/semarescue/android/ui/navigation/Screen$PanicMode;", "Lcom/semarescue/android/ui/navigation/Screen$Quiz;", "Lcom/semarescue/android/ui/navigation/Screen$Settings;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$GuideDetail;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "createRoute", "", "instructionId", "app_debug"})
    public static final class GuideDetail extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.GuideDetail INSTANCE = null;
        
        private GuideDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String instructionId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$GuideList;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class GuideList extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.GuideList INSTANCE = null;
        
        private GuideList() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$HealthLibrary;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class HealthLibrary extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.HealthLibrary INSTANCE = null;
        
        private HealthLibrary() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$Home;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$HospitalLocator;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class HospitalLocator extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.HospitalLocator INSTANCE = null;
        
        private HospitalLocator() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$IncidentLog;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class IncidentLog extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.IncidentLog INSTANCE = null;
        
        private IncidentLog() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$MedicalID;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class MedicalID extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.MedicalID INSTANCE = null;
        
        private MedicalID() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$PanicMode;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class PanicMode extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.PanicMode INSTANCE = null;
        
        private PanicMode() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$Quiz;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Quiz extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.Quiz INSTANCE = null;
        
        private Quiz() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/semarescue/android/ui/navigation/Screen$Settings;", "Lcom/semarescue/android/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.semarescue.android.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.ui.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
}