package com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.repository;

import com.IneappPersonaservice.IneappPersonaservice.Movie.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findByrating(String rating);
}
