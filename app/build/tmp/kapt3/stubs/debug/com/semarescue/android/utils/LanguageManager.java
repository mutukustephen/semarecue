package com.semarescue.android.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/semarescue/android/utils/LanguageManager;", "", "()V", "_currentLanguage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/semarescue/android/utils/LanguageManager$Language;", "currentLanguage", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentLanguage", "()Lkotlinx/coroutines/flow/StateFlow;", "setLanguage", "", "language", "toggleLanguage", "Language", "app_debug"})
public final class LanguageManager {
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.MutableStateFlow<com.semarescue.android.utils.LanguageManager.Language> _currentLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> currentLanguage = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.semarescue.android.utils.LanguageManager INSTANCE = null;
    
    private LanguageManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> getCurrentLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language language) {
    }
    
    public final void toggleLanguage() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/semarescue/android/utils/LanguageManager$Language;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "ENGLISH", "SWAHILI", "app_debug"})
    public static enum Language {
        /*public static final*/ ENGLISH /* = new ENGLISH(null) */,
        /*public static final*/ SWAHILI /* = new SWAHILI(null) */;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String code = null;
        
        Language(java.lang.String code) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.semarescue.android.utils.LanguageManager.Language> getEntries() {
            return null;
        }
    }
}