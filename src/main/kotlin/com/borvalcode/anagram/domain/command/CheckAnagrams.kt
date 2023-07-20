/* borvalcode 2023 */
package com.borvalcode.anagram.domain.command

import com.borvalcode.anagram.domain.model.isNotPhrase
import com.borvalcode.anagram.domain.model.toPhrase

object CheckAnagrams {

    fun execute(subject: String, anagramCandidate: String, includeNumbers: Boolean): Result<Boolean> {
        if (subject.isNotPhrase()) {
            return Result.failure(IllegalArgumentException("Subject is not a valid phrase"))
        } else if (anagramCandidate.isNotPhrase()) {
            return Result.failure(IllegalArgumentException("Anagram candidate is not a valid phrase"))
        }

        val anagrams =
            if (includeNumbers) {
                subject.toPhrase() isAnagramIncludingNumbersOf anagramCandidate.toPhrase()
            } else {
                subject.toPhrase() isAnagramOf anagramCandidate.toPhrase()
            }

        return Result.success(anagrams)
    }
}
