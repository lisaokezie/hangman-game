package hangman;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {

    private static final String SEARCHED_WORD = "plant";


    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void initializationWithNull_shouldThrowIllegalArgumentException(final String searchedWord) {
        assertThrows(IllegalArgumentException.class, () -> new Hangman(searchedWord));
    }

    @ParameterizedTest
    @ValueSource(chars = {'b', 'c', 'h', 'z', 'y'})
    void isCorrectGuess_shouldDetectIncorrectGuess(final char character) {
        // given
        final var hangman = new Hangman(SEARCHED_WORD);

        // when/then
        assertFalse(hangman.isCorrectGuess(character));
    }

    @ParameterizedTest
    @ValueSource(chars = {'p', 'l', 'a', 'n', 't'})
    void isCorrectGuess_shouldDetectCorrectGuess(final char character) {
        // given
        final var hangman = new Hangman(SEARCHED_WORD);

        // when/then
        assertTrue(hangman.isCorrectGuess(character));
    }
}