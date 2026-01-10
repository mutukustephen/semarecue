package com.semarescue.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.semarescue.android.ui.screens.guide.GuideDetailScreen
import com.semarescue.android.ui.screens.guide.GuideListScreen
import com.semarescue.android.ui.screens.home.HomeScreen
import com.semarescue.android.ui.screens.panic.PanicModeScreen
import com.semarescue.android.ui.screens.settings.SettingsScreen

@Composable
fun SemaRescueNavHost() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToGuides = { navController.navigate(Screen.GuideList.route) },
                onNavigateToPanic = { navController.navigate(Screen.PanicMode.route) },
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) },
                onNavigateToHospitalLocator = { navController.navigate(Screen.HospitalLocator.route) },
                onNavigateToQuiz = { navController.navigate(Screen.Quiz.route) },
                onNavigateToHealthLibrary = { navController.navigate(Screen.HealthLibrary.route) }
            )
        }
        
        composable(Screen.GuideList.route) {
            GuideListScreen(
                onNavigateBack = { navController.popBackStack() },
                onGuideClick = { instructionId ->
                    navController.navigate(Screen.GuideDetail.createRoute(instructionId))
                }
            )
        }
        
        composable(
            route = Screen.GuideDetail.route,
            arguments = listOf(navArgument("instructionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val instructionId = backStackEntry.arguments?.getString("instructionId") ?: ""
            GuideDetailScreen(
                instructionId = instructionId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.PanicMode.route) {
            PanicModeScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToMedicalID = { navController.navigate(Screen.MedicalID.route) },

            )
        }
        
        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.MedicalID.route) {
            com.semarescue.android.ui.screens.medical.MedicalIDScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.IncidentLog.route) {
            com.semarescue.android.ui.screens.tools.IncidentLogScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.HospitalLocator.route) {
            com.semarescue.android.ui.screens.tools.HospitalLocatorScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Quiz.route) {
            com.semarescue.android.ui.screens.tools.QuizScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.HealthLibrary.route) {
            com.semarescue.android.ui.screens.library.HealthLibraryScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
