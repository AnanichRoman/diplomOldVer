package com.example.nowel.android_training_roman_ananich;

import java.io.Serializable;

/**
 * Created by Nowel on 16.04.2017.
 */

@SuppressWarnings("serial")
public class Question implements Serializable {
    private String title;
    private String[] answers;
    private int answer;

    public Question(String title,String[] answers, int answer)
    {
        this.title=title;
        this.answers=answers;
        this.answer=answer;
    }

    public boolean getRes(int answer){
        if(answer!= this.answer) return false;
        else return true;
    }

    public String getTitle(){
        return this.title;
    }

    public String[] getAnswers(){
        return this.answers;
    }

    public int getAnswer(){
        return this.answer;
    }
}
