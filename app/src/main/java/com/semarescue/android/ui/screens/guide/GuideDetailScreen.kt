package com.semarescue.android.ui.screens.guide

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.data.entities.Step
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideDetailScreen(
    instructionId: String,
    onNavigateBack: () -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val instruction by viewModel.getInstructionById(instructionId).collectAsState()
    val steps by viewModel.getStepsForInstruction(instructionId).collectAsState()
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    var currentStepIndex by remember { mutableStateOf(0) }
    val context = androidx.compose.ui.platform.LocalContext.current
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = instruction?.let {
                            if (currentLanguage == LanguageManager.Language.ENGLISH)
                                it.title_en else it.title_sw
                        } ?: "",
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
                    // TTS Toggle
                    var tts: android.speech.tts.TextToSpeech? by remember { mutableStateOf(null) }
                    var isVoiceEnabled by remember { mutableStateOf(false) }
                    
                    DisposableEffect(Unit) {
                        tts = android.speech.tts.TextToSpeech(context) { status ->
                            if (status != android.speech.tts.TextToSpeech.SUCCESS) {
                                isVoiceEnabled = false
                            }
                        }
                        onDispose {
                            tts?.stop()
                            tts?.shutdown()
                        }
                    }
                    
                    // Speak when step changes
                    LaunchedEffect(currentStepIndex, isVoiceEnabled) {
                        if (isVoiceEnabled && steps.isNotEmpty()) {
                            val step = steps[currentStepIndex]
                            val text = if (currentLanguage == LanguageManager.Language.ENGLISH) step.text_en else step.text_sw
                            tts?.language = if (currentLanguage == LanguageManager.Language.ENGLISH) java.util.Locale.ENGLISH else java.util.Locale("sw")
                            tts?.speak(text, android.speech.tts.TextToSpeech.QUEUE_FLUSH, null, null)
                        } else {
                            tts?.stop()
                        }
                    }

                    IconButton(onClick = { isVoiceEnabled = !isVoiceEnabled }) {
                        Icon(
                            imageVector = if (isVoiceEnabled) Icons.Default.VolumeUp else Icons.Default.VolumeOff,
                            contentDescription = "Toggle Voice"
                        )
                    }

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
        if (instruction != null && steps.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Progress indicator
                LinearProgressIndicator(
                    progress = { (currentStepIndex + 1).toFloat() / steps.size.toFloat() },
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primary,
                )
                
                // Description
                Text(
                    text = instruction?.let {
                        if (currentLanguage == LanguageManager.Language.ENGLISH)
                            it.description_en ?: "" else it.description_sw ?: ""
                    } ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

                // CPR Metronome (Only for CPR guides)
                if (instruction?.title_en?.contains("CPR", ignoreCase = true) == true || 
                    instruction?.category == "Critical") {
                    
                    var isMetronomeRunning by remember { mutableStateOf(false) }
                    val scope = rememberCoroutineScope()
                    
                    Button(
                        onClick = {
                            isMetronomeRunning = com.semarescue.android.utils.MetronomeUtils.toggleMetronome(context, scope)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isMetronomeRunning) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(
                            imageVector = if (isMetronomeRunning) Icons.Default.Stop else Icons.Default.PlayArrow,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isMetronomeRunning) {
                                if (currentLanguage == LanguageManager.Language.ENGLISH) "STOP CPR BEAT" else "SIMAMISHA MDUNDO"
                            } else {
                                if (currentLanguage == LanguageManager.Language.ENGLISH) "START CPR BEAT (110 BPM)" else "ANZA MDUNDO WA CPR"
                            }
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(steps) { index, step ->
                        StepCard(
                            step = step,
                            stepNumber = index + 1,
                            currentLanguage = currentLanguage,
                            isActive = index == currentStepIndex,
                            isCompleted = index < currentStepIndex
                        )
                    }
                }
                
                // Navigation buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (currentStepIndex > 0) {
                        OutlinedButton(
                            onClick = { currentStepIndex-- },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Previous"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                if (currentLanguage == LanguageManager.Language.ENGLISH)
                                    "Previous" else "Iliyopita"
                            )
                        }
                    }
                    
                    if (currentStepIndex < steps.size - 1) {
                        Button(
                            onClick = { currentStepIndex++ },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                if (currentLanguage == LanguageManager.Language.ENGLISH)
                                    "Next" else "Ifuatayo"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "Next"
                            )
                        }
                    } else {
                        Button(
                            onClick = onNavigateBack,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Complete"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                if (currentLanguage == LanguageManager.Language.ENGLISH)
                                    "Complete" else "Maliza"
                            )
                        }
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun StepCard(
    step: Step,
    stepNumber: Int,
    currentLanguage: LanguageManager.Language,
    isActive: Boolean,
    isCompleted: Boolean
) {
    var timerSeconds by remember { mutableStateOf(step.timer_seconds) }
    
    LaunchedEffect(isActive, step.timer_seconds) {
        if (isActive && step.timer_seconds != null) {
            timerSeconds = step.timer_seconds
            while (timerSeconds != null && timerSeconds!! > 0) {
                delay(1000)
                timerSeconds = timerSeconds!! - 1
            }
        }
    }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when {
                isActive -> MaterialTheme.colorScheme.primaryContainer
                isCompleted -> MaterialTheme.colorScheme.tertiaryContainer
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isActive) 8.dp else 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = when {
                        isActive -> MaterialTheme.colorScheme.primary
                        isCompleted -> MaterialTheme.colorScheme.tertiary
                        else -> MaterialTheme.colorScheme.outline
                    }
                ) {
                    Box(
                        modifier = Modifier.size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isCompleted) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Completed",
                                tint = MaterialTheme.colorScheme.onTertiary
                            )
                        } else {
                            Text(
                                text = stepNumber.toString(),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (isActive) 
                                    MaterialTheme.colorScheme.onPrimary 
                                else 
                                    MaterialTheme.colorScheme.surface
                            )
                        }
                    }
                }
                
                Text(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                        "Step $stepNumber" else "Hatua ya $stepNumber",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = when {
                        isActive -> MaterialTheme.colorScheme.onPrimaryContainer
                        isCompleted -> MaterialTheme.colorScheme.onTertiaryContainer
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }
            
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                    step.text_en else step.text_sw,
                style = MaterialTheme.typography.bodyLarge,
                color = when {
                    isActive -> MaterialTheme.colorScheme.onPrimaryContainer
                    isCompleted -> MaterialTheme.colorScheme.onTertiaryContainer
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
            
            // Timer display
            AnimatedVisibility(visible = isActive && timerSeconds != null && timerSeconds!! > 0) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = "Timer",
                            tint = MaterialTheme.colorScheme.onSecondary
                        )
                        Text(
                            text = "${timerSeconds}s",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                }
            }
        }
    }
}
