package com.semarescue.android.ui.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager
import com.semarescue.android.utils.PhoneUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    val context = LocalContext.current
    var showEmergencyDialog by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "Settings" else "Mipangilio",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Language Settings
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Language,
                            contentDescription = "Language",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                                "Language" else "Lugha",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        FilterChip(
                            selected = currentLanguage == LanguageManager.Language.ENGLISH,
                            onClick = { viewModel.setLanguage(LanguageManager.Language.ENGLISH) },
                            label = { Text("English") },
                            leadingIcon = if (currentLanguage == LanguageManager.Language.ENGLISH) {
                                { Icon(Icons.Default.Check, contentDescription = null) }
                            } else null,
                            modifier = Modifier.weight(1f)
                        )
                        
                        FilterChip(
                            selected = currentLanguage == LanguageManager.Language.SWAHILI,
                            onClick = { viewModel.setLanguage(LanguageManager.Language.SWAHILI) },
                            label = { Text("Kiswahili") },
                            leadingIcon = if (currentLanguage == LanguageManager.Language.SWAHILI) {
                                { Icon(Icons.Default.Check, contentDescription = null) }
                            } else null,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
            
            // About Section
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                                "About SemaRescue" else "Kuhusu SemaRescue",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "SemaRescue is a bilingual first aid guide designed to provide quick, accurate emergency instructions in English and Swahili. This app works completely offline to ensure help is always available when you need it most."
                        else
                            "SemaRescue ni mwongozo wa huduma ya kwanza wa lugha mbili uliobuniwa kutoa maelekezo ya haraka na sahihi ya dharura kwa Kiingereza na Kiswahili. Programu hii inafanya kazi bila mtandao ili kuhakikisha msaada unapatikana wakati unahitajika zaidi.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                                "Version" else "Toleo",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "1.0.0",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            
            // Emergency Numbers Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showEmergencyDialog = true },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Emergency",
                            tint = MaterialTheme.colorScheme.onErrorContainer
                        )
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                                "Emergency Numbers" else "Nambari za Dharura",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onErrorContainer
                        )
                    }
                    
                    Text(
                        text = "999 • 112 • 911",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                    
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "Available 24/7 across Kenya" else "Inapatikana saa 24/7 nchini Kenya",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }
        
        // Emergency number selection dialog
        if (showEmergencyDialog) {
            AlertDialog(
                onDismissRequest = { showEmergencyDialog = false },
                title = {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "Call Emergency Number" else "Piga Nambari ya Dharura"
                    )
                },
                text = {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "Which emergency number would you like to call?" 
                        else "Ni nambari gani ya dharura ungependa kupiga?"
                    )
                },
                confirmButton = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        TextButton(
                            onClick = {
                                PhoneUtils.dialEmergencyNumber(context, "999")
                                showEmergencyDialog = false
                            }
                        ) {
                            Text("999")
                        }
                        TextButton(
                            onClick = {
                                PhoneUtils.dialEmergencyNumber(context, "112")
                                showEmergencyDialog = false
                            }
                        ) {
                            Text("112")
                        }
                        TextButton(
                            onClick = {
                                PhoneUtils.dialEmergencyNumber(context, "911")
                                showEmergencyDialog = false
                            }
                        ) {
                            Text("911")
                        }
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showEmergencyDialog = false }) {
                        Text(
                            if (currentLanguage == LanguageManager.Language.ENGLISH)
                                "Cancel" else "Ghairi"
                        )
                    }
                }
            )
        }
    }
}
