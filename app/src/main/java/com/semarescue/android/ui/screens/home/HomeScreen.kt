package com.semarescue.android.ui.screens.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager
import com.semarescue.android.utils.PhoneUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToGuides: () -> Unit,
    onNavigateToPanic: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToHospitalLocator: () -> Unit,
    onNavigateToQuiz: () -> Unit,
    onNavigateToHealthLibrary: () -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    val context = LocalContext.current
    var showEmergencyDialog by remember { mutableStateOf(false) }
    
    // Animated pulse effect for panic button
    val infiniteTransition = rememberInfiniteTransition(label = "panic_pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH) 
                            "SemaRescue" else "SemaRescue",
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    // Language toggle
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
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Fix: Apply Scaffold padding to prevent hiding content
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Weighted distribution
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            
            // Welcome message
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                    "Emergency First Aid Guide" else "Mwongozo wa Huduma ya Kwanza ya Dharura",
                style = MaterialTheme.typography.titleMedium, // Reduced size
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                    "Quick access to life-saving instructions" else "Ufikiaji wa haraka kwa maelekezo ya kuokoa maisha",
                style = MaterialTheme.typography.bodyMedium, // Reduced size
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.weight(1f)) // Flexible spacer
            
            // Panic Button - Balanced size
            Button(
                onClick = onNavigateToPanic,
                modifier = Modifier
                    .size(150.dp) // Increased slightly to 150dp
                    .scale(scale),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Emergency",
                        modifier = Modifier.size(40.dp), // Reduced icon size
                        tint = MaterialTheme.colorScheme.onError
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                            "PANIC\nMODE" else "HALI YA\nDHARURA",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onError
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f)) // Flexible spacer
            
            // Quick access cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Reduced spacing
            ) {
                QuickAccessCard(
                    title = if (currentLanguage == LanguageManager.Language.ENGLISH)
                        "Browse Guides" else "Angalia Mwongozo",
                    icon = Icons.Default.MenuBook,
                    onClick = onNavigateToGuides,
                    containerColor = Color(0xFF66BB6A), // Green
                    modifier = Modifier.weight(1f)
                )
                
                QuickAccessCard(
                    title = if (currentLanguage == LanguageManager.Language.ENGLISH)
                        "Nearby Hospital" else "Hospitali ya Karibu",
                    icon = Icons.Default.LocalHospital,
                    onClick = onNavigateToHospitalLocator,
                    containerColor = Color(0xFF42A5F5), // Blue
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Reduced spacing
            ) {
                QuickAccessCard(
                    title = if (currentLanguage == LanguageManager.Language.ENGLISH) "Health Library" else "Maktaba ya Afya",
                    icon = Icons.Default.LocalLibrary,
                    onClick = onNavigateToHealthLibrary,
                    containerColor = Color(0xFFAB47BC), // Purple
                    modifier = Modifier.weight(1f)
                )

                QuickAccessCard(
                    title = if (currentLanguage == LanguageManager.Language.ENGLISH) "Quiz & Certs" else "Maswali & Vyeti",
                    icon = Icons.Default.EmojiEvents,
                    onClick = onNavigateToQuiz,
                    containerColor = Color(0xFFFFA726), // Orange
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.weight(1f)) // Flexible spacer
            
            // Heartbeat Animation
            HeartbeatAnimation()
            
            Spacer(modifier = Modifier.weight(0.5f))
            
            // Emergency numbers info
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showEmergencyDialog = true },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), // Increased padding
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Emergency Numbers",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                                "Emergency Numbers" else "Nambari za Dharura",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                    Text(
                        text = "999 • 112 • 911",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
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

@Composable
fun HeartbeatAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "heartbeat")
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing), // Faster for continuous flow
            repeatMode = RepeatMode.Restart
        ),
        label = "phase"
    )

    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp) // Reduced height to 40dp
    ) {
        val width = size.width
        val height = size.height
        val path = androidx.compose.ui.graphics.Path()
        
        // Draw baseline
        path.moveTo(0f, height / 2)
        
        val beatSpacing = 300f // Distance between beats
        val totalOffset = phase * beatSpacing
        
        val step = 5f
        var x = 0f
        while (x < width) {
            // Calculate position relative to the repeating pattern
            // We add totalOffset to make it scroll left-to-right (or right-to-left if we subtract)
            // (x - totalOffset) moves right. (x + totalOffset) moves left?
            // Let's make it move right: pattern shifts right.
            
            val adjustedX = x - totalOffset
            
            // Modulo to repeat the pattern
            // We use a custom modulo that handles negative numbers correctly for scrolling
            val patternPos = (adjustedX % beatSpacing).let { if (it < 0) it + beatSpacing else it }
            
            // Center the beat within the spacing
            val distFromCenter = patternPos - (beatSpacing / 2)
            
            var y = height / 2
            
            // Only draw the complex wave if we are within the "active" width of the beat
            // The active beat is slightly narrower than the spacing to leave some flat line
            val activeWidth = 280f 
            
            if (kotlin.math.abs(distFromCenter) < activeWidth / 2) {
                val t = distFromCenter / (activeWidth / 2)
                
                // Complex pattern: P, Q, R, S, T, U waves
                
                if (t > -0.9f && t < -0.7f) {
                    y += (5f * kotlin.math.sin((t + 0.8f) * kotlin.math.PI * 10)).toFloat()
                } else if (t > -0.6f && t < -0.4f) {
                    y -= (15f * kotlin.math.sin((t + 0.5f) * kotlin.math.PI * 10)).toFloat()
                } else if (t > -0.3f && t < -0.2f) {
                    y += (10f * kotlin.math.sin((t + 0.25f) * kotlin.math.PI * 20)).toFloat()
                } else if (t > -0.2f && t < 0.1f) {
                    if (t < -0.05f) {
                        y -= 90f * (1f - kotlin.math.abs(t + 0.125f) * 15f)
                    } else {
                        y += 30f * (1f - kotlin.math.abs(t - 0.025f) * 15f)
                    }
                } else if (t > 0.2f && t < 0.5f) {
                    y -= (20f * kotlin.math.sin((t - 0.35f) * kotlin.math.PI * 6)).toFloat()
                } else if (t > 0.6f && t < 0.8f) {
                    y -= (8f * kotlin.math.sin((t - 0.7f) * kotlin.math.PI * 10)).toFloat()
                }
            }
            
            if (x == 0f) path.moveTo(x, y) else path.lineTo(x, y)
            x += step
        }
        
        
        val cyanColor = Color(0xFF00E5FF)
        
        drawPath(
            path = path,
            color = cyanColor,
            style = androidx.compose.ui.graphics.drawscope.Stroke(
                width = 4.dp.toPx(),
                cap = androidx.compose.ui.graphics.StrokeCap.Round,
                join = androidx.compose.ui.graphics.StrokeJoin.Round
            )
        )
    }
}

@Composable
fun QuickAccessCard(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer
) {
    Card(
        onClick = onClick,
        modifier = modifier.height(90.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(32.dp), // Reduced icon size
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}
