package com.example.animeballoffate;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String lastQuestion = "";
    private final AnswerManager answerManager = new AnswerManager();
    private AnimationHelper animationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        animationHelper = new AnimationHelper(this); // Инициализация AnimationHelper

        EditText questionInput = findViewById(R.id.question_input);
        Button askButton = findViewById(R.id.ask_button);
        TextView answerOutput = findViewById(R.id.answer_output);
        ImageView idleImage = findViewById(R.id.idleImage);
        ImageView ballOfFate = findViewById(R.id.ball_of_fate);

        askButton.setOnClickListener(v -> handleAskButtonClick(questionInput, answerOutput, idleImage, ballOfFate));
    }

    private void handleAskButtonClick(EditText questionInput, TextView answerOutput, ImageView idleImage, ImageView ballOfFate) {
        String question = questionInput.getText().toString().trim(); // Убираем пробелы по краям

        if (question.isEmpty()) {
            answerOutput.setText("Введите вопрос");
            ImageManager.setImageForEmptyQuestion(idleImage); // Устанавливаем изображение для пустого вопрос
        } else {
            if (question.equals(lastQuestion)) {
                answerOutput.setText("Вы уже получили ответ на этот вопрос. Задайте новый вопрос.");
                ImageManager.setImageForSameQuestion(idleImage); // Устанавливаем изображение для повторяющегося вопроса
                questionInput.setText(""); // Очищаем поле ввода
            } else {
                lastQuestion = question;
                String answer = answerManager.getRandomAnswer();
                answerOutput.setText(answer);
                startAnswerAnimation(answerOutput, idleImage, ballOfFate, answer);
            }
        }
    }

    private void startAnswerAnimation(TextView answerOutput, ImageView idleImage, ImageView ballOfFate, String answer) {
        animationHelper.startFadeWithRotateAnimation(answerOutput, new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ImageManager.setImageBasedOnAnswer(idleImage, answer); // Устанавливаем изображение в зависимости от ответа
                ballOfFate.setVisibility(View.VISIBLE);

                animationHelper.startFadeInScaleAnimation(ballOfFate, new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animationHelper.startRotationAnimation(ballOfFate); // Запускаем вращение после завершения анимации появления
                    }
                });
            }
        });
    }
}