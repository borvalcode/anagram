/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import com.borvalcode.anagram.application.desktop.query
import javafx.scene.control.Label
import javafx.stage.Stage
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxAssert.verifyThat
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start
import org.testfx.matcher.control.LabeledMatchers.hasText

@ExtendWith(ApplicationExtension::class)
class ContentWindowTest {
  private var contentWindow: ContentWindow? = null

  @Start
  fun onStart(stage: Stage) {
    contentWindow = ContentWindow("Test", 100.0, 100.0, 10.0, 10.0)

    contentWindow!!.runStage(stage)
  }

  @Test
  fun `adds a node to the layout`(robot: FxRobot) {
    val aLabel = Label("FOO")
    val labelId = "label-id"
    aLabel.id = labelId

    robot.interact { contentWindow!!.add(aLabel) }

    verifyThat(query(labelId), hasText("FOO"))
  }
}
