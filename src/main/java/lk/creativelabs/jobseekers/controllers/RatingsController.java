package lk.creativelabs.jobseekers.controllers;

import lk.creativelabs.jobseekers.dto.RatingDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("ratings")
public class RatingsController {

        @PostMapping
        public void creteNewRate(){

        }

}
