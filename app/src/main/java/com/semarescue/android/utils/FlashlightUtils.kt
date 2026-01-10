package com.semarescue.android.utils

import android.content.Context
import android.hardware.camera2.CameraManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

object FlashlightUtils {
    private var strobeJob: Job? = null
    private var isFlashlightOn = false

    fun toggleStrobe(context: Context, scope: CoroutineScope) {
        if (strobeJob?.isActive == true) {
            stopStrobe(context)
        } else {
            startStrobe(context, scope)
        }
    }

    private fun startStrobe(context: Context, scope: CoroutineScope) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList.firstOrNull { id ->
            cameraManager.getCameraCharacteristics(id)
                .get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        } ?: return

        strobeJob = scope.launch(Dispatchers.IO) {
            val dot = 200L
            val dash = 600L
            val gap = 200L
            val letterGap = 600L
            val wordGap = 1400L

            try {
                while (isActive) {
                    // S (...)
                    repeat(3) {
                        cameraManager.setTorchMode(cameraId, true)
                        delay(dot)
                        cameraManager.setTorchMode(cameraId, false)
                        delay(gap)
                    }
                    delay(letterGap - gap)

                    // O (---)
                    repeat(3) {
                        cameraManager.setTorchMode(cameraId, true)
                        delay(dash)
                        cameraManager.setTorchMode(cameraId, false)
                        delay(gap)
                    }
                    delay(letterGap - gap)

                    // S (...)
                    repeat(3) {
                        cameraManager.setTorchMode(cameraId, true)
                        delay(dot)
                        cameraManager.setTorchMode(cameraId, false)
                        delay(gap)
                    }
                    
                    delay(wordGap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    cameraManager.setTorchMode(cameraId, false)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun stopStrobe(context: Context) {
        strobeJob?.cancel()
        strobeJob = null
        
        // Ensure flashlight is off
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList.firstOrNull { id ->
            cameraManager.getCameraCharacteristics(id)
                .get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        } ?: return
        
        try {
            cameraManager.setTorchMode(cameraId, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
