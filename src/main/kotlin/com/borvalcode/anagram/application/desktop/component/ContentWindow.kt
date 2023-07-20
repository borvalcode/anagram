/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop.component

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage

class ContentWindow(
    private val title: String,
    width: Double,
    height: Double,
    verticalSpacing: Double,
    padding: Double
) {
    private val vBox: VBox
    private val scene: Scene

    init {
        vBox = VBox(verticalSpacing)
        vBox.padding = Insets(padding)
        scene = Scene(vBox, width, height)
    }

    fun add(node: Node) {
        vBox.children.add(node)
    }

    fun runStage(stage: Stage) {
        stage.title = title
        stage.scene = scene
        stage.show()
    }
}
