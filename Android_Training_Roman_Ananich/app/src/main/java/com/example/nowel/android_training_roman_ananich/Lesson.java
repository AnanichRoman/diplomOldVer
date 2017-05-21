package com.example.nowel.android_training_roman_ananich;

import android.icu.util.ULocale;
import java.util.Locale;

/**
 * Created by Nowel on 31.03.2017.
 */


public class Lesson {


        //Rating MB?!
        private Category category;
        private String title; // Name lolz
        private String type; //Video/Text
        private String url;  // url if video
        private String text; // text if Text lolz


        public  String getText(){return this.text;}

        public String getUrl(){return this.url;}

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }



        public Lesson(String type,String title, String urlortext){

            if (type=="Video") {
                this.type = type;
                this.title = title;
                this.url = urlortext;
            }
            else {
                this.type=type;
                this.title=title;
                this.text=urlortext;
            }
        }

        public Lesson(){
            this.type="Video";
            this.title="Lesson";
            this.url="4g1_UH_6VQc";
        }

    }
