package com.semarescue.android.ui.screens.tools

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    onNavigateBack: () -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    
    // State to track if a category is selected
    var selectedCategory by remember { mutableStateOf<QuizCategory?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        if (selectedCategory == null) {
                            if (currentLanguage == LanguageManager.Language.ENGLISH) "Select Quiz Category" else "Chagua Aina ya Maswali"
                        } else {
                            if (currentLanguage == LanguageManager.Language.ENGLISH) selectedCategory!!.nameEn else selectedCategory!!.nameSw
                        }
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (selectedCategory != null) {
                            selectedCategory = null // Go back to category selection
                        } else {
                            onNavigateBack() // Go back to home
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            if (selectedCategory == null) {
                CategorySelectionList(
                    currentLanguage = currentLanguage,
                    onCategorySelected = { selectedCategory = it }
                )
            } else {
                QuizSession(
                    category = selectedCategory!!,
                    currentLanguage = currentLanguage,
                    onQuizCompleted = { selectedCategory = null } // Return to categories on completion
                )
            }
        }
    }
}

@Composable
fun CategorySelectionList(
    currentLanguage: LanguageManager.Language,
    onCategorySelected: (QuizCategory) -> Unit
) {
    val categories = getQuizCategories()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            Card(
                onClick = { onCategorySelected(category) },
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Icon(
                        imageVector = category.icon,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH) category.nameEn else category.nameSw,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${category.questions.size} ${if (currentLanguage == LanguageManager.Language.ENGLISH) "Questions" else "Maswali"}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuizSession(
    category: QuizCategory,
    currentLanguage: LanguageManager.Language,
    onQuizCompleted: () -> Unit
) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }
    
    val questions = category.questions

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!showResult) {
            // Quiz Progress
            LinearProgressIndicator(
                progress = (currentQuestionIndex + 1) / questions.size.toFloat(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Question
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH)
                    questions[currentQuestionIndex].questionEn else questions[currentQuestionIndex].questionSw,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Options
            questions[currentQuestionIndex].optionsEn.forEachIndexed { index, optionEn ->
                val optionText = if (currentLanguage == LanguageManager.Language.ENGLISH)
                    optionEn else questions[currentQuestionIndex].optionsSw[index]
                
                OutlinedButton(
                    onClick = {
                        selectedAnswer = index
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedAnswer == index) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
                    )
                ) {
                    Text(
                        text = optionText,
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (selectedAnswer == index) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (selectedAnswer == questions[currentQuestionIndex].correctAnswerIndex) {
                        score++
                    }
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                        selectedAnswer = null
                    } else {
                        showResult = true
                    }
                },
                enabled = selectedAnswer != null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Next" else "Ifuatayo")
            }
        } else {
            // Result Screen
            Icon(
                imageVector = Icons.Default.EmojiEvents,
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = if (currentLanguage == LanguageManager.Language.ENGLISH) "Quiz Completed!" else "Umemaliza Maswali!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${if (currentLanguage == LanguageManager.Language.ENGLISH) "Score" else "Alama"}: $score / ${questions.size}",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            if (score == questions.size) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.CheckCircle, null, tint = MaterialTheme.colorScheme.onTertiaryContainer)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = if (currentLanguage == LanguageManager.Language.ENGLISH) 
                                "Perfect Score! You know your stuff." 
                                else "Alama Kamili! Unajua mambo yako.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Button(
                onClick = {
                    currentQuestionIndex = 0
                    score = 0
                    showResult = false
                    selectedAnswer = null
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Retake Quiz" else "Rudia Maswali")
            }
            
            OutlinedButton(
                onClick = onQuizCompleted,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Choose Another Category" else "Chagua Aina Nyingine")
            }
        }
    }
}

data class QuizCategory(
    val nameEn: String,
    val nameSw: String,
    val icon: ImageVector,
    val questions: List<QuizQuestion>
)

data class QuizQuestion(
    val questionEn: String,
    val questionSw: String,
    val optionsEn: List<String>,
    val optionsSw: List<String>,
    val correctAnswerIndex: Int
)

