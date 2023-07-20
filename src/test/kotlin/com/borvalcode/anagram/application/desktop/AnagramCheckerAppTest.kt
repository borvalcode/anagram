/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop

import javafx.stage.Stage
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start
import org.testfx.matcher.control.LabeledMatchers.hasText
import org.testfx.matcher.control.TextInputControlMatchers

@ExtendWith(ApplicationExtension::class)
class AnagramCheckerAppTest {

  @Start
  fun onStart(stage: Stage) {
    val app = AnagramCheckerApp()

    app.start(stage)
  }

  @Test
  fun `everything is there`() {
    verifyThat("#subject", TextInputControlMatchers.hasText(""))
    verifyThat("#anagram-candidate", TextInputControlMatchers.hasText(""))
    verifyThat("#result", hasText("Check if two texts are anagrams of each other"))
    verifyThat("#include-numbers", hasText("Include numbers"))
  }

  @Test
  fun `When writing two anagrams in both text fields, show Success label`(robot: FxRobot) {
    robot.interact {
      robot.writeToTextField("#subject", "Halo22")
      robot.writeToTextField("#anagram-candidate", "Hola23")
    }

    verifyThat("#result", hasText("Anagrams!"))
  }

  @Test
  fun `When writing two not anagrams in both text fields, show Error label`(robot: FxRobot) {
    robot.interact {
      robot.writeToTextField("#subject", "FOO")
      robot.writeToTextField("#anagram-candidate", "BAR")
    }

    verifyThat("#result", hasText("Not Anagrams!"))
  }

  @Test
  fun `When writing two anagrams including numbers in both text fields, show Success label`(
      robot: FxRobot
  ) {
    robot.interact {
      robot.clickOnCheckBox("#include-numbers")
      robot.writeToTextField("#subject", "Halo23")
      robot.writeToTextField("#anagram-candidate", "Hola23")
    }

    verifyThat("#result", hasText("Anagrams!"))
  }

  @Test
  fun `When writing two not anagrams including numbers in both text fields, show Error label`(
      robot: FxRobot
  ) {
    robot.interact {
      robot.clickOnCheckBox("#include-numbers")
      robot.writeToTextField("#subject", "Halo22")
      robot.writeToTextField("#anagram-candidate", "Hola23")
    }

    verifyThat("#result", hasText("Not Anagrams!"))
  }
}
