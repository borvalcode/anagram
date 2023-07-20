/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.testfx.api.FxRobot

fun FxRobot.writeToTextField(query: String, text: String) {
  val textField = lookup(query).query<TextField>()
  textField.requestFocus()
  clickOn(textField).write(text)
}

fun FxRobot.clickOnCheckBox(query: String) {
  val checkBox = lookup(query).query<CheckBox>()
  checkBox.requestFocus()
  checkBox.fire()
}

fun query(id: String): String = "#$id"