fun getQuizCategories(): List<QuizCategory> {
    return listOf(
        QuizCategory(
            "CPR & Basics", "CPR & Misingi", Icons.Default.HealthAndSafety,
            listOf(
                QuizQuestion(
                    "What is the first step in CPR?",
                    "Hatua ya kwanza katika CPR ni nini?",
                    listOf("Check for danger", "Call 999", "Start compressions", "Give rescue breaths"),
                    listOf("Angalia hatari", "Piga 999", "Anza kubonyeza kifua", "Toa pumzi ya uokoaji"),
                    0
                ),
                QuizQuestion(
                    "What is the compression rate for CPR?",
                    "Kasi ya kubonyeza kifua katika CPR ni ipi?",
                    listOf("60-80 bpm", "80-100 bpm", "100-120 bpm", "120-140 bpm"),
                    listOf("60-80 bpm", "80-100 bpm", "100-120 bpm", "120-140 bpm"),
                    2
                ),
                QuizQuestion(
                    "How deep should chest compressions be for an adult?",
                    "Kifua kinapaswa kubonyezwa kwa kina gani kwa mtu mzima?",
                    listOf("1-2 cm", "5-6 cm", "8-10 cm", "As deep as possible"),
                    listOf("1-2 cm", "5-6 cm", "8-10 cm", "Kwa kina iwezekanavyo"),
                    1
                ),
                QuizQuestion(
                    "What is the ratio of compressions to breaths?",
                    "Uwiano wa kubonyeza na kupumua ni upi?",
                    listOf("15:2", "30:2", "30:1", "15:1"),
                    listOf("15:2", "30:2", "30:1", "15:1"),
                    1
                ),
                QuizQuestion(
                    "When should you stop CPR?",
                    "Lini unapaswa kuacha CPR?",
                    listOf("When tired", "After 5 minutes", "When help arrives or signs of life return", "When the casualty vomits"),
                    listOf("Ukichoka", "Baada ya dakika 5", "Msaada ukifika au dalili za uhai zikirudi", "Mgonjwa akitapika"),
                    2
                ),
                QuizQuestion(
                    "What is the correct hand placement for CPR?",
                    "Wapi unapaswa kuweka mikono kwa CPR?",
                    listOf("Left side of chest", "Center of chest", "Stomach", "Neck"),
                    listOf("Upande wa kushoto wa kifua", "Katikati ya kifua", "Tumboni", "Shingoni"),
                    1
                )
            )
        ),
        QuizCategory(
            "Bleeding & Wounds", "Kutokwa na Damu", Icons.Default.WaterDrop,
            listOf(
                QuizQuestion(
                    "What is the best way to stop severe bleeding?",
                    "Njia bora ya kuzuia kutokwa na damu nyingi ni ipi?",
                    listOf("Apply direct pressure", "Wash with water", "Apply butter", "Use a tourniquet immediately"),
                    listOf("Bonyeza moja kwa moja", "Osha na maji", "Paka siagi", "Tumia kamba ya kukaza mara moja"),
                    0
                ),
                QuizQuestion(
                    "Should you remove an object embedded in a wound?",
                    "Je, unapaswa kuondoa kitu kilichokwama kwenye jeraha?",
                    listOf("Yes, always", "No, never", "Only if it's small", "Only if it's metal"),
                    listOf("Ndiyo, kila wakati", "Hapana, kamwe", "Tu ikiwa ni kidogo", "Tu ikiwa ni chuma"),
                    1
                ),
                QuizQuestion(
                    "How should you treat a nosebleed?",
                    "Unapaswa kutibu vipi damu ya pua?",
                    listOf("Tilt head back", "Tilt head forward and pinch", "Lie down flat", "Blow nose hard"),
                    listOf("Inamisha kichwa nyuma", "Inamisha mbele na kubana", "Lala chali", "Piga kamasi kwa nguvu"),
                    1
                ),
                QuizQuestion(
                    "What indicates arterial bleeding?",
                    "Nini kinaashiria kutokwa na damu ya ateri?",
                    listOf("Slow oozing dark blood", "Spurting bright red blood", "Blue blood", "Clotted blood"),
                    listOf("Damu nyeusi inayotoka polepole", "Damu nyekundu inayoruka kwa kasi", "Damu ya bluu", "Damu iliyoganda"),
                    1
                )
            )
        ),
        QuizCategory(
            "Burns & Scalds", "Kuungua", Icons.Default.LocalFireDepartment,
            listOf(
                QuizQuestion(
                    "What is the first thing to do for a minor burn?",
                    "Jambo la kwanza kufanya kwa kuungua kidogo ni nini?",
                    listOf("Apply ice", "Apply butter", "Cool with running water", "Cover with bandage"),
                    listOf("Weka barafu", "Paka siagi", "Poza na maji yanayotiririka", "Funika na bendeji"),
                    2
                ),
                QuizQuestion(
                    "How long should you cool a burn with water?",
                    "Unapaswa kupoza jeraha la moto kwa muda gani?",
                    listOf("1 minute", "5 minutes", "At least 10-20 minutes", "Until it stops hurting"),
                    listOf("Dakika 1", "Dakika 5", "Angalau dakika 10-20", "Mpaka iache kuuma"),
                    2
                ),
                QuizQuestion(
                    "Should you burst blisters from a burn?",
                    "Je, unapaswa kutumbua malengelenge ya moto?",
                    listOf("Yes, to drain fluid", "No, it increases infection risk", "Only if large", "Only if painful"),
                    listOf("Ndiyo, kutoa maji", "Hapana, inaongeza hatari ya maambukizi", "Tu ikiwa ni kubwa", "Tu ikiwa inauma"),
                    1
                ),
                QuizQuestion(
                    "What should you NOT put on a burn?",
                    "Nini hupaswi kuweka kwenye kidonda cha moto?",
                    listOf("Cool water", "Sterile bandage", "Adhesive lotions or oils", "Clean cloth"),
                    listOf("Maji baridi", "Bendeji safi", "Losheni au mafuta", "Kitambaa safi"),
                    2
                )
            )
        ),
        QuizCategory(
            "Choking", "Kukabwa", Icons.Default.MedicalServices,
            listOf(
                QuizQuestion(
                    "What is the universal sign for choking?",
                    "Ishara ya kimataifa ya kukabwa ni ipi?",
                    listOf("Coughing loudly", "Hands clutching the throat", "Waving hands", "Pointing to mouth"),
                    listOf("Kukohoa kwa sauti", "Kushika koo kwa mikono", "Kupunga mikono", "Kunyooshea mdomo"),
                    1
                ),
                QuizQuestion(
                    "What should you do for a conscious choking adult?",
                    "Ufanye nini kwa mtu mzima anayekabwa na ana fahamu?",
                    listOf("Give water", "Back blows and abdominal thrusts", "CPR", "Lay them down"),
                    listOf("Mpe maji", "Piga mgongoni na kubonyeza tumbo", "CPR", "Mlalisha chini"),
                    1
                ),
                QuizQuestion(
                    "If a choking victim becomes unconscious, what do you do?",
                    "Ikiwa mtu anayekabwa atapoteza fahamu, ufanye nini?",
                    listOf("Wait for help", "Start CPR", "Continue back blows", "Shake them"),
                    listOf("Subiri msaada", "Anza CPR", "Endelea kupiga mgongoni", "Mtikise"),
                    1
                ),
                QuizQuestion(
                    "Can you perform abdominal thrusts on yourself?",
                    "Je, unaweza kujifanyia 'abdominal thrusts' mwenyewe?",
                    listOf("No, impossible", "Yes, using a chair back", "Only if lying down", "Only with water"),
                    listOf("Hapana, haiwezekani", "Ndiyo, kwa kutumia mgongo wa kiti", "Tu ukilala chini", "Tu na maji"),
                    1
                )
            )
        )
    )
}
