package com.example.hw_spring_data.exeption;

public class NotFoundNoteExp extends Exception{
    public NotFoundNoteExp(String message) {
        super(message);
    }
}
