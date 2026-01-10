package com.semarescue.android.ui.screens.tools

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.LocalPharmacy
import androidx.compose.material.icons.filled.LocalPolice
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalLocatorScreen(
    onNavigateBack: () -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Find Help Nearby" else "Tafuta Msaada Karibu") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH) 
                    "Select a service to find nearby locations on Google Maps." 
                    else "Chagua huduma kutafuta maeneo ya karibu kwenye Ramani.",
                style = MaterialTheme.typography.bodyLarge
            )

            LocatorButton(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Find Hospital" else "Tafuta Hospitali",
                icon = Icons.Default.LocalHospital,
                query = "hospital",
                context = context
            )

            LocatorButton(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Find Pharmacy" else "Tafuta Duka la Dawa",
                icon = Icons.Default.LocalPharmacy,
                query = "pharmacy",
                context = context
            )

            LocatorButton(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Find Police Station" else "Tafuta Kituo cha Polisi",
                icon = Icons.Default.LocalPolice,
                query = "police station",
                context = context
            )
        }
    }
}

@Composable
fun LocatorButton(
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    query: String,
    context: android.content.Context
) {
    Button(
        onClick = {
            val gmmIntentUri = android.net.Uri.parse("geo:0,0?q=$query")
            val mapIntent = android.content.Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            try {
                context.startActivity(mapIntent)
            } catch (e: Exception) {
                val webIntent = android.content.Intent(android.content.Intent.ACTION_VIEW, 
                    android.net.Uri.parse("https://www.google.com/maps/search/$query"))
                context.startActivity(webIntent)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
