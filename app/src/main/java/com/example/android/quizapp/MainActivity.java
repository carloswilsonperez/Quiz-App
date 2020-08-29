package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer_4:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.answer_5:
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
}