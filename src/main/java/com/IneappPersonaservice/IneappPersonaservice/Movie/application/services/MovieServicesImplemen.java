package com.IneappPersonaservice.IneappPersonaservice.Movie.application.services;

import com.IneappPersonaservice.IneappPersonaservice.Movie.domain.entity.Movie;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.repository.MovieRepository;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.request.UserRequest;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.BasicResponse;
import com.IneappPersonaservice.IneappPersonaservice.Movie.infraestructura.response.UserResponse;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Builder
@Service
public class MovieServicesImplemen implements MovieServices {

   @Autowired
   private MovieRepository movieRepository;

    @Override
    public BasicResponse addUser(UserRequest request) {

        try {
                movieRepository.save(this.buildPersonFromRequest(request));
                return BasicResponse.whenSuccess();

        }catch (Exception e){
            return BasicResponse.whenError(e.getMessage());
        }
    }

    @Override
    public UserResponse getAll(){
        List<Movie> movieList = movieRepository.findAll();

        if (movieList.isEmpty()){
            return UserResponse.builder()
                    .movieList(null)
                    .basicResponse(BasicResponse.whenNoDataFound("User"))
                    .build();
        }

        return UserResponse.builder()
                .movieList(movieList)
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public UserResponse getByRating(String rating){
        Movie movie = movieRepository.findByrating(rating);

        try {
            if (movie !=null){
                return UserResponse.builder()
                        .movieList(List.of(movie))
                        .build();
            }
            else{
                return UserResponse.builder()
                        .movieList(null)
                        .basicResponse(BasicResponse.whenNoDataFound("Movie"))
                        .build();
            }
        }catch (Exception e) {
            return UserResponse.builder()
                    .movieList(null)
                    .basicResponse(BasicResponse.whenError(e.getMessage()))
                    .build();
        }
    }

    @Transactional
    @Override
    public BasicResponse updateMovie(UserRequest request, String rating){

        try {
            //Validar que exista el usuario que desea modificar
            Movie movie = movieRepository.findByrating(rating);

            if (movie ==null){
                return BasicResponse.whenNoDataFound("Movie con rating " + rating);

            }
            else{

                    movie.setTitle(request.getTitle() != null && !request.getTitle().isBlank() ? request.getTitle() : movie.getTitle());
                    movie.setYear(request.getYear()!= null && !request.getYear().isBlank() ? request.getYear() : movie.getYear());
                    movie.setGender(request.getGender()!= null && !request.getGender().isBlank() ? request.getGender() : movie.getGender());
                    movie.setDirector(request.getDirector()!= null && !request.getDirector().isBlank() ? request.getDirector() : movie.getDirector());
                    movie.setRating(request.getRating()!= null && !request.getRating().isBlank() ? request.getRating() : movie.getRating());

                    return BasicResponse.whenSuccess();
            }

        }catch (Exception e){
            return BasicResponse.whenError(e.getMessage());
        }
    }



    public BasicResponse deleteMovie(String rating){
        try{
            Movie movie = movieRepository.findByrating(rating);

            if(movie == null){
                return BasicResponse.whenNoDataFound("User con rating "+rating);
            }else{
                movieRepository.delete(movie);
                return BasicResponse.whenSuccess();
            }
        }catch (Exception e){
            return BasicResponse.whenError(e.getMessage());
        }
    }


    public Movie buildPersonFromRequest(UserRequest request){
        return Movie.builder()
                .title(request.getTitle())
                .year(request.getYear())
                .gender(request.getGender())
                .director(request.getDirector())
                .rating(request.getRating()).build();
    }
}
