package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    private ImageButton exitButton;
    private ImageButton lessonsButton;
    private ImageButton calculatorButton;
    private ImageButton receptsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setViews();
        setListeners();
    }

    private void setViews() {
        exitButton = findViewById(R.id.exitButton);
        lessonsButton = findViewById(R.id.lessonsButton);
        calculatorButton = findViewById(R.id.calculatorButton);
        receptsButton = findViewById(R.id.receptsButton);
    }

    private void setListeners() {
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAvtorizaion();
            }
        });

        lessonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putLessonsFragment();
            }
        });

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putCalculatorFragment();
            }
        });

        receptsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putReceptsFragment();
            }
        });
    }

    //TODO вынести в отдельный класс
    private void goToAvtorizaion() {
        startActivity(new Intent(this, AvtorizationActivity.class));
    }

    private void putLessonsFragment() {
        LessonsFragment lessonsFragment = new LessonsFragment();
        putFragment(lessonsFragment);
    }

    private void putCalculatorFragment() {
        CalculatorFragment calculatorFragment = new CalculatorFragment();
        putFragment(calculatorFragment);
    }

    private void putReceptsFragment() {
        ReceptsFragment receptsFragment = new ReceptsFragment();
        putFragment(receptsFragment);
    }

    private void putFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }
}