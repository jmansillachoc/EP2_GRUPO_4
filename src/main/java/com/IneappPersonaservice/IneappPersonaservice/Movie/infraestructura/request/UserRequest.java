package com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserRequest {
    private String title;
    private String year;
    private String gender;
    private String director;
    private String rating;
}