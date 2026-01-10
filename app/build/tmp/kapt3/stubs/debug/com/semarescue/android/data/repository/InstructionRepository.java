package com.semarescue.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/semarescue/android/data/repository/InstructionRepository;", "", "instructionDao", "Lcom/semarescue/android/data/dao/InstructionDao;", "(Lcom/semarescue/android/data/dao/InstructionDao;)V", "getAllInstructions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/semarescue/android/data/entities/Instruction;", "getInstructionById", "id", "", "getStepsForInstruction", "Lcom/semarescue/android/data/entities/Step;", "instructionId", "app_debug"})
public final class InstructionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.dao.InstructionDao instructionDao = null;
    
    public InstructionRepository(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.dao.InstructionDao instructionDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.semarescue.android.data.entities.Instruction>> getAllInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.semarescue.android.data.entities.Instruction> getInstructionById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.semarescue.android.data.entities.Step>> getStepsForInstruction(@org.jetbrains.annotations.NotNull()
    java.lang.String instructionId) {
        return null;
    }
}