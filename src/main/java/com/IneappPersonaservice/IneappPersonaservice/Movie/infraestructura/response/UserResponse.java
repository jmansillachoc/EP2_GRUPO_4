package com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response;


import com.IneappPersonaservice.IneappPersonaservice.Movie.domain.entity.Movie;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.BasicResponse;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserResponse {

   private List<Movie> movieList;
    private BasicResponse basicResponse;


}
