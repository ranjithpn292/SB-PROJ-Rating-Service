package com.ran.rating.service.Rating.Service.services;

import com.ran.rating.service.Rating.Service.entities.Rating;


import java.util.List;
import java.util.Optional;


public interface RatingService {

    Rating create(Rating rating);


    List<Rating> getRatings();

    Optional<Rating> getById(String Id);

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

    Rating deleteById(String Id);
}
