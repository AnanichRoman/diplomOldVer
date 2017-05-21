package com.example.nowel.android_training_roman_ananich;

import java.io.Serializable;

/**
 * Created by Nowel on 31.03.2017.
 */

@SuppressWarnings("serial")
public class Test implements Serializable {


        private Question[] questions;
        private String title;
        private int amount;
        private String type;  // QUESTION > ANSWERS > TRUE/FALSE


/*
Q1-> A1 ->F/T
     A2  ->F/T
     A3 ->F/T
     A4  ->F/T
 */

        public int checkAnswers(int[] answer){
            int correct=0;
            for (int i=0;i<this.amount;i++)
            {
               if( questions[i].getRes(answer[i])==true){
                   correct++;
               }
            }

            return correct;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public int getAmount() {
            return this.amount;
        }

        public Question[] getQuestions(){
            return questions;
        }

        public Test(String type,String title,int amount, String[] questions, String[][] answers, int[] answer){
            this.type=type; //IF I EVER SEE THIS SHITTY CODE AGAIN AND DON"T FIX IT ---> GET DRUNK ---> DIE (-___-)
            this.title=title;
            this.amount=amount;

            for (int i=0;i<this.amount;i++){
                this.questions[i]=new Question(questions[i],answers[i],answer[i]);
            }

        }

        public Test(){
            this.title="TMP test with 5";
            this.amount =5;
            this.type="Normal";
            String[] answers={"One","Two","Three"};
            int res=1;
            questions=new Question[amount];
            for (int i=0;i<this.amount;i++){
                this.questions[i]=new Question("Title"+i,answers,res);
            }

        }

    }
