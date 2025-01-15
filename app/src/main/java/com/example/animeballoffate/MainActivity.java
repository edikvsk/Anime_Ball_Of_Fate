package com.example.animeballoffate;

import android.os.Bundle;
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

        EditText questionInput = findViewById(R.id.question_input);
        Button askButton = findViewById(R.id.ask_button);
        TextView answerOutput = findViewById(R.id.answer_output);
        ImageView idleImage = findViewById(R.id.idleImage);

        askButton.setOnClickListener(v -> {
            String question = questionInput.getText().toString().trim(); // Убираем пробелы по краям

            if (question.isEmpty()) {
                answerOutput.setText("Введите вопрос");
                ImageManager.setImageForEmptyQuestion(idleImage); // Устанавливаем изображение для пустого вопроса
            } else {
                if (question.equals(lastQuestion)) {
                    answerOutput.setText("Вы уже получили ответ на этот вопрос. Задайте новый вопрос.");
                    ImageManager.setImageForSameQuestion(idleImage); // Устанавливаем изображение для повторяющегося вопроса
                    questionInput.setText(""); // Очищаем поле ввода
                } else {
                    lastQuestion = question;
                    String answer = answerManager.getRandomAnswer();
                    answerOutput.setText(answer);
                    ImageManager.setImageBasedOnAnswer(idleImage, answer); // Устанавливаем изображение в зависимости от ответа
                }
            }
        });
    }
}
