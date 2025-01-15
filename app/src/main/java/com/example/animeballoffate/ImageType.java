package com.example.animeballoffate;

public enum ImageType {
    SAME_QUESTION(R.drawable.ball_aqua_same_question),
    EMPTY_QUESTION(R.drawable.ball_aqua_question_empty),
    GOOD_ANSWER(R.drawable.ball_aqua_answer_good),
    NORMAL_ANSWER(R.drawable.ball_aqua_answer_normal),
    BAD_ANSWER(R.drawable.ball_aqua_answer_bad);

    private final int resourceId;

    ImageType(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }
}
