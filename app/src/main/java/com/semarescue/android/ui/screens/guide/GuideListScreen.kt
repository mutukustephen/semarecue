package com.semarescue.android.ui.screens.guide

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.data.entities.Instruction
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideListScreen(
    onNavigateBack: () -> Unit,
    onGuideClick: (String) -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val instructions by viewModel.allInstructions.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    
    LaunchedEffect(instructions.size) {
        android.util.Log.d("GuideListScreen", "Instructions list size: ${instructions.size}")
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "Emergency Guides" else "Mwongozo wa Dharura",
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
                actions = {
                    IconButton(onClick = { viewModel.toggleLanguage() }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Language,
                                contentDescription = "Toggle Language"
                            )
                            Text(
                                text = if (currentLanguage == LanguageManager.Language.ENGLISH) "EN" else "SW",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = {
                    Text(
                        if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "Search emergencies..." else "Tafuta dharura..."
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { viewModel.updateSearchQuery("") }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                },
                singleLine = true,
                shape = MaterialTheme.shapes.large
            )
            
            // Instructions list
            if (instructions.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "No guides found" else "Hakuna mwongozo uliopatikana",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(instructions) { instruction ->
                        InstructionCard(
                            instruction = instruction,
                            currentLanguage = currentLanguage,
                            onClick = { onGuideClick(instruction.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InstructionCard(
    instruction: Instruction,
    currentLanguage: LanguageManager.Language,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when (instruction.category) {
                "Critical" -> MaterialTheme.colorScheme.errorContainer
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon based on category
            Icon(
                imageVector = when (instruction.category) {
                    "Critical" -> Icons.Default.Warning
                    else -> Icons.Default.HealthAndSafety
                },
                contentDescription = instruction.category,
                modifier = Modifier.size(40.dp),
                tint = when (instruction.category) {
                    "Critical" -> MaterialTheme.colorScheme.onErrorContainer
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
            
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                        instruction.title_en else instruction.title_sw,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = when (instruction.category) {
                        "Critical" -> MaterialTheme.colorScheme.onErrorContainer
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
                
                Text(
                    text = instruction.category,
                    style = MaterialTheme.typography.bodySmall,
                    color = when (instruction.category) {
                        "Critical" -> MaterialTheme.colorScheme.onErrorContainer
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }
            
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "View details",
                tint = when (instruction.category) {
                    "Critical" -> MaterialTheme.colorScheme.onErrorContainer
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}
