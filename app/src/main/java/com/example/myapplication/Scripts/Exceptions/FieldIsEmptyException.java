package com.example.myapplication.Scripts.Exceptions;

public class FieldIsEmptyException extends Exception {

    private int duration = 5;

    public FieldIsEmptyException(String message) {
        super(message);
    }

    public int GetDuration() {
        return duration;
    }
}
