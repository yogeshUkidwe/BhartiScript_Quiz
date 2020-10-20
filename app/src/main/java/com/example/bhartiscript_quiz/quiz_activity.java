package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static com.example.bhartiscript_quiz.Level_selection.flag;

public class quiz_activity extends AppCompatActivity {
    private static final long COUNTDOWN_IN_MILLIS = 20000;

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;
    private List<Question_data> questionList;


    private ColorStateList textcolorDefaultRB;
    private ColorStateList textcolorDeafultCD;

    private CountDownTimer countDownTimer;
    private long timeLeftInMills;
    private int questionCounter;

    private int  QuestionCountTotal = 20;  ;
    private Question_data currentQuestion;
    private int score = 0 ;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_activity);
        //buttons and all declare events
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.score);
        textViewQuestionCount = findViewById(R.id.outOf);
        textViewCountDown = findViewById(R.id.q_timer);
        buttonConfirmNext = findViewById(R.id.confirm);


        //Radio Group
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radionButton1);
        rb2 = findViewById(R.id.radionButton2);
        rb3 = findViewById(R.id.radionButton3);
        rb4 = findViewById(R.id.radionButton4);
        textcolorDefaultRB = rb1.getTextColors();
        textcolorDeafultCD = textViewCountDown.getTextColors();

        //declare SQLite code
        quizDbSupport dbHelper = new quizDbSupport(this);

        // fetch all Questions
        if(flag==1) {
            questionList = dbHelper.getAllQuestionsQ1();
        }
        if(flag==2) {
            questionList= dbHelper.getAllQuestionsQ2();
        }
        if(flag==3) {
            questionList = dbHelper.getAllQuestionsQ3();
        }
        if(flag==4){
            questionList = dbHelper.getAllQuestionsQ4();
        }
        if(flag==5){
            questionList = dbHelper.getAllQuestionsQ5();
        }
        if(flag==6){
            questionList = dbHelper.getAllQuestionsQ6();
        }
        Collections.shuffle(questionList);

        //next 20 Questions
        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        CheckAnswer();
                    }
                    else{
                        Toast.makeText(quiz_activity.this, "कृपया अपना उत्तर चुनें", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    showNextQuestion();
                }
            }
        });
    }

    //counnt a score
    private void CheckAnswer() {

        answered = true;
        countDownTimer.cancel();
        RadioButton radioButton = findViewById(rbGroup.getCheckedRadioButtonId());
        int answer = rbGroup.indexOfChild(radioButton) + 1;
        if(answer == currentQuestion.getAnswer()){
            score++;
            textViewScore.setText(" गुण :" + score);
        }
        showSolution();
    }

    // change color after selecting answer
    private void showSolution() {


        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch(currentQuestion.getAnswer()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }

        if(questionCounter < QuestionCountTotal){
            buttonConfirmNext.setText(" आगे ");
        }
        else{
            buttonConfirmNext.setText(" समाप्त ");
        }
    }

    // fill next question
    private void showNextQuestion() {

        rb1.setTextColor(textcolorDefaultRB);
        rb2.setTextColor(textcolorDefaultRB);
        rb3.setTextColor(textcolorDefaultRB);
        rb4.setTextColor(textcolorDefaultRB);
        rbGroup.clearCheck();


        if(questionCounter<QuestionCountTotal){
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());

            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            questionCounter++;


            textViewQuestionCount.setText("प्रश्न: " + questionCounter +"/" + QuestionCountTotal);

            answered =false;
            buttonConfirmNext.setText("पुष्टि करें");

            timeLeftInMills = COUNTDOWN_IN_MILLIS;
            startCountDown();
        }
        else{
            finishQuiz();
        }
    }


    // Strarting Timer
    private void startCountDown() {

        countDownTimer = new CountDownTimer( timeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMills = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMills=0;
                updateCountDownText();
                CheckAnswer();
            }
        }.start();
    }

    //dynamic timer (change)
    private void updateCountDownText() {
        int minutes =(int)(timeLeftInMills / 1000) / 60;
        int seconds = (int) (timeLeftInMills/1000) % 60;


        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormatted);

        if(timeLeftInMills < 8000){
            textViewCountDown.setTextColor(Color.RED);
        }
        else{
            textViewCountDown.setTextColor(textcolorDeafultCD);
        }
    }

    //For result 
    private void finishQuiz() {
        // passing 60 %
        int passing_perc= 60;
            if( score > 12 ){
            Intent intent1 = new Intent(this, signIn_certificates.class);
            startActivity(intent1);
            }
            else{
                Intent intent2 = new Intent(this,appreciation.class);
                startActivity(intent2);
            }

    }

    //2 second after pressing comment
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "खत्म करने के लिए फिर से बटन दबाएं", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    //after destroy formalities
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}