package com.semarescue.android.data.entities

data class HealthArticle(
    val id: String,
    val titleEn: String,
    val titleSw: String,
    val overviewEn: String,
    val overviewSw: String,
    val symptomsEn: List<String>,
    val symptomsSw: List<String>,
    val causesEn: List<String>,
    val causesSw: List<String>,
    val preventionEn: List<String>,
    val preventionSw: List<String>,
    val treatmentEn: List<String>,
    val treatmentSw: List<String>,
    val riskFactorsEn: List<String> = emptyList(),
    val riskFactorsSw: List<String> = emptyList(),
    val whenToSeeDoctorEn: List<String> = emptyList(),
    val whenToSeeDoctorSw: List<String> = emptyList(),
    val type: ArticleType = ArticleType.CONDITION,
    val category: HealthCategory = HealthCategory.GENERAL
)

enum class ArticleType {
    CONDITION,
    WELLNESS,
    INFO,
    FIRST_AID
}

enum class HealthCategory(val titleEn: String, val titleSw: String) {
    EMERGENCIES("Emergencies", "Dharura"),
    INFECTIOUS("Infectious Diseases", "Magonjwa ya Kuambukiza"),
    RESPIRATORY("Respiratory Conditions", "Magonjwa ya Mfumo wa Hewa"),
    CHRONIC("Chronic Conditions", "Magonjwa Sugu"),
    DIGESTIVE("Digestive Issues", "Matatizo ya Mmeng'enyo"),
    SKIN("Skin Conditions", "Magonjwa ya Ngozi"),
    MENTAL("Mental Health", "Afya ya Akili"),
    REPRODUCTIVE("Reproductive Health", "Afya ya Uzazi"),
    PEDIATRIC("Pediatric Conditions", "Magonjwa ya Watoto"),
    EYE_EAR("Eye & Ear", "Macho na Masikio"),
    BITES("Bites & Stings", "Kung'atwa na Wadudu/Wanyama"),
    ENVIRONMENTAL("Environmental", "Mazingira"),
    NUTRITION("Nutrition", "Lishe"),
    WELLNESS("Wellness", "Ustawi"),
    BODY_INFO("Body Information", "Taarifa za Mwili"),
    GENERAL("General Health", "Afya kwa Ujumla")
}
