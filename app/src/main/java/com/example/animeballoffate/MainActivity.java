package com.example.animeballoffate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] answers = {
            "Да", "Нет", "Возможно", "Определенно", "Скорее да", "Скорее нет", "Не знаю"
    };

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

        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = questionInput.getText().toString();
                if (!question.isEmpty()) {
                    String answer = getRandomAnswer();
                    answerOutput.setText(answer);
                }
            }
        });
    }

    private String getRandomAnswer() {
        Random random = new Random();
        return answers[random.nextInt(answers.length)];
    }
}