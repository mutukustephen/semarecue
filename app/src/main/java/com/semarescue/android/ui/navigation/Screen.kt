package com.semarescue.android.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object GuideList : Screen("guide_list")
    object GuideDetail : Screen("guide_detail/{instructionId}") {
        fun createRoute(instructionId: String) = "guide_detail/$instructionId"
    }
    object PanicMode : Screen("panic_mode")
    object Settings : Screen("settings")
    object MedicalID : Screen("medical_id")
    object IncidentLog : Screen("incident_log")
    object HospitalLocator : Screen("hospital_locator")
    object Quiz : Screen("quiz")
    object HealthLibrary : Screen("health_library")
}
