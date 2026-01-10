package com.semarescue.android.ui.screens.panic

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.PanicModeViewModel
import com.semarescue.android.utils.LanguageManager
import com.semarescue.android.utils.PhoneUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanicModeScreen(
    onNavigateBack: () -> Unit,
    onNavigateToMedicalID: () -> Unit,

    viewModel: PanicModeViewModel = hiltViewModel()
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    val emergencyContacts by viewModel.emergencyContacts.collectAsState()
    val context = LocalContext.current
    
    var showEmergencyNumberDialog by remember { mutableStateOf(false) }
    var showAddContactDialog by remember { mutableStateOf(false) }
    var showDangerDialog by remember { mutableStateOf(false) }
    
    // Gradients
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFD32F2F), // Darker Red
            Color(0xFFFF5252)  // Brighter Red
        )
    )
    
    val sosGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFF1744), Color(0xFFFF5252))
    )
    
    val callGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF2196F3), Color(0xFF03A9F4))
    )
    
    val strobeGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFFC107), Color(0xFFFFD54F))
    )
    
    // Pulsing animation for warning icon
    val infiniteTransition = rememberInfiniteTransition(label = "panic_pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header with Close Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH) "PANIC MODE" else "HALI YA DHARURA",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.9f)
                )
                
                IconButton(
                    onClick = onNavigateBack,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White.copy(alpha = 0.2f),
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Exit",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                
                // Pulsing Warning Icon
                Box(contentAlignment = Alignment.Center) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .scale(scale)
                            .background(Color.White.copy(alpha = 0.2f), CircleShape)
                    )
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Emergency",
                        modifier = Modifier.size(80.dp),
                        tint = Color.White
                    )
                }
                
                Text(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                        "Stay Calm & Follow Steps" else "Tulia & Fuata Hatua",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                
                // Emergency Actions List
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PanicActionCard(
                        number = "1",
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Check Danger" else "Angalia Hatari",
                        subtitle = if (currentLanguage == LanguageManager.Language.ENGLISH) "Ensure safety first" else "Hakikisha usalama",
                        icon = Icons.Default.Visibility,
                        onClick = { showDangerDialog = true }
                    )
                    
                    PanicActionCard(
                        number = "2",
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Call Help" else "Piga Simu",
                        subtitle = if (currentLanguage == LanguageManager.Language.ENGLISH) "999 / 112 / 911" else "Nambari za dharura",
                        icon = Icons.Default.Phone,
                        onClick = { showEmergencyNumberDialog = true }
                    )

                    PanicActionCard(
                        number = "ID",
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Medical ID" else "Kitambulisho cha Tiba",
                        subtitle = if (currentLanguage == LanguageManager.Language.ENGLISH) "Allergies, Blood Type" else "Mzio, Aina ya Damu",
                        icon = Icons.Default.MedicalServices,
                        onClick = onNavigateToMedicalID,
                        isHighlight = true
                    )


                    // Contacts
                    if (emergencyContacts.isNotEmpty()) {
                        emergencyContacts.forEach { contact ->
                            PanicActionCard(
                                number = "★",
                                text = contact.name,
                                subtitle = contact.phone,
                                icon = Icons.Default.ContactPhone,
                                onClick = { PhoneUtils.dialEmergencyNumber(context, contact.phone) },
                                onLongClick = { viewModel.deleteEmergencyContact(contact) },
                                isHighlight = true
                            )
                        }
                    }
                    
                    PanicActionCard(
                        number = "+",
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Add Contact" else "Ongeza Mtu",
                        subtitle = if (currentLanguage == LanguageManager.Language.ENGLISH) "Personal emergency contact" else "Mawasiliano ya dharura",
                        icon = Icons.Default.PersonAdd,
                        onClick = { showAddContactDialog = true }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Main Action Buttons
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                // SOS Button
                val permissionLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
                    androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions()
                ) { permissions ->
                    if (permissions.all { it.value }) {
                        viewModel.sendSos(context)
                    } else {
                        android.widget.Toast.makeText(context, "Permissions required", android.widget.Toast.LENGTH_SHORT).show()
                    }
                }

                GradientButton(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH) "SEND SOS LOCATION" else "TUMA MAHALI PA SOS",
                    icon = Icons.Default.Send,
                    gradient = sosGradient,
                    onClick = {
                        permissionLauncher.launch(
                            arrayOf(
                                android.Manifest.permission.SEND_SMS,
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        GradientButton(
                            text = "999",
                            icon = Icons.Default.Phone,
                            gradient = callGradient,
                            onClick = { PhoneUtils.dialEmergencyNumber(context, "999") }
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        GradientButton(
                            text = "STROBE",
                            icon = Icons.Default.FlashOn,
                            gradient = strobeGradient,
                            textColor = Color.Black,
                            onClick = { viewModel.toggleStrobe(context) }
                        )
                    }
                }
            }
        }
    }
    
    // Dialogs
    if (showDangerDialog) {
        AlertDialog(
            onDismissRequest = { showDangerDialog = false },
            title = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Safety Check" else "Angalia Usalama") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(if (currentLanguage == LanguageManager.Language.ENGLISH) 
                        "• Fire or Smoke\n• Live Wires\n• Gas Leak\n• Traffic / Vehicles\n• Violence / Aggression\n• Falling Objects\n• Chemical Spills\n• Deep Water\n• Unstable Ground" 
                        else 
                        "• Moto au Moshi\n• Waya za Umeme\n• Kuvuja kwa Gesi\n• Trafiki / Magari\n• Vurugu\n• Vitu Vinavyoanguka\n• Kemikali Hatari\n• Maji Marefu\n• Ardhi Isiyo Imara")
                }
            },
            confirmButton = {
                Button(
                    onClick = { showDangerDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) "I'm Safe" else "Niko Salama",
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = { 
                        showDangerDialog = false
                        android.widget.Toast.makeText(context, if (currentLanguage == LanguageManager.Language.ENGLISH) "Evacuate immediately!" else "Ondoka mara moja!", android.widget.Toast.LENGTH_LONG).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.errorContainer)
                ) {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Not Safe" else "Si Salama",
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            },
            shape = RoundedCornerShape(16.dp)
        )
    }

    if (showEmergencyNumberDialog) {
        AlertDialog(
            onDismissRequest = { showEmergencyNumberDialog = false },
            title = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Call Emergency" else "Piga Dharura") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("999", "112", "911").forEach { number ->
                        Button(
                            onClick = { 
                                PhoneUtils.dialEmergencyNumber(context, number)
                                showEmergencyNumberDialog = false
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(number, fontSize = 18.sp, color = MaterialTheme.colorScheme.onPrimaryContainer)
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { showEmergencyNumberDialog = false }) {
                    Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Cancel" else "Ghairi")
                }
            }
        )
    }
    
    if (showAddContactDialog) {
        EmergencyContactDialog(
            currentLanguage = currentLanguage,
            onDismiss = { showAddContactDialog = false },
            onSave = { name, phone ->
                viewModel.saveEmergencyContact(name, phone)
                showAddContactDialog = false
            }
        )
    }
}

