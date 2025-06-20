package com.example.testeableapp
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.runner.RunWith
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test
import java.text.DecimalFormat

@RunWith(AndroidJUnit4::class)
class TestUiAdicionales1 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNumberOfPeopleButtonsAtLimits() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithText("Monto de la cuenta")
            .performTextInput("100")


        composeTestRule.onNodeWithText("-")
            .performClick()

        composeTestRule.onNodeWithText("Número de personas: 1")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("-")
            .performClick()

        composeTestRule.onNodeWithText("Número de personas: 1")
            .assertIsDisplayed()


        composeTestRule.onNodeWithText("+")
            .performClick()

        composeTestRule.onNodeWithText("Número de personas: 2")
            .assertIsDisplayed()

        val df = DecimalFormat("0.00")
        composeTestRule.onNodeWithText("Total por persona: $${df.format(57.50)}")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("+")
            .performClick()

        composeTestRule.onNodeWithText("Número de personas: 3")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Total por persona: $${df.format(38.33)}")
            .assertIsDisplayed()
    }
}