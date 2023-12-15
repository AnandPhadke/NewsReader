package com.example.newsreaderapp.rest_service;

public class ErrorEvent implements Event {
    int requestCode ;
    Throwable e;

    public ErrorEvent(Throwable e, int requestCode) {
        this.e = e;
        this.requestCode = requestCode;
    }

    public ErrorEvent(Throwable e) {
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public <T> T getResult() {
        return null;
    }

    @Override
    public int getRequestCode() {
        return 0;
    }
}
