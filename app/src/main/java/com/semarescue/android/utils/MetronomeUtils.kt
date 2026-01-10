package com.semarescue.android.utils

import android.media.AudioAttributes
import android.media.SoundPool
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

object MetronomeUtils {
    private var metronomeJob: Job? = null

    fun toggleMetronome(context: android.content.Context, scope: CoroutineScope): Boolean {
        return if (metronomeJob?.isActive == true) {
            stopMetronome()
            false
        } else {
            startMetronome(context, scope)
            true
        }
    }

    private fun startMetronome(context: android.content.Context, scope: CoroutineScope) {
        val toneGenerator = android.media.ToneGenerator(android.media.AudioManager.STREAM_ALARM, 100)
        val vibrator = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(android.content.Context.VIBRATOR_MANAGER_SERVICE) as android.os.VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(android.content.Context.VIBRATOR_SERVICE) as android.os.Vibrator
        }
        
        metronomeJob = scope.launch(Dispatchers.IO) {
            try {
                while (isActive) {
                    toneGenerator.startTone(android.media.ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 100)
                    
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        vibrator.vibrate(android.os.VibrationEffect.createOneShot(50, android.os.VibrationEffect.DEFAULT_AMPLITUDE))
                    } else {
                        @Suppress("DEPRECATION")
                        vibrator.vibrate(50)
                    }
                    
                    delay(545) // ~110 BPM
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                toneGenerator.release()
            }
        }
    }

    fun stopMetronome() {
        metronomeJob?.cancel()
        metronomeJob = null
    }
    
    fun isRunning(): Boolean {
        return metronomeJob?.isActive == true
    }
}
