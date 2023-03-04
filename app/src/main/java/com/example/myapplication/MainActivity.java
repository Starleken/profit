package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Scripts.Exceptions.FieldIsEmptyException;

public class MainActivity extends AppCompatActivity {

    private Button enterButton;
    private Button loginButton;

    private EditText password;
    private EditText login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
    }

    private void findViews() {
        enterButton = findViewById(R.id.buttonEnter);
        loginButton = findViewById(R.id.buttonLogin);

        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.editTextTextPersonName);
    }

    private void setListeners() {
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainMenu();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAvtorization();
            }
        });
    }

    private void goToAvtorization() {
        startActivity(new Intent(this, AvtorizationActivity.class));
    }

    private void goToMainMenu() {
        try {
            tryCheckFieldsAtNull();
        }
        catch (FieldIsEmptyException ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(new Intent(this, MenuActivity.class));
    }

    private void tryCheckFieldsAtNull() throws FieldIsEmptyException {
        if (TextUtils.isEmpty(password.getText())) {
            throw new FieldIsEmptyException("Заполните пароль");
        }
        else if(TextUtils.isEmpty(login.getText())) {
            throw new FieldIsEmptyException("Заполните логин");
        }
    }
}