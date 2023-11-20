import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Hangman {
    private final String searchedWord;
    private final Set<Character> correctChars = new HashSet<>();
    private String currentGuess = "";
    private int failedAttempts = 0;

    public Hangman (final String searchedWord){
        if (searchedWord == null || searchedWord.isBlank()) {
            throw new IllegalArgumentException("The searched word must not be null");
        }
        this.searchedWord = searchedWord.toLowerCase();
        System.out.println("The searched word has " + searchedWord.length() + " characters");
    }

    /**
     * Checks if the given character is included in the {@link #searchedWord}.
     * @param character to be checked
     */
    public void guessCharacter(final char character){
        if (isCorrectGuess(character)) {
            handleCorrectCharacterGuess(character);
        } else {
            handleFalseCharacterGuess(character);
        }
    }

    private boolean isCorrectGuess(final char character) {
        return searchedWord.contains(String.valueOf(character).toLowerCase());
    }

    /**
     * Adds the character to the list of {@link #correctChars} and updates the {@link #currentGuess}. Checks if the {@link #searchedWord} was found.
     * @param character to be added to correctly guessed characters
     */
    private void handleCorrectCharacterGuess(final char character) {
        correctChars.add(character);
        System.out.println("✅ Correct character: " + character);
        currentGuess = searchedWord.replaceAll(getRegexFromGuessedCharacters(), "-");
        printCurrentGuess();

        // check if word is completed
        if (Objects.equals(searchedWord, currentGuess)) {
            System.out.println("********************************************************************");
            System.out.println("Congratulations! 🎉");
            System.out.println("You have guessed " + searchedWord + " correctly with " + failedAttempts + " failed attempt(s)!");
            System.out.println("********************************************************************");
        }
    }

    /**
     * Increases the number of {@link #failedAttempts}.
     * @param character which was guessed incorrectly
     */
    private void handleFalseCharacterGuess(final char character) {
        System.out.println("❌ False character: " + character);
        failedAttempts++;
        printCurrentGuess();
    }

    /**
     * Computes a regex which matches all characters which are not included in {@link #correctChars}.
     * @return regex as String
     */
    private String getRegexFromGuessedCharacters() {
        StringBuilder regex = new StringBuilder("[^");
        correctChars.forEach(character -> regex.append(Pattern.quote(String.valueOf(character))));
        regex.append("]");
        System.out.println();
        return regex.toString();
    }

    private void printCurrentGuess() {
        System.out.println("Current guess: " + currentGuess);
    }
}