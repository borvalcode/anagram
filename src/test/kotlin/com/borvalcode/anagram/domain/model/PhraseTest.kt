/* borvalcode 2023 */
package com.borvalcode.anagram.domain.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PhraseTest {

  @Test
  fun `A phrase should have at least one letter`() {
    shouldNotThrowAny { Phrase("Hello world25") }
  }

  @Test
  fun `Throws exception if it doesn't have any letter`() {
    shouldThrow<IllegalArgumentException> { Phrase("22;!") }
  }

  @Test
  fun `Checks if phrase is anagram of another`() {
    Phrase("New York Times") isAnagramOf Phrase("monkeys write") shouldBe true
    Phrase("New York Times") isAnagramOf Phrase("monkeys writeho") shouldBe false
  }

  @Test
  fun `Checks if phrase is anagram of another including numbers`() {
    Phrase("New York Times55") isAnagramIncludingNumbersOf Phrase("mon5keys wr5ite") shouldBe true
    Phrase("New York Times55") isAnagramIncludingNumbersOf Phrase("monkeys write") shouldBe false
  }
}
