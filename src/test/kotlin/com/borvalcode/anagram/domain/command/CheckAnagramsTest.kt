/* borvalcode 2023 */
package com.borvalcode.anagram.domain.command

import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.shouldBe
import kotlin.test.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CheckAnagramsTest {

  @Test
  fun `returns true if two strings are anagrams without including numbers`() {
    val actual =
        CheckAnagrams.execute(
            "1.-She Sells Sanctuary", "2.-Santa; shy, less cruel", includeNumbers = false)

    actual shouldBe Result.success(true)
  }

  @Test
  fun `returns false if two strings are not anagrams without including numbers`() {
    val actual = CheckAnagrams.execute("FOO", "FOE", includeNumbers = false)

    actual shouldBe Result.success(false)
  }

  @Test
  fun `returns true if two strings are anagrams including numbers`() {
    val actual =
        CheckAnagrams.execute(
            "She Sells Sanctuary", "Santa; shy, less cruel", includeNumbers = true)

    actual shouldBe Result.success(true)
  }

  @Test
  fun `returns false if two strings are not anagrams including numbers`() {
    val actual =
        CheckAnagrams.execute(
            "1.-She Sells Sanctuary", "2.-Santa; shy, less cruel", includeNumbers = true)

    actual shouldBe Result.success(false)
  }

  @ParameterizedTest
  @ValueSource(booleans = [true, false])
  fun `returns error when subject is not a valid phrase`(includeNumbers: Boolean) {
    val actual = CheckAnagrams.execute("1234", "2.-Santa; shy, less cruel", includeNumbers)

    actual.shouldBeFailure<IllegalArgumentException>().message shouldBe
        "Subject is not a valid phrase"
  }

  @ParameterizedTest
  @ValueSource(booleans = [true, false])
  fun `returns error when anagram candidate is not a valid phrase`(includeNumbers: Boolean) {
    val actual = CheckAnagrams.execute("She Sells Sanctuary", ".///", includeNumbers)

    actual.shouldBeFailure<IllegalArgumentException>().message shouldBe
        "Anagram candidate is not a valid phrase"
  }
}
