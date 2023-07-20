/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import com.borvalcode.anagram.application.desktop.query
import com.borvalcode.anagram.application.desktop.writeToTextField
import io.kotest.matchers.shouldBe
import javafx.stage.Stage
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start
import org.testfx.matcher.control.TextInputControlMatchers.hasText

private const val A_PHRASE_TEXT_FIELD_ID = "text"

@ExtendWith(ApplicationExtension::class)
class PhraseTextFieldTest {
  private var phraseTextField: PhraseTextField? = null

  private var contentWindow: ContentWindow? = null

  @Start
  fun onStart(stage: Stage) {
    contentWindow = ContentWindow("Test", 100.0, 100.0, 10.0, 10.0)
    phraseTextField = PhraseTextField(A_PHRASE_TEXT_FIELD_ID)

    phraseTextField!!.addTo(contentWindow!!)

    contentWindow!!.runStage(stage)
  }

  @Test
  fun `Initializes empty`() {
    verifyThat(query(A_PHRASE_TEXT_FIELD_ID), hasText(""))
  }

  @Test
  fun `Updates text when written`(robot: FxRobot) {
    robot.interact { robot.writeToTextField(query(A_PHRASE_TEXT_FIELD_ID), "FOO") }

    verifyThat(query(A_PHRASE_TEXT_FIELD_ID), hasText("FOO"))
    phraseTextField!!.text shouldBe "FOO"
  }

  @Test
  fun `Runs callback when clicked`(robot: FxRobot) {
    var clicked = false
    phraseTextField!!.onChange { clicked = true }

    robot.interact { robot.writeToTextField(query(A_PHRASE_TEXT_FIELD_ID), "FOO") }

    clicked shouldBe true
  }
}
