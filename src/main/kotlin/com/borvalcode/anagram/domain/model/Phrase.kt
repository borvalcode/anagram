/* borvalcode 2023 */
package com.borvalcode.anagram.domain.model

data class Phrase(private val value: String) {
    init {
        require(value.any { it.isLetter() })
    }

    private val letters: Map<Char, Int> by lazy {
        value.lowercase().filter { it.isLetter() }.groupingBy { it }.eachCount()
    }

    private val numbers: Map<Int, Int> by lazy {
        value.filter { it.isDigit() }.map { it.digitToInt() }.groupingBy { it }.eachCount()
    }

    infix fun isAnagramOf(phrase: Phrase): Boolean {
        return listOf(this, phrase).areAnagrams()
    }

    infix fun isAnagramIncludingNumbersOf(phrase: Phrase): Boolean {
        return listOf(this, phrase).areAnagramsIncludingNumbers()
    }

    private fun List<Phrase>.areAnagrams(): Boolean {
        return allLettersEqual()
    }

    private fun List<Phrase>.areAnagramsIncludingNumbers(): Boolean {
        return allLettersEqual() && allNumbersEqual()
    }

    private fun List<Phrase>.allLettersEqual(): Boolean {
        return map { it.letters }.allEqual()
    }

    private fun List<Phrase>.allNumbersEqual(): Boolean {
        return map { it.numbers }.allEqual()
    }

    private fun <T> List<T>.allEqual(): Boolean = toSet().size == 1
}

fun String.isPhrase(): Boolean {
    return try {
        toPhrase()
        true
    } catch (ex: IllegalArgumentException) {
        false
    }
}

fun String.isNotPhrase(): Boolean {
    return !isPhrase()
}

fun String.toPhrase(): Phrase {
    return Phrase(this)
}
