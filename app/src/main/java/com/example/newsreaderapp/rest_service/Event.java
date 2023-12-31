package com.example.newsreaderapp.rest_service;

public interface Event {
    int TYPE_SUCCESS = 1;
    int TYPE_ERROR = 2;
    int TYPE_COMPLETION =3;

    int getType();

    <T> T getResult();

    int getRequestCode();
}
