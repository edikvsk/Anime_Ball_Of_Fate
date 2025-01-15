package com.example.animeballoffate;

import android.widget.ImageView;

public class ImageManager {
    public static void setImageBasedOnAnswer(ImageView imageView, String answer) {
        if (AnswerManager.isGoodAnswer(answer)) {
            imageView.setImageResource(ImageType.GOOD_ANSWER.getResourceId());
        } else if (AnswerManager.isNormalAnswer(answer)) {
            imageView.setImageResource(ImageType.NORMAL_ANSWER.getResourceId());
        } else {
            imageView.setImageResource(ImageType.BAD_ANSWER.getResourceId());
        }
    }

    public static void setImageForEmptyQuestion(ImageView imageView) {
        imageView.setImageResource(ImageType.EMPTY_QUESTION.getResourceId());
    }

    public static void setImageForSameQuestion(ImageView imageView) {
        imageView.setImageResource(ImageType.SAME_QUESTION.getResourceId());
    }
}
