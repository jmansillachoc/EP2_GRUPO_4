package com.IneappPersonaservice.IneappPersonaservice.Movie.application.services;

import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.request.UserRequest;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.BasicResponse;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.UserResponse;


public interface MovieServices {

     public BasicResponse addUser(UserRequest request);

     public UserResponse getAll();

     public UserResponse getByRating(String rating);

     public BasicResponse updateMovie(UserRequest request, String rating);

     public BasicResponse deleteMovie(String rating);

}
