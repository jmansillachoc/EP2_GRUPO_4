package com.IneappPersonaservice.IneappPersonaservice.Movie.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name ="Movie")
@Table(
        name ="movie",
        uniqueConstraints = {
                @UniqueConstraint(name = "movie_rating_unique", columnNames = "rating")
        }
)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    @Id
    Long id;
    String title;
    String year;
    String gender;
    String director;
    String rating;
}
