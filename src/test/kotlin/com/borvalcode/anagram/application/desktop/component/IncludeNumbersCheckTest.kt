/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import com.borvalcode.anagram.application.desktop.clickOnCheckBox
import com.borvalcode.anagram.application.desktop.query
import io.kotest.matchers.shouldBe
import javafx.scene.control.CheckBox
import javafx.stage.Stage
import org.hamcrest.Matcher
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start
import org.testfx.matcher.base.GeneralMatchers
import org.testfx.matcher.control.LabeledMatchers.hasText

private const val A_CHECKBOX_ID = "check"
private const val A_CHECKBOX_TEXT = "Checkbox"

@ExtendWith(ApplicationExtension::class)
class IncludeNumbersCheckTest {
  private var includeNumbersCheck: IncludeNumbersCheck? = null
  private var contentWindow: ContentWindow? = null

  @Start
  fun onStart(stage: Stage) {
    contentWindow = ContentWindow("Test", 100.0, 100.0, 10.0, 10.0)
    includeNumbersCheck = IncludeNumbersCheck(A_CHECKBOX_ID, A_CHECKBOX_TEXT)

    includeNumbersCheck!!.addTo(contentWindow!!)

    contentWindow!!.runStage(stage)
  }

  @Test
  fun `Initializes with given text and non selected`() {
    verifyThat(query(A_CHECKBOX_ID), hasText(A_CHECKBOX_TEXT))
    verifyThat(query(A_CHECKBOX_ID), isNotSelected())
    includeNumbersCheck!!.selected shouldBe false
  }

  @Test
  fun `On check is selected`(robot: FxRobot) {
    robot.interact { robot.clickOnCheckBox(query(A_CHECKBOX_ID)) }

    verifyThat(query(A_CHECKBOX_ID), isSelected())
    includeNumbersCheck!!.selected shouldBe true
  }

  @Test
  fun `On double check is non selected`(robot: FxRobot) {
    robot.interact {
      robot.clickOnCheckBox(query(A_CHECKBOX_ID))
      robot.clickOnCheckBox(query(A_CHECKBOX_ID))
    }
    verifyThat(query(A_CHECKBOX_ID), isNotSelected())
    includeNumbersCheck!!.selected shouldBe false
  }

  @Test
  fun `Runs callback when clicked`(robot: FxRobot) {
    var clicked = false
    includeNumbersCheck!!.onChange { clicked = true }

    robot.interact { robot.clickOnCheckBox(query(A_CHECKBOX_ID)) }

    clicked shouldBe true
  }

  private fun isSelected(): Matcher<CheckBox> {
    val descriptionText = "is selected"
    return GeneralMatchers.typeSafeMatcher(
        CheckBox::class.java,
        descriptionText,
        { checkBox: CheckBox -> "\"" + checkBox.isSelected + "\"" }) { checkBox: CheckBox ->
      checkBox.isSelected
    }
  }

  private fun isNotSelected(): Matcher<CheckBox> {
    val descriptionText = "is not selected"
    return GeneralMatchers.typeSafeMatcher(
        CheckBox::class.java,
        descriptionText,
        { checkBox: CheckBox -> "\"" + checkBox.isSelected + "\"" }) { checkBox: CheckBox ->
      !checkBox.isSelected
    }
  }
}
