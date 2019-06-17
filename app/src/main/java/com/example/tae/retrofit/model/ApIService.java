package com.example.tae.retrofit.model;

//4? Create this (Interface, go to create new class but in a dropdown in there, change class to interface!

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApIService { //Declare what kind of calls we are able to make. Every call has the same structure as here
    //This is where you specifiy what data to get,type of service we are going to get
    @GET("people/{id}")//First annotation of what kind of data to GET, always pass ID in {}
    Call<StarWarsCharacters> getCharacter(@Path("id") int userId); //We use call as were no using rxjava + StarWarsCharacter is same thing used around this
    //Character is the class where people objects is stored into! Method getCharacter will getit!




    //for the assignment add 2 more end ponts
}
