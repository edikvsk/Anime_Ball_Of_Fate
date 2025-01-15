package com.example.animeballoffate;

import java.util.Random;

public class AnswerManager {
    private static final String[] goodAnswers = {"Да", "Скорее да", "Определенно"};
    private static final String[] normalAnswers = {"Возможно", "Не знаю"};
    private final String[] badAnswers = {"Скорее нет", "Нет"};

    public String getRandomAnswer() {
        Random random = new Random();
        String[] allAnswers = new String[goodAnswers.length + normalAnswers.length + badAnswers.length];
        System.arraycopy(goodAnswers, 0, allAnswers, 0, goodAnswers.length);
        System.arraycopy(normalAnswers, 0, allAnswers, goodAnswers.length, normalAnswers.length);
        System.arraycopy(badAnswers, 0, allAnswers, goodAnswers.length + normalAnswers.length, badAnswers.length);
        return allAnswers[random.nextInt(allAnswers.length)];
    }

    public static boolean isGoodAnswer(String answer) {
        for (String goodAnswer : goodAnswers) {
            if (goodAnswer.equals(answer)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNormalAnswer(String answer) {
        for (String normalAnswer : normalAnswers) {
            if (normalAnswer.equals(answer)) {
                return true;
            }
        }
        return false;
    }
}
