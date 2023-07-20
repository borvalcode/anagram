/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import javafx.scene.control.TextField

class PhraseTextField(id: String) {
    private val textField = TextField().also { it.id = id }

    val text: String
        get() = textField.text

    fun addTo(contentWindow: ContentWindow) {
        contentWindow.add(textField)
    }

    fun onChange(listener: () -> Unit) {
        textField.textProperty().addListener { _, _, _ -> listener() }
    }
}
