package com.ran.rating.service.Rating.Service.services.impl;

import com.ran.rating.service.Rating.Service.entities.Rating;
import com.ran.rating.service.Rating.Service.respositories.RatingRepository;
import com.ran.rating.service.Rating.Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> getById(String Id) {
        return ratingRepository.findById(Id);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating deleteById(String Id) {
        ratingRepository.deleteById(Id);
        return null;
    }


}
