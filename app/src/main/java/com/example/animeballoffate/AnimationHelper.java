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

    // Метод для запуска анимации появления и масштабирования с слушателем
    public void startFadeInScaleAnimation(View view, Animation.AnimationListener listener) {
        Animation fadeInScale = AnimationUtils.loadAnimation(context, R.anim.fade_in_scale);
        fadeInScale.setAnimationListener(listener); // Устанавливаем слушателя анимации
        view.startAnimation(fadeInScale);
    }

    public void startFadeWithRotateAnimation(View view, Animation.AnimationListener listener) {
        Animation fadeInScale = AnimationUtils.loadAnimation(context, R.anim.fade_with_rotate);
        fadeInScale.setAnimationListener(listener); // Устанавливаем слушателя анимации
        view.startAnimation(fadeInScale);
    }
}
