package com.example.aply3;










public class Retrofit {
    public static final String BASE_URL = "http://192.168.1.62:8081/students/";

    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
}
