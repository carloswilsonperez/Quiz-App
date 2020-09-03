package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button backButton;
    Button nextButton;
    LinearLayout page1;
    LinearLayout page2;
    LinearLayout page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backButton = findViewById(R.id.back_button);
        nextButton = findViewById(R.id.next_button);

        page1 = (LinearLayout) findViewById(R.id.page_1);
        page2 = (LinearLayout) findViewById(R.id.page_2);
        page3 = (LinearLayout) findViewById(R.id.page_3);

        page2.setVisibility(View.GONE);
        page3.setVisibility(View.GONE);

        backButton.setVisibility(View.GONE);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer_1:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.answer_2:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    /**
     * Resets and displays score for both teams
     */
    public void resetScores(View view) {

    }

    /**
     * Resets and displays score for both teams
     */
    public void goNext(View view) {
        Button nextButton = (Button) view;
        String buttonText = nextButton.getText().toString();
        Toast.makeText(this, buttonText, Toast.LENGTH_SHORT).show();

        if (buttonText.equals("Finish")) {
            showScore();
        } else {
            page1.setVisibility(View.GONE);
            page2.setVisibility(View.VISIBLE);

            backButton.setVisibility(View.VISIBLE);
            nextButton.setText("Finish");
        }
    }

    /**
     * Resets and displays score for both teams
     */
    public void goBack(View view) {
        page1.setVisibility(View.VISIBLE);
        page2.setVisibility(View.GONE);
        nextButton.setText("Next");
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.VISIBLE);
    }

    /**
     * Resets and displays score for both teams
     */
    public void showScore() {
        page1.setVisibility(View.GONE);
        page2.setVisibility(View.GONE);
        page3.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);
    }
}