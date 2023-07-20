/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import com.borvalcode.anagram.application.desktop.query
import javafx.scene.control.Labeled
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlin.test.Test
import org.hamcrest.Matcher
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start
import org.testfx.matcher.base.GeneralMatchers
import org.testfx.matcher.control.LabeledMatchers.hasText

private const val A_RESULT_LABEL_ID = "label"

@ExtendWith(ApplicationExtension::class)
class ResultLabelTest {
  private var resultLabel: ResultLabel? = null
  private var contentWindow: ContentWindow? = null

  @Start
  fun onStart(stage: Stage) {
    contentWindow = ContentWindow("Test", 100.0, 100.0, 10.0, 10.0)
    resultLabel = ResultLabel(A_RESULT_LABEL_ID)

    resultLabel!!.addTo(contentWindow!!)

    contentWindow!!.runStage(stage)
  }

  @Test
  fun `Initializes with empty text`() {
    verifyThat(query(A_RESULT_LABEL_ID), hasText(""))
  }

  @Test
  fun `Writes info text`(robot: FxRobot) {
    robot.interact { resultLabel!!.info("Info") }
    verifyThat(query(A_RESULT_LABEL_ID), hasText("Info"))
    verifyThat(query(A_RESULT_LABEL_ID), hasColorText(Color.BLACK))
  }

  @Test
  fun `Writes success text`(robot: FxRobot) {
    robot.interact { resultLabel!!.success("Success") }
    verifyThat(query(A_RESULT_LABEL_ID), hasText("Success"))
    verifyThat(query(A_RESULT_LABEL_ID), hasColorText(Color.GREEN))
  }

  @Test
  fun `Writes error text`(robot: FxRobot) {
    robot.interact { resultLabel!!.error("Error") }
    verifyThat(query(A_RESULT_LABEL_ID), hasText("Error"))
    verifyThat(query(A_RESULT_LABEL_ID), hasColorText(Color.RED))
  }

  private fun hasColorText(color: Color): Matcher<Labeled> {
    val descriptionText = "has color \"$color\""
    return GeneralMatchers.typeSafeMatcher(
        Labeled::class.java,
        descriptionText,
        { labeled: Labeled -> "\"" + labeled.textFill + "\"" }) { labeled: Labeled ->
      color == labeled.textFill
    }
  }
}
