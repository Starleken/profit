package com.example.myapplication;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Scripts.Database.Lesson.DatabaseLessonSaver;
import com.example.myapplication.Scripts.Exceptions.UserIsNotSaved;
import com.example.myapplication.Scripts.Model.Lesson;

public class AddLessonActivity extends AppCompatActivity {
    private TextView addText;
    private TextView addNameText;
    private TextView addDurationText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);

        addText =  findViewById(R.id.message);
        addNameText = findViewById(R.id.AddLessonName);
        addDurationText = findViewById(R.id.addLessonDuration);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
    }

    private void add(){
        Lesson lesson = new Lesson();
        lesson.Name = addNameText.getText().toString();
        lesson.Duration = Integer.getInteger(addDurationText.getText().toString());
        lesson.Text = addText.getText().toString();

        try {
            new DatabaseLessonSaver().TrySave(lesson);
        }
        catch(UserIsNotSaved ex){

        }
    }
}
