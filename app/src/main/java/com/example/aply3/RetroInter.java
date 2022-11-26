package com.example.aply3;

import android.app.Person;

import com.google.firebase.database.core.Repo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetroInter {

    @POST("users")
    Call<Person> postUser(@Body Person person);
}
