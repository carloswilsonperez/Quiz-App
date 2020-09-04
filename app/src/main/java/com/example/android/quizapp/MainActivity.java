package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button backButton;
    Button nextButton;
    TextView title;
    ScrollView scrollContainer;
    LinearLayout page1;
    LinearLayout page2;
    LinearLayout page3;

    double grade = 0.0;

    private static final int NUMBER_OF_QUESTIONS = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backButton = findViewById(R.id.back_button);
        nextButton = findViewById(R.id.next_button);
        title = findViewById(R.id.title);

        scrollContainer = findViewById(R.id.scroll_view);

        page1 = findViewById(R.id.page_1);
        page2 = findViewById(R.id.page_2);
        page3 = findViewById(R.id.page_3);

        page2.setVisibility(View.GONE);
        page3.setVisibility(View.GONE);

        backButton.setVisibility(View.GONE);
    }

    public void resetRadioButton(int id1, int id2, int id3) {
        RadioButton answer1 = findViewById(id1);
        RadioButton answer2 = findViewById(id2);
        RadioButton answer3 = findViewById(id3);

        answer1.setChecked(false);
        answer2.setChecked(false);
        answer3.setChecked(false);
    }

    /**
     * Resets all questions
     */
    public void resetScores(View view) {
        // Reset question 1
        resetRadioButton(R.id.answer_1, R.id.answer_2, R.id.answer_3);

        // Reset question 2
        EditText answer2EditText = findViewById(R.id.answer_4);
        answer2EditText.setText("");

        // Validate answer for question 3
        CheckBox answer5 = findViewById(R.id.answer_5);
        CheckBox answer6 = findViewById(R.id.answer_6);
        CheckBox answer7 = findViewById(R.id.answer_7);

        answer5.setChecked(false);
        answer6.setChecked(false);
        answer7.setChecked(false);

        // Validate answer for question 4
        resetRadioButton(R.id.answer_8, R.id.answer_9, R.id.answer_10);

        // Validate answer for question 5
        resetRadioButton(R.id.answer_11, R.id.answer_12, R.id.answer_13);

        // Validate answer for question 6
        resetRadioButton(R.id.answer_14, R.id.answer_15, R.id.answer_16);

        // Validate answer for question 7
        resetRadioButton(R.id.answer_17, R.id.answer_18, R.id.answer_19);

        // Validate answer for question 8
        resetRadioButton(R.id.answer_20, R.id.answer_21, R.id.answer_22);

        page1.setVisibility(View.VISIBLE);
        page2.setVisibility(View.GONE);
        page3.setVisibility(View.GONE);

        nextButton.setText("Next");
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);

        grade = 0.0;
    }

    /**
     * Shows page 2 of the quiz
     */
    public void goNext(View view) {
        Button nextButton = (Button) view;
        String buttonText = nextButton.getText().toString();

        if (buttonText.equals("Finish")) {
            showScore();
        } else {
            page1.setVisibility(View.GONE);
            page2.setVisibility(View.VISIBLE);
            scrollContainer.scrollTo(0, 0);

            backButton.setVisibility(View.VISIBLE);
            nextButton.setText("Finish");
        }
    }

    /**
     * Shows page 1 of the quiz
     */
    public void goBack(View view) {
        page1.setVisibility(View.VISIBLE);
        page2.setVisibility(View.GONE);
        nextButton.setText("Next");
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.VISIBLE);
        scrollContainer.scrollTo(0, 0);
    }

    /**
     * Get the final score
     */
    public double getScore() {
        // Check answers
        // Validate answer for question 1
        RadioButton answer1 = findViewById(R.id.answer_1);

        if (answer1.isChecked()) {
            grade++;
        }

        // Validate answer for question 2
        EditText answer2EditText = findViewById(R.id.answer_4);
        String answer2 = answer2EditText.getText().toString().toLowerCase();

        if (answer2.equals("kotlin")) {
            grade++;
        }

        // Validate answer for question 3
        CheckBox answer5CheckBox = findViewById(R.id.answer_5);
        if (answer5CheckBox.isChecked()) {
            grade = grade + 0.5f;
        }

        CheckBox answer7CheckBox = findViewById(R.id.answer_7);
        if (answer7CheckBox.isChecked()) {
            grade = grade + 0.5f;
        }

        // Validate answer for question 4
        RadioButton answer4 = findViewById(R.id.answer_10);

        if (answer4.isChecked()) {
            grade++;
        }

        // Validate answer for question 5
        RadioButton answer5 = findViewById(R.id.answer_11);

        if (answer5.isChecked()) {
            grade++;
        }

        // Validate answer for question 6
        RadioButton answer6 = findViewById(R.id.answer_15);

        if (answer6.isChecked()) {
            grade++;
        }

        // Validate answer for question 7
        RadioButton answer7 = findViewById(R.id.answer_19);

        if (answer7.isChecked()) {
            grade++;
        }

        // Validate answer for question 8
        RadioButton answer8 = findViewById(R.id.answer_22);

        if (answer8.isChecked()) {
            grade++;
        }

        return grade;
    }

    /**
     * Show the final score
     */
    public void showScore() {
        page1.setVisibility(View.GONE);
        page2.setVisibility(View.GONE);
        page3.setVisibility(View.VISIBLE);
        title.setVisibility(View.GONE);
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        double finalScore = getScore()/NUMBER_OF_QUESTIONS;

        DecimalFormat formatter = new DecimalFormat("#.##%");
        String finalScoreString = formatter.format(finalScore);

        TextView score = findViewById(R.id.score);
        score.setText(finalScoreString);
    }
}