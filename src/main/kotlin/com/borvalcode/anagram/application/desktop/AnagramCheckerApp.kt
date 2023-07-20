/* borvalcode 2023 */
package com.borvalcode.anagram.application.desktop

import com.borvalcode.anagram.application.desktop.component.ContentWindow
import com.borvalcode.anagram.application.desktop.component.IncludeNumbersCheck
import com.borvalcode.anagram.application.desktop.component.PhraseTextField
import com.borvalcode.anagram.application.desktop.component.ResultLabel
import com.borvalcode.anagram.domain.command.CheckAnagrams
import javafx.application.Application
import javafx.stage.Stage

class AnagramCheckerApp : Application() {
    private val subjectField = PhraseTextField("subject")
    private val anagramCandidateField = PhraseTextField("anagram-candidate")
    private val includeNumbersCheck =
        IncludeNumbersCheck(id = "include-numbers", text = "Include numbers")
    private val resultLabel = ResultLabel("result")

    override fun start(primaryStage: Stage) {
        val contentWindow =
            ContentWindow(
                title = "Anagram Checker App",
                width = 300.0,
                height = 200.0,
                verticalSpacing = 10.0,
                padding = 10.0
            )

        with(subjectField) {
            onChange { refresh() }
            addTo(contentWindow)
        }

        with(anagramCandidateField) {
            onChange { refresh() }
            addTo(contentWindow)
        }

        with(includeNumbersCheck) {
            onChange { refresh() }
            addTo(contentWindow)
        }

        resultLabel.addTo(contentWindow)

        contentWindow.runStage(primaryStage)

        refresh()
    }

    private fun refresh() {
        val result =
            CheckAnagrams.execute(
                subjectField.text, anagramCandidateField.text, includeNumbersCheck.selected
            )

        result.fold(
            onFailure = { resultLabel.info("Check if two texts are anagrams of each other") },
            onSuccess = { anagrams ->
                if (anagrams) {
                    resultLabel.success("Anagrams!")
                } else {
                    resultLabel.error("Not Anagrams!")
                }
            })
    }
}
