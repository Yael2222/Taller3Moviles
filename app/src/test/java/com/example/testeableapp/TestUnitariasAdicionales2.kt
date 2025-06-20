package com.example.testeableapp
import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.ceil
class TestUnitariasAdicionales2 {
    @Test
    fun testCalculateTipWithMultipleDecimalsAndRoundUp() {
        val amount = 10.0 // Monto de la cuenta
        val tipPercent = 12 // 12% de propina
        val roundUp = true

        // Cálculo esperado sin redondeo: 10.0 * 0.12 = 1.2
        // Cálculo esperado con redondeo (ceil): ceil(1.2) = 2.0
        val tip = calculateTip(amount, tipPercent, roundUp)

        // Assert
        assertEquals(2.0, tip, 0.001)
    }

    @Test
    fun testCalculateTipWithAnotherDecimalCaseAndRoundUp() {

        val amount = 25.0 // Monto de la cuenta
        val tipPercent = 7 // 7% de propina
        val roundUp = true


        // Cálculo esperado sin redondeo: 25.0 * 0.07 = 1.75
        // Cálculo esperado con redondeo (ceil): ceil(1.75) = 2.0
        val tip = calculateTip(amount, tipPercent, roundUp)

        assertEquals(2.0, tip, 0.001)
    }
}