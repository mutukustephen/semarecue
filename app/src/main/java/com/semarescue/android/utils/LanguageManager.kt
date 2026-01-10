package com.semarescue.android.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

object LanguageManager {
    enum class Language(val code: String) {
        ENGLISH("en"),
        SWAHILI("sw")
    }

    private val _currentLanguage = MutableStateFlow(Language.ENGLISH)
    val currentLanguage: StateFlow<Language> = _currentLanguage.asStateFlow()

    fun setLanguage(language: Language) {
        _currentLanguage.value = language
        // In a real app, we might persist this preference here
    }

    fun toggleLanguage() {
        if (_currentLanguage.value == Language.ENGLISH) {
            setLanguage(Language.SWAHILI)
        } else {
            setLanguage(Language.ENGLISH)
        }
    }
}
