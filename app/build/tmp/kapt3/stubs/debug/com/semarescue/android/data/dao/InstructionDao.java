package com.semarescue.android.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\u0006\u0010\u000e\u001a\u00020\bH\'J\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/semarescue/android/data/dao/InstructionDao;", "", "getAllInstructions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/semarescue/android/data/entities/Instruction;", "getInstruction", "id", "", "getInstructionCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStepsForInstruction", "Lcom/semarescue/android/data/entities/Step;", "instructionId", "insertInstructions", "", "instructions", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSteps", "steps", "app_debug"})
@androidx.room.Dao()
public abstract interface InstructionDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertInstructions(@org.jetbrains.annotations.NotNull()
    java.util.List<com.semarescue.android.data.entities.Instruction> instructions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSteps(@org.jetbrains.annotations.NotNull()
    java.util.List<com.semarescue.android.data.entities.Step> steps, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM instructions")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.semarescue.android.data.entities.Instruction>> getAllInstructions();
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM instructions WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.semarescue.android.data.entities.Instruction> getInstruction(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Query(value = "SELECT * FROM steps WHERE instruction_id = :instructionId ORDER BY step_number ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.semarescue.android.data.entities.Step>> getStepsForInstruction(@org.jetbrains.annotations.NotNull()
    java.lang.String instructionId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM instructions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInstructionCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}