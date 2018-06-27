package com.example.android.soccerquiz;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int questionNumber = 1;
    int totalquestions = 10;
    int score = 0;
    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuestion(questionNumber);
    }

    public void nextQuestion(View view) {
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        RadioGroup optionsRadioGroup = (RadioGroup) findViewById(R.id.options_radio_group);
        RadioButton optionA_radioButton = (RadioButton) findViewById(R.id.optionA_radio_button);
        RadioButton optionB_radioButton = (RadioButton) findViewById(R.id.optionB_radio_button);
        RadioButton optionC_radioButton = (RadioButton) findViewById(R.id.optionC_radio_button);
        Button nextButton = (Button) findViewById(R.id.next_button);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button resetButton = (Button) findViewById(R.id.reset_button);
        Button exitButton = (Button) findViewById(R.id.exit_button);

        calculateScore();

        if (questionNumber >= totalquestions) {
            questionTextView.setText(getString(R.string.end));
            nextButton.setVisibility(View.GONE);
            optionsRadioGroup.setVisibility(View.GONE);

            submitButton.setVisibility(View.VISIBLE);
            resetButton.setVisibility(View.VISIBLE);
            exitButton.setVisibility(View.VISIBLE);
            return;
        }

        if (optionA_radioButton.isChecked() || optionB_radioButton.isChecked() || optionC_radioButton.isChecked()) {
            optionsRadioGroup.clearCheck();
            displayQuestion(questionNumber += 1);
        } else {
            Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
        }

    }


    public void displayQuestion(int questionNo) {
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        RadioButton optionA_radioButton = (RadioButton) findViewById(R.id.optionA_radio_button);
        RadioButton optionB_radioButton = (RadioButton) findViewById(R.id.optionB_radio_button);
        RadioButton optionC_radioButton = (RadioButton) findViewById(R.id.optionC_radio_button);

        ProgressBar questionProgressBar = (ProgressBar) findViewById(R.id.questions_progress_bar);
        questionProgressBar.setProgress((questionNumber * 100) / totalquestions);

        switch (questionNumber) {
            case 1:
                questionTextView.setText(getString(R.string.q1, questionNumber));
                optionA_radioButton.setText(getString(R.string.q1_optionA));
                optionB_radioButton.setText(getString(R.string.q1_optionB));
                optionC_radioButton.setText(getString(R.string.q1_optionC));
                answer = "A";
                break;
            case 2:
                questionTextView.setText(getString(R.string.q2, questionNumber));
                optionA_radioButton.setText(getString(R.string.q2_optionA));
                optionB_radioButton.setText(getString(R.string.q2_optionB));
                optionC_radioButton.setText(getString(R.string.q2_optionC));

                answer = "B";
                break;
            case 3:
                questionTextView.setText(getString(R.string.q3, questionNumber));
                optionA_radioButton.setText(getString(R.string.q3_optionA));
                optionB_radioButton.setText(getString(R.string.q3_optionB));
                optionC_radioButton.setText(getString(R.string.q3_optionC));
                answer = "B";
                break;
            case 4:
                questionTextView.setText(getString(R.string.q4, questionNumber));
                optionA_radioButton.setText(getString(R.string.q4_optionA));
                optionB_radioButton.setText(getString(R.string.q4_optionB));
                optionC_radioButton.setText(getString(R.string.q4_optionC));
                answer = "C";
                break;
            case 5:
                questionTextView.setText(getString(R.string.q5, questionNumber));
                optionA_radioButton.setText(getString(R.string.q5_optionA));
                optionB_radioButton.setText(getString(R.string.q5_optionB));
                optionC_radioButton.setText(getString(R.string.q5_optionC));
                answer = "B";
                break;
            case 6:
                questionTextView.setText(getString(R.string.q6, questionNumber));
                optionA_radioButton.setText(getString(R.string.q6_optionA));
                optionB_radioButton.setText(getString(R.string.q6_optionB));
                optionC_radioButton.setText(getString(R.string.q6_optionC));
                answer = "B";
                break;
            case 7:
                questionTextView.setText(getString(R.string.q7, questionNumber));
                optionA_radioButton.setText(getString(R.string.q7_optionA));
                optionB_radioButton.setText(getString(R.string.q7_optionB));
                optionC_radioButton.setText(getString(R.string.q7_optionC));
                answer = "A";
                break;
            case 8:
                questionTextView.setText(getString(R.string.q8, questionNumber));
                optionA_radioButton.setText(getString(R.string.q8_optionA));
                optionB_radioButton.setText(getString(R.string.q8_optionB));
                optionC_radioButton.setText(getString(R.string.q8_optionC));
                answer = "B";
                break;
            case 9:
                questionTextView.setText(getString(R.string.q9, questionNumber));
                optionA_radioButton.setText(getString(R.string.q9_optionA));
                optionB_radioButton.setText(getString(R.string.q9_optionB));
                optionC_radioButton.setText(getString(R.string.q9_optionC));
                answer = "C";
                break;
            case 10:
                questionTextView.setText(getString(R.string.q10, questionNumber));
                optionA_radioButton.setText(getString(R.string.q10_optionA));
                optionB_radioButton.setText(getString(R.string.q10_optionB));
                optionC_radioButton.setText(getString(R.string.q10_optionC));
                answer = "A";
                break;
            default:
                break;
        }
    }


    public void calculateScore() {
        String choice = "";
        RadioButton optionA_radioButton = (RadioButton) findViewById(R.id.optionA_radio_button);
        RadioButton optionB_radioButton = (RadioButton) findViewById(R.id.optionB_radio_button);
        RadioButton optionC_radioButton = (RadioButton) findViewById(R.id.optionC_radio_button);

        if (optionA_radioButton.isChecked()) {
            choice = "A";
        }
        if (optionB_radioButton.isChecked()) {
            choice = "B";
        }
        if (optionC_radioButton.isChecked()) {
            choice = "C";
        }

        if (choice == answer) {
            score += 1;
        } else {
            //Do nothing
        }
    }

    public void submit(View view) {
        Toast.makeText(this, "Your score is " + score + " out of " + totalquestions, Toast.LENGTH_SHORT).show();
    }


    public void reset(View view) {
        questionNumber = 1;
        totalquestions = 5;
        score = 0;
        answer = "";

        Button nextButton = (Button) findViewById(R.id.next_button);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button resetButton = (Button) findViewById(R.id.reset_button);
        Button exitButton = (Button) findViewById(R.id.exit_button);
        RadioGroup optionsRadioGroup = (RadioGroup) findViewById(R.id.options_radio_group);

        optionsRadioGroup.clearCheck();
        nextButton.setVisibility(View.VISIBLE);
        optionsRadioGroup.setVisibility(View.VISIBLE);


        submitButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);
        exitButton.setVisibility(View.GONE);

        displayQuestion(questionNumber);
    }


    public void exit(View view) {
        this.finish();

        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exitIntent);
    }

}
