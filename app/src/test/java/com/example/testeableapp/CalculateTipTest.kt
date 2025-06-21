package com.example.testeableapp

import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.testeableapp.ui.Screens.calculateTip

class CalculateTipTest { //Pruebas unitarias 1
    @Test
    fun calcularPropinaCon37porcientoYRedondeo() {
        val resultado = calculateTip(101.0, 37, true)
        assertEquals(38.0, resultado, 0.0)
        // roundUP = true redondea al entero proximo más alto
        // Pasa pruena
    }

    @Test
    fun calcularPropinaConMontoNegativo_retornaCero() {
        val resultado = calculateTip(-50.0, 20, false)
        assertEquals(0.0, resultado, 0.0)
        // NO pasa pruena, devuelve un valor negativo en lugar de 0 (-10)
    }

    @Test
    fun calcularTotalPorPersonaCorrectamente() {
        val bill = 120.0
        val tip = calculateTip(bill, 20, false) // 24
        val totalPerPerson = (bill + tip) / 3 // = 48
        assertEquals(48.0, totalPerPerson, 0.0)
        // Pasa pruena
    }
}