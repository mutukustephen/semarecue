package com.semarescue.android.data.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00f1\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\t\u0010:\u001a\u00020\u0016H\u00c6\u0003J\t\u0010;\u001a\u00020\u0018H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\u008f\u0002\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u00c6\u0001J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010H\u001a\u00020IH\u00d6\u0001J\t\u0010J\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001d\u00a8\u0006K"}, d2 = {"Lcom/semarescue/android/data/entities/HealthArticle;", "", "id", "", "titleEn", "titleSw", "overviewEn", "overviewSw", "symptomsEn", "", "symptomsSw", "causesEn", "causesSw", "preventionEn", "preventionSw", "treatmentEn", "treatmentSw", "riskFactorsEn", "riskFactorsSw", "whenToSeeDoctorEn", "whenToSeeDoctorSw", "type", "Lcom/semarescue/android/data/entities/ArticleType;", "category", "Lcom/semarescue/android/data/entities/HealthCategory;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/semarescue/android/data/entities/ArticleType;Lcom/semarescue/android/data/entities/HealthCategory;)V", "getCategory", "()Lcom/semarescue/android/data/entities/HealthCategory;", "getCausesEn", "()Ljava/util/List;", "getCausesSw", "getId", "()Ljava/lang/String;", "getOverviewEn", "getOverviewSw", "getPreventionEn", "getPreventionSw", "getRiskFactorsEn", "getRiskFactorsSw", "getSymptomsEn", "getSymptomsSw", "getTitleEn", "getTitleSw", "getTreatmentEn", "getTreatmentSw", "getType", "()Lcom/semarescue/android/data/entities/ArticleType;", "getWhenToSeeDoctorEn", "getWhenToSeeDoctorSw", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class HealthArticle {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String titleEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String titleSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String overviewEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String overviewSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> symptomsEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> symptomsSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> causesEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> causesSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> preventionEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> preventionSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> treatmentEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> treatmentSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> riskFactorsEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> riskFactorsSw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> whenToSeeDoctorEn = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> whenToSeeDoctorSw = null;
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.entities.ArticleType type = null;
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.entities.HealthCategory category = null;
    
    public HealthArticle(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String titleEn, @org.jetbrains.annotations.NotNull()
    java.lang.String titleSw, @org.jetbrains.annotations.NotNull()
    java.lang.String overviewEn, @org.jetbrains.annotations.NotNull()
    java.lang.String overviewSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> symptomsEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> symptomsSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> causesEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> causesSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> preventionEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> preventionSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> treatmentEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> treatmentSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> riskFactorsEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> riskFactorsSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> whenToSeeDoctorEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> whenToSeeDoctorSw, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.ArticleType type, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.HealthCategory category) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitleEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitleSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOverviewEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOverviewSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSymptomsEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSymptomsSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCausesEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCausesSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPreventionEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPreventionSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTreatmentEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTreatmentSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRiskFactorsEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRiskFactorsSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getWhenToSeeDoctorEn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getWhenToSeeDoctorSw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.entities.ArticleType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.entities.HealthCategory getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.entities.ArticleType component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.entities.HealthCategory component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.entities.HealthArticle copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String titleEn, @org.jetbrains.annotations.NotNull()
    java.lang.String titleSw, @org.jetbrains.annotations.NotNull()
    java.lang.String overviewEn, @org.jetbrains.annotations.NotNull()
    java.lang.String overviewSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> symptomsEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> symptomsSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> causesEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> causesSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> preventionEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> preventionSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> treatmentEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> treatmentSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> riskFactorsEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> riskFactorsSw, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> whenToSeeDoctorEn, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> whenToSeeDoctorSw, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.ArticleType type, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.HealthCategory category) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}