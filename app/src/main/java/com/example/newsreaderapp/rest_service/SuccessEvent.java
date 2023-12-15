package com.example.newsreaderapp.rest_service;

public class SuccessEvent<T> implements Event {

    private T result;
    private int requestCode;

    public SuccessEvent(T result, int requestCode) {
        this.result = result;
        this.requestCode = requestCode;
    }

    @Override
    public int getType() {
        return TYPE_SUCCESS;
    }

    @Override
    public <T> T getResult() {
        return (T)result;
    }

    @Override
    public int getRequestCode() {
        return requestCode;
    }
}
