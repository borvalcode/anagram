/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import javafx.scene.control.Label
import javafx.scene.paint.Color

class ResultLabel(id: String) {
    private val label: Label = Label().also { it.id = id }

    fun addTo(contentWindow: ContentWindow) {
        contentWindow.add(label)
    }

    fun success(text: String) {
        label.text = text
        label.textFill = Color.GREEN
    }

    fun error(text: String) {
        label.text = text
        label.textFill = Color.RED
    }

    fun info(text: String) {
        label.text = text
        label.textFill = Color.BLACK
    }
}
