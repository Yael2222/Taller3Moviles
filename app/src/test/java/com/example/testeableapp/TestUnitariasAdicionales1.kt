package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import kotlin.test.Test

class TestUnitariasAdicionales1 {
    @Test
    fun testCalculateTipWithZeroPercentage() {
        val amount = 100.0
        val tipPercent = 0
        val roundUp = false // No importa si es true o false, la propina debe ser 0

        val tip = calculateTip(amount, tipPercent, roundUp)

        assertEquals(0.0, tip, 0.001) // Esperamos 0.0, con una tolerancia de 0.001 para dobles
    }

    @Test
    fun testCalculateTipWithZeroPercentageAndRoundUp() {
        val amount = 75.50
        val tipPercent = 0
        val roundUp = true // Aunque se redondee, ceil(0) sigue siendo 0

        val tip = calculateTip(amount, tipPercent, roundUp)

        assertEquals(0.0, tip, 0.001)
    }
}