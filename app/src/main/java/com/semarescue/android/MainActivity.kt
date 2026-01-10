package com.semarescue.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.semarescue.android.ui.navigation.SemaRescueNavHost
import com.semarescue.android.ui.theme.SemaRescueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Force database seeding
        val request = androidx.work.OneTimeWorkRequestBuilder<com.semarescue.android.workers.SeedDatabaseWorker>().build()
        androidx.work.WorkManager.getInstance(this).enqueue(request)
        
        setContent {
            SemaRescueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SemaRescueNavHost()
                }
            }
        }
    }
}
