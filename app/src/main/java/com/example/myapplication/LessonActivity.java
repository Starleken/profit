package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Scripts.Model.Lesson;

public class LessonActivity extends AppCompatActivity {
    private TextView text;
    private TextView name;
    private Lesson lesson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        text = findViewById(R.id.TextLesson);
        name = findViewById(R.id.TitleTextView);
        text.setMovementMethod(new ScrollingMovementMethod());

        GetLesson();
    }

    private void GetLesson(){
        Bundle arguments = getIntent().getExtras();
        lesson = (Lesson)arguments.getSerializable("Lesson");

        text.setText(lesson.Text);
        name.setText(lesson.Name);
    }

}
