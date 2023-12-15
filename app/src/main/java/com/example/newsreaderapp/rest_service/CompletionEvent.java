package com.example.newsreaderapp.rest_service;

public class CompletionEvent implements Event {
    private int requestCode;

    public CompletionEvent(int requestCode) {
        this.requestCode = requestCode;
    }

    @Override
    public int getType() {
        return TYPE_COMPLETION;
    }

    @Override
    public <T> T getResult() {
        return null;
    }

    @Override
    public int getRequestCode() {
        return requestCode;
    }
}
