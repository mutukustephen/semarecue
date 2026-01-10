package com.semarescue.android.ui.screens.medical

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.MedicalViewModel
import com.semarescue.android.utils.LanguageManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalIDScreen(
    onNavigateBack: () -> Unit,
    viewModel: MedicalViewModel = hiltViewModel()
) {
    val medicalProfile by viewModel.medicalProfile.collectAsState()
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    
    var isEditing by remember { mutableStateOf(false) }
    
    // Edit State
    var name by remember { mutableStateOf("") }
    var bloodType by remember { mutableStateOf("") }
    var allergies by remember { mutableStateOf("") }
    var medications by remember { mutableStateOf("") }
    var emergencyNotes by remember { mutableStateOf("") }
    var isOrganDonor by remember { mutableStateOf(false) }

    // Initialize state when profile loads
    LaunchedEffect(medicalProfile) {
        medicalProfile?.let {
            name = it.name
            bloodType = it.bloodType
            allergies = it.allergies
            medications = it.medications
            emergencyNotes = it.emergencyNotes
            isOrganDonor = it.isOrganDonor
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Medical ID" else "Kitambulisho cha Tiba") 
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                },
                actions = {
                    if (!isEditing) {
                        IconButton(onClick = { isEditing = true }) {
                            Icon(Icons.Default.Edit, "Edit")
                        }
                    } else {
                        IconButton(onClick = {
                            viewModel.saveProfile(name, bloodType, allergies, medications, emergencyNotes, isOrganDonor)
                            isEditing = false
                        }) {
                            Icon(Icons.Default.Save, "Save")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (isEditing) {
                EditMedicalProfile(
                    name = name, onNameChange = { name = it },
                    bloodType = bloodType, onBloodTypeChange = { bloodType = it },
                    allergies = allergies, onAllergiesChange = { allergies = it },
                    medications = medications, onMedicationsChange = { medications = it },
                    emergencyNotes = emergencyNotes, onEmergencyNotesChange = { emergencyNotes = it },
                    isOrganDonor = isOrganDonor, onOrganDonorChange = { isOrganDonor = it },
                    currentLanguage = currentLanguage
                )
            } else {
                ViewMedicalProfile(
                    profile = medicalProfile,
                    currentLanguage = currentLanguage
                )
            }
        }
    }
}

@Composable
fun ViewMedicalProfile(
    profile: com.semarescue.android.data.entities.MedicalProfile?,
    currentLanguage: LanguageManager.Language
) {
    if (profile == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH) 
                    "No Medical ID set up yet.\nTap Edit to add details." 
                else "Hakuna Kitambulisho cha Tiba.\nBonyeza Hariri kuongeza maelezo.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    } else {
        // Emergency Header Card
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = profile.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Blood Type" else "Aina ya Damu",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onErrorContainer.copy(alpha = 0.8f)
                        )
                        Text(
                            text = profile.bloodType.ifBlank { "--" },
                            style = MaterialTheme.typography.displaySmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onErrorContainer
                        )
                    }
                    if (profile.isOrganDonor) {
                        Surface(
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "ORGAN DONOR",
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.errorContainer
                            )
                        }
                    }
                }
            }
        }

        // Details
        InfoSection(
            title = if (currentLanguage == LanguageManager.Language.ENGLISH) "Allergies" else "Mzio",
            content = profile.allergies,
            icon = Icons.Default.Warning
        )
        
        InfoSection(
            title = if (currentLanguage == LanguageManager.Language.ENGLISH) "Medications" else "Dawa",
            content = profile.medications,
            icon = Icons.Default.Medication
        )
        
        InfoSection(
            title = if (currentLanguage == LanguageManager.Language.ENGLISH) "Emergency Notes" else "Maelezo ya Dharura",
            content = profile.emergencyNotes,
            icon = Icons.Default.Info
        )
    }
}

@Composable
fun InfoSection(title: String, content: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content.ifBlank { "None listed" },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun EditMedicalProfile(
    name: String, onNameChange: (String) -> Unit,
    bloodType: String, onBloodTypeChange: (String) -> Unit,
    allergies: String, onAllergiesChange: (String) -> Unit,
    medications: String, onMedicationsChange: (String) -> Unit,
    emergencyNotes: String, onEmergencyNotesChange: (String) -> Unit,
    isOrganDonor: Boolean, onOrganDonorChange: (Boolean) -> Unit,
    currentLanguage: LanguageManager.Language
) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Full Name" else "Jina Kamili") },
        modifier = Modifier.fillMaxWidth()
    )
    
    OutlinedTextField(
        value = bloodType,
        onValueChange = onBloodTypeChange,
        label = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Blood Type (e.g. O+)" else "Aina ya Damu") },
        modifier = Modifier.fillMaxWidth()
    )
    
    OutlinedTextField(
        value = allergies,
        onValueChange = onAllergiesChange,
        label = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Allergies" else "Mzio") },
        modifier = Modifier.fillMaxWidth(),
        minLines = 2
    )
    
    OutlinedTextField(
        value = medications,
        onValueChange = onMedicationsChange,
        label = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Current Medications" else "Dawa za Sasa") },
        modifier = Modifier.fillMaxWidth(),
        minLines = 2
    )
    
    OutlinedTextField(
        value = emergencyNotes,
        onValueChange = onEmergencyNotesChange,
        label = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Emergency Notes" else "Maelezo ya Dharura") },
        modifier = Modifier.fillMaxWidth(),
        minLines = 3
    )
    
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(checked = isOrganDonor, onCheckedChange = onOrganDonorChange)
        Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "I am an Organ Donor" else "Mimi ni Mtoaji wa Viungo")
    }
}
