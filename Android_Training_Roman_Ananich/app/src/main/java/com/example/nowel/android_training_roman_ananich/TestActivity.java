package com.example.nowel.android_training_roman_ananich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    int currentQuestion;
    int amount;
    String testTitle;
    Question[] questions;
    TextView title;
    TextView currentQuestionNumber;
    TextView currentQuestionTitle;
    TextView testResults;
    RadioGroup radioGroup;
    Button submit;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        Test test = (Test)intent.getSerializableExtra("test");

        currentQuestion=0;
        amount = test.getAmount();
        testTitle=test.getTitle();
        questions=test.getQuestions();

        title = (TextView) findViewById(R.id.textViewT_testTitle);
        currentQuestionNumber = (TextView) findViewById(R.id.textViewT_questionNumber);
        currentQuestionTitle=(TextView) findViewById(R.id.textViewT_question);
        radioGroup=(RadioGroup) findViewById(R.id.radio_group_ansvers);
        submit=(Button) findViewById(R.id.button_nextSubmit);
        testResults=(TextView) findViewById(R.id.textView_testResults);

        setQuestion(currentQuestion);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestion<amount-1) {
                    currentQuestion++;
                    if ((questions[currentQuestion].getRes(radioGroup.getCheckedRadioButtonId()-100))==true) { //MAGIC!!
                        score++;


                        setQuestion(currentQuestion);
                    } else {
                      //  currentQuestion++;
                        setQuestion(currentQuestion);
                    }
                }
               else{
                    testResults.setVisibility(View.VISIBLE);
                    testResults.setText("You scorred :"+String.valueOf(score)+" out of "+String.valueOf(amount));
                }
            }
        });


    }


    public void setQuestion(int num){

        this.currentQuestionNumber.setText(String.valueOf(num+1));
        this.currentQuestionTitle.setText(questions[num].getTitle());

        int answersNumb=questions[num].getAnswers().length;
        String[] answers=questions[num].getAnswers();

        final RadioButton[] rb = new RadioButton[answersNumb];
        radioGroup.removeAllViews();

        for(int i=0; i<answersNumb; i++){
            rb[i]  = new RadioButton(this);
            rb[i].setText(answers[i]);
            rb[i].setId(i+100);
            radioGroup.addView(rb[i]);
        }
    }
}
