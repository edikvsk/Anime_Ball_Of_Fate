package com.example.animeballoffate;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationHelper {

    private final Context context;

    public AnimationHelper(Context context) {
        this.context = context;
    }

    // Метод для запуска анимации вращения
    public void startRotationAnimation(View view) {
        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        view.startAnimation(rotation);
    }

    // Метод для запуска анимации появления и масштабирования
    public void startFadeInScaleAnimation(View view) {
        Animation fadeInScale = AnimationUtils.loadAnimation(context, R.anim.fade_in_scale);
        view.startAnimation(fadeInScale);
    }
}
