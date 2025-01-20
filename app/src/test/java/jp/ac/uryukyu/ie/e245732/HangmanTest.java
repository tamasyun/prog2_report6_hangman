package jp.ac.uryukyu.ie.e245732;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class HangmanTest {
    @Test
    public void testLoadWords() {
        Hangman game = new Hangman();
        List<String> words = game.getWords();
        assertNotEquals(0, words.size());
    }

    @Test
    public void testJudgeCharacter() {
        Hangman game = new Hangman();
        game.setAnswer("apple");

        assertTrue(game.judgeCharacter('a'));
        assertTrue(game.judgeCharacter('p'));
        assertFalse(game.judgeCharacter('z'));
    }

    @Test
    public void testPrintQuestion() {
        Hangman game = new Hangman();
        game.setAnswer("apple");
        game.judgeCharacter('a');
        game.judgeCharacter('p');

        assertEquals("app__", game.printQuestion());
    }
}