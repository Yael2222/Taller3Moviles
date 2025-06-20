import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test
import java.text.DecimalFormat

class TestUiAdicionales2 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInvalidBillAmountInput() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithText("Monto de la cuenta")
            .performTextInput("abcde")


        val df = DecimalFormat("0.00")

        composeTestRule.onNodeWithText("Propina: $${df.format(0.00)}")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Total por persona: $${df.format(0.00)}")
            .assertIsDisplayed()

        val billAmountTextField = composeTestRule.onNodeWithText("Monto de la cuenta")

        billAmountTextField.performTextClearance()

        billAmountTextField.performTextInput("123.45.67") 

        composeTestRule.onNodeWithText("Propina: $${df.format(0.00)}")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("Total por persona: $${df.format(0.00)}")
            .assertIsDisplayed()
    }
}