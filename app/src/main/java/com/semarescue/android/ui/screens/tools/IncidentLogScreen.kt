package com.semarescue.android.ui.screens.tools

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.IncidentViewModel
import com.semarescue.android.utils.LanguageManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncidentLogScreen(
    onNavigateBack: () -> Unit,
    viewModel: IncidentViewModel = hiltViewModel()
) {
    val logs by viewModel.logs.collectAsState()
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    
    var showAddDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Incident Log" else "Kumbukumbu ya Tukio") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.clearLogs() }) {
                        Icon(Icons.Default.Delete, "Clear All")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddDialog = true }) {
                Icon(Icons.Default.Add, "Add Log")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Quick Actions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                QuickLogButton(
                    text = "CPR Started",
                    onClick = { viewModel.addLog("CPR Started", "Action") },
                    modifier = Modifier.weight(1f)
                )
                QuickLogButton(
                    text = "AED Applied",
                    onClick = { viewModel.addLog("AED Applied", "Action") },
                    modifier = Modifier.weight(1f)
                )
            }
            
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(logs) { log ->
                    LogCard(log)
                }
            }
        }
    }
    
    if (showAddDialog) {
        AddLogDialog(
            onDismiss = { showAddDialog = false },
            onSave = { desc ->
                viewModel.addLog(desc, "Manual")
                showAddDialog = false
            }
        )
    }
}

@Composable
fun QuickLogButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Text(text, color = MaterialTheme.colorScheme.onSecondaryContainer, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun LogCard(log: com.semarescue.android.data.entities.IncidentLog) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = log.description,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = log.category,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date(log.timestamp)),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun AddLogDialog(onDismiss: () -> Unit, onSave: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Log Entry") },
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            Button(onClick = { if (text.isNotBlank()) onSave(text) }) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
