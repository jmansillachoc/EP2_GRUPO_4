package com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.controller;

import com.IneappPersonaservice.IneappPersonaservice.Movie.application.services.MovieServices;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.request.UserRequest;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.BasicResponse;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {



    @Autowired
    private MovieServices movieServices;


    @GetMapping
    @RequestMapping("/getall")
    public UserResponse getAll(){
        return movieServices.getAll();
    }

    @GetMapping
    @RequestMapping("/getbyrating")
    public UserResponse getByDni(@RequestParam String rating){
        return movieServices.getByRating(rating);}


    //Put
    @PutMapping
    @RequestMapping("/updatemovie")
    public ResponseEntity <BasicResponse> updateMovie(@RequestBody UserRequest request,
                                                     @RequestParam String rating){
        BasicResponse response = movieServices.updateMovie(request, rating);
        return ResponseEntity.status(response.getCode()).body(response);
    }


    //post
    @PostMapping
    @RequestMapping("/addmovie")
    public ResponseEntity <BasicResponse> adduser(@RequestBody UserRequest request){
        BasicResponse response = movieServices.addUser(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    //Delete
    @DeleteMapping
    @RequestMapping("/deletemovie")
    public ResponseEntity<BasicResponse> deleteMovie(@RequestParam String rating){
        BasicResponse response = movieServices.deleteMovie(rating);
        return ResponseEntity.status(response.getCode()).body(response);
    }

}
