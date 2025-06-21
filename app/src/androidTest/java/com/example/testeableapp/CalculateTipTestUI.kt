package com.example.testeableapp

import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performSemanticsAction


class CalculateTipTestUI { //Pruebas UI 1

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun redondearPropina_validaCambioEnResultado() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        // Ingresar monto 90
        composeTestRule.onNodeWithTag("billAmountField").performTextInput("90")

        // Verificar propina sin redondear (15% = 13,50)
        composeTestRule.onNodeWithTag("tipAmountText")
            .assertTextEquals("Propina: $13,50")

        // Marcar checkbox de redondear propina
        composeTestRule.onNodeWithTag("roundUpCheckbox").performClick()

        // Verificar propina redondeada (15% = 14,00)
        composeTestRule.onNodeWithTag("tipAmountText")
            .assertTextEquals("Propina: $14,00")
        // Pasa pruena
    }

    @Test
    fun cambiarPorcentajeDeSlider_verificaCalculo() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        // Ingresar monto 100
        composeTestRule.onNodeWithTag("billAmountField").performTextInput("100")

        // Mover el slider o simular un cambio visual: por ejemplo mover a 20%
        composeTestRule.onNodeWithText("Porcentaje de propina: 15%").assertExists()

        // Aquí solo validamos el cambio de resultado manual:
        composeTestRule.onNodeWithTag("tipPercentageSlider")
            .performTouchInput { swipeRight() }

        // Verifica que la propina haya cambiado (ya no sea 15.00)
        composeTestRule.onNodeWithTag("tipAmountText").assert(hasText("Propina: $15,00").not())
        // Pasa pruena
    }

    @Test
    fun cambiarPorcentajeDeSlider_verificaCalculo_en_20y10porciento() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        // Ingresar monto 100
        composeTestRule.onNodeWithTag("billAmountField").performTextInput("100")

        // Mover el slider a 20%
        composeTestRule.onNodeWithTag("tipPercentageSlider")
            .performSemanticsAction(SemanticsActions.SetProgress) { it(20f) }

        // Verificar que el texto del porcentaje sea 20%
        composeTestRule.onNodeWithText("Porcentaje de propina: 20%").assertIsDisplayed()

        // Verificar que la propina sea $20,00
        composeTestRule.onNodeWithText("Propina: $20,00").assertIsDisplayed()

        // Mover el slider a 10%
        composeTestRule.onNodeWithTag("tipPercentageSlider")
            .performSemanticsAction(SemanticsActions.SetProgress) { it(10f) }

        // Verificar que el texto del porcentaje sea 10%
        composeTestRule.onNodeWithText("Porcentaje de propina: 10%").assertIsDisplayed()

        // Verificar que la propina sea $20,00
        composeTestRule.onNodeWithText("Propina: $10,00").assertIsDisplayed()
        // Pasa pruena
    }

    @Test
    fun verificarElementosVisiblesEnPantalla() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        // Verifica que el campo del monto está presente
        composeTestRule.onNodeWithTag("billAmountField").assertIsDisplayed()

        // Verifica que el slider esté presente
        composeTestRule.onNodeWithTag("tipPercentageSlider").assertIsDisplayed()

        // Verifica que el texto del número de personas está presente
        composeTestRule.onNodeWithTag("numberOfPeopleText").assertIsDisplayed()
        // Pasa pruena
    }
}
