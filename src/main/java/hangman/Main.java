package hangman;
public class Main {
    public static void main(String[] args) {
        final var search = new Hangman("marathon");
        search.guessCharacter('a');
        search.guessCharacter('i');
        search.guessCharacter('n');
        search.guessCharacter('r');
        search.guessCharacter('e');
        search.guessCharacter('h');
        search.guessCharacter('c');
        search.guessCharacter('t');
        search.guessCharacter('o');
        search.guessCharacter('m');
    }
}