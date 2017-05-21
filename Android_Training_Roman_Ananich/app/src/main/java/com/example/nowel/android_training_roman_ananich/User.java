package com.example.nowel.android_training_roman_ananich;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nowel on 02.04.2017.
 */

public class User {
    String login;
    String pass;
    String name;


    public User(){//DEL later
        this.login="Login";
        this.pass="Pass";
        this.name="Name";
    }

    public User(String login,String pass,String name){
        this.login=login;
        this.pass=pass;
        this.name=name;

    }

}
