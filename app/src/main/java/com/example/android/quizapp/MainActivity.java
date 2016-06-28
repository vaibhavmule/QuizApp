package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int calculateScore(int checkFourMinusOne, boolean checkWhenGoogleAndroid, boolean checkRobin, boolean checkPi, boolean checkFourPlusOne) {
        if (checkFourMinusOne == 3) {
            quizScore += 1;
        }

        if (checkWhenGoogleAndroid) {
            quizScore += 1;
        }

        if (checkRobin) {
            quizScore += 1;
        }

        if (checkPi){
            quizScore += 1;
        }

        if (checkFourPlusOne){
            quizScore += 1;
        }

        return quizScore;
    }

    public void submitQuiz(View view) {
        quizScore = 0;

        RadioButton fourPlusOneQ = (RadioButton) findViewById(R.id.four_plus_one);
        boolean fourPlusOne = fourPlusOneQ.isChecked();

        RadioButton whatPi = (RadioButton) findViewById(R.id.pi_one);
        boolean whatPiValue = whatPi.isChecked();

        CheckBox robinWCheckBox = (CheckBox) findViewById(R.id.robin);
        boolean robin = robinWCheckBox.isChecked();

        CheckBox googleAndroidCheckBox = (CheckBox) findViewById(R.id.when_google_android);
        boolean whenGoogleAndroid = googleAndroidCheckBox.isChecked();

        EditText fourMinusOneQ = (EditText) findViewById(R.id.four_minus_one);
        int fourMinusOne = Integer.parseInt(fourMinusOneQ.getText().toString());

        displayScore(calculateScore(fourMinusOne, whenGoogleAndroid, robin, whatPiValue, fourPlusOne));
    }

    private void displayScore(int totalQuizScore) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.score_text_view);
        quantityTextView.setText("5 out of " + totalQuizScore + " answers are Right!");
    }
}