@Composable
fun PanicActionCard(
    number: String,
    text: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    isHighlight: Boolean = false
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick ?: {},
        enabled = onClick != null,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isHighlight) Color(0xFFFFF3E0) else Color.White.copy(alpha = 0.95f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = if (isHighlight) Color(0xFFFF9800) else Color(0xFFFF5252),
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = number,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isHighlight) Color(0xFFFF9800) else Color(0xFFFF5252),
                modifier = Modifier.size(24.dp)
            )
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF757575)
                )
            }
            
            if (onLongClick != null) {
                IconButton(onClick = onLongClick) {
                    Icon(Icons.Default.Delete, null, tint = Color(0xFF757575))
                }
            } else if (onClick != null) {
                Icon(Icons.Default.ChevronRight, null, tint = Color(0xFFBDBDBD))
            }
        }
    }
}

@Composable
fun GradientButton(
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    gradient: Brush,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
        }
    }
}

@Composable
fun EmergencyContactDialog(
    currentLanguage: LanguageManager.Language,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Add Contact" else "Ongeza Mtu") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name / Jina") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone / Simu") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { if (name.isNotBlank() && phone.isNotBlank()) onSave(name, phone) },
                enabled = name.isNotBlank() && phone.isNotBlank(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Save" else "Hifadhi")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Cancel" else "Ghairi")
            }
        },
        shape = RoundedCornerShape(16.dp)
    )
}
