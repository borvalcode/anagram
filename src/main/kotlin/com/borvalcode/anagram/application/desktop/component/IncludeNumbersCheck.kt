/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import javafx.scene.control.CheckBox

class IncludeNumbersCheck internal constructor(id: String, text: String) {
    private val checkBox: CheckBox = CheckBox(text).also { it.id = id }

    val selected: Boolean
        get() = checkBox.isSelected

    fun addTo(contentWindow: ContentWindow) {
        contentWindow.add(checkBox)
    }

    fun onChange(listener: () -> Unit) {
        checkBox.setOnAction { listener() }
    }
}
