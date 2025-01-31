package jp.ac.uryukyu.ie.e245732;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    private String answer;
    private ArrayList<Character> answerChars;
    private ArrayList<Character> guessed;

    Hangman() {
        Random rand = new Random();
        List<String> words = WordLoader.loadWords();
        this.answer = words.get(rand.nextInt(words.size()));
        this.answerChars = new ArrayList<>();
        for (char c : answer.toCharArray()) {
            answerChars.add(c);
        }
        this.guessed = new ArrayList<>();
    }

    public boolean judgeCharacter(char c) {
        if (answerChars.contains(c) && !guessed.contains(c)) {
            guessed.add(c);
            return true;
        } else {
            return false;
        }
    }

    public String printQuestion() {
        StringBuilder sb = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if (guessed.contains(c)) {
                sb.append(c);
            } else {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        this.answerChars = new ArrayList<>();
        for (char c : answer.toCharArray()) {
            answerChars.add(c);
        }
        this.guessed = new ArrayList<>();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<英単語を1字づつ推測せよ>");
        for (int i = 0; i < 6; i++) {
            System.out.printf("-------- %d/6 --------\n", i + 1);
            System.out.println(printQuestion());
            char guessedChar;
            while (true) {
                System.out.print("入力: ");
                String input = scanner.next();
                if (input.length() == 1) {
                    guessedChar = input.charAt(0);
                    break;
                } else {
                    System.out.println("(入力が無効です。半角英字1文字を入力してください。)");
                }
            }
            if (!judgeCharacter(guessedChar)) {
                System.out.println("含まれません");
            }
            if (answer.equals(printQuestion())) {
                break;
            }
        }
        System.out.println("正解は「" + answer + "」でした！");
        scanner.close();
    }

}
