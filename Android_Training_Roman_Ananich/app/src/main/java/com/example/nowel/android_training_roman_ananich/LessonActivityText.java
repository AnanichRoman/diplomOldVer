package com.example.nowel.android_training_roman_ananich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LessonActivityText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_text);

        Bundle b = getIntent().getExtras();
        String text = b.getString("text");

        TextView textView=(TextView) findViewById(R.id.textView_LessonText);
        textView.setText(text);
    }
}
