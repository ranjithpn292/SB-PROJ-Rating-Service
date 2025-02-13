package com.ran.rating.service.Rating.Service.controllers;

import com.ran.rating.service.Rating.Service.entities.Rating;
import com.ran.rating.service.Rating.Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


   @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

       String ratingId = UUID.randomUUID().toString();
       rating.setRatingId(ratingId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
       return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Optional<Rating>> getRatingById(@PathVariable String Id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getById(Id));
    }

    @PutMapping("/{Id}")
    public String modifyRating(@PathVariable String Id,@RequestBody Rating newRating){
       List<Rating> ratings = ratingService.getRatings();
       ratings.forEach(rating-> {
           if(rating.getRatingId().equals(Id)){
               rating.setRating(newRating.getRating());
               rating.setHotelId(newRating.getHotelId());
               rating.setUserId(newRating.getUserId());
               rating.setFeedback(newRating.getFeedback());
           }
       });
      return "Rating Modified";
    }

    @DeleteMapping("/{Id}")
    public String modifyRating(@PathVariable String Id){
       Rating ratingToBeDeleted;
        Rating ratings = ratingService.deleteById(Id);
        return "Rating Deleted";
    }

    @GetMapping("/hotelid/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }

    @GetMapping("/userid/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

}
