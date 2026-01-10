package com.semarescue.android.ui.screens.library

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.semarescue.android.data.entities.HealthArticle
import com.semarescue.android.data.entities.ArticleType
import com.semarescue.android.data.entities.HealthCategory
import com.semarescue.android.ui.viewmodels.InstructionViewModel
import com.semarescue.android.utils.LanguageManager
import com.semarescue.android.data.getHealthArticles

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HealthLibraryScreen(
    onNavigateBack: () -> Unit,
    viewModel: InstructionViewModel = hiltViewModel()
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    var selectedArticle by remember { mutableStateOf<HealthArticle?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    val allArticles = getHealthArticles()
    val filteredArticles = allArticles.filter { article ->
        val query = searchQuery.lowercase()
        article.titleEn.lowercase().contains(query) || article.titleSw.lowercase().contains(query)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        if (selectedArticle == null) {
                            if (currentLanguage == LanguageManager.Language.ENGLISH) "Health Library" else "Maktaba ya Afya"
                        } else {
                            if (currentLanguage == LanguageManager.Language.ENGLISH) selectedArticle!!.titleEn else selectedArticle!!.titleSw
                        }
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (selectedArticle != null) {
                            selectedArticle = null
                        } else {
                            onNavigateBack()
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            if (selectedArticle == null) {
                Column {
                    // Search Bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        placeholder = { Text(if (currentLanguage == LanguageManager.Language.ENGLISH) "Search conditions..." else "Tafuta magonjwa...") },
                        leadingIcon = { Icon(Icons.Default.Search, null) },
                        shape = MaterialTheme.shapes.medium
                    )

                    val groupedArticles = filteredArticles.groupBy { it.category }

                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        groupedArticles.forEach { (category, articles) ->
                            stickyHeader {
                                CategoryHeader(category, currentLanguage)
                            }
                            items(articles) { article ->
                                HealthArticleCard(
                                    article = article,
                                    currentLanguage = currentLanguage,
                                    onClick = { selectedArticle = article }
                                )
                            }
                        }
                    }
                }
            } else {
                HealthArticleDetail(
                    article = selectedArticle!!,
                    currentLanguage = currentLanguage
                )
            }
        }
    }
}

@Composable
fun HealthArticleCard(
    article: HealthArticle,
    currentLanguage: LanguageManager.Language,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocalHospital,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH) article.titleEn else article.titleSw,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (currentLanguage == LanguageManager.Language.ENGLISH) article.overviewEn else article.overviewSw,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun HealthArticleDetail(
    article: HealthArticle,
    currentLanguage: LanguageManager.Language
) {
    val isEnglish = currentLanguage == LanguageManager.Language.ENGLISH

    fun getTitle(section: String): String {
        return when (article.type) {
            ArticleType.WELLNESS -> when (section) {
                "symptoms" -> if (isEnglish) "Benefits" else "Faida"
                "causes" -> if (isEnglish) "Guidelines" else "Miongozo"
                "prevention" -> if (isEnglish) "Tips" else "Dondoo"
                "treatment" -> if (isEnglish) "Resources" else "Rasilimali"
                else -> ""
            }
            ArticleType.INFO -> when (section) {
                "symptoms" -> if (isEnglish) "Types" else "Aina"
                "causes" -> if (isEnglish) "Compatibility" else "Upatanifu"
                "prevention" -> if (isEnglish) "Importance" else "Umuhimu"
                "treatment" -> if (isEnglish) "Details" else "Maelezo"
                else -> ""
            }
            ArticleType.FIRST_AID -> when (section) {
                "symptoms" -> if (isEnglish) "Signs" else "Dalili"
                "causes" -> if (isEnglish) "Causes" else "Sababu"
                "prevention" -> if (isEnglish) "Prevention" else "Kinga"
                "treatment" -> if (isEnglish) "Steps / Action" else "Hatua / Tendo"
                else -> ""
            }
            else -> when (section) {
                "symptoms" -> if (isEnglish) "Symptoms" else "Dalili"
                "causes" -> if (isEnglish) "Causes" else "Sababu"
                "prevention" -> if (isEnglish) "Prevention" else "Kinga"
                "treatment" -> if (isEnglish) "Treatment / First Aid" else "Matibabu / Huduma ya Kwanza"
                else -> ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Overview
        Section(
            title = if (isEnglish) "Overview" else "Muhtasari",
            content = if (isEnglish) article.overviewEn else article.overviewSw
        )

        // Section 1 (Symptoms / Benefits / Types)
        if (article.symptomsEn.isNotEmpty()) {
            ListSection(
                title = getTitle("symptoms"),
                items = if (isEnglish) article.symptomsEn else article.symptomsSw
            )
        }

        // Section 2 (Causes / Guidelines / Compatibility)
        if (article.causesEn.isNotEmpty()) {
            ListSection(
                title = getTitle("causes"),
                items = if (isEnglish) article.causesEn else article.causesSw
            )
        }

        // Risk Factors (Only for Conditions)
        if (article.riskFactorsEn.isNotEmpty()) {
            ListSection(
                title = if (isEnglish) "Risk Factors" else "Vihatarishi",
                items = if (isEnglish) article.riskFactorsEn else article.riskFactorsSw
            )
        }

        // When to See a Doctor (Only for Conditions)
        if (article.whenToSeeDoctorEn.isNotEmpty()) {
            ListSection(
                title = if (isEnglish) "When to See a Doctor" else "Lini Umuone Daktari",
                items = if (isEnglish) article.whenToSeeDoctorEn else article.whenToSeeDoctorSw
            )
        }

        // Section 3 (Prevention / Tips / Importance)
        if (article.preventionEn.isNotEmpty()) {
            ListSection(
                title = getTitle("prevention"),
                items = if (isEnglish) article.preventionEn else article.preventionSw
            )
        }

        // Section 4 (Treatment / Resources / Details)
        if (article.treatmentEn.isNotEmpty()) {
            ListSection(
                title = getTitle("treatment"),
                items = if (isEnglish) article.treatmentEn else article.treatmentSw
            )
        }
    }
}

@Composable
fun Section(title: String, content: String) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ListSection(title: String, items: List<String>) {
    if (items.isNotEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            items.forEach { item ->
                Row(verticalAlignment = Alignment.Top) {
                    Text("• ", fontWeight = FontWeight.Bold)
                    Text(item, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}



@Composable
fun CategoryHeader(
    category: HealthCategory,
    currentLanguage: LanguageManager.Language
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = if (currentLanguage == LanguageManager.Language.ENGLISH) category.titleEn else category.titleSw,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(16.dp)
        )
    }
}
