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

           @PostMapping(path = "/employee",consumes = MediaType.APPLICATION_JSON_VALUE , produces ={MediaType.APPLICATION_JSON_VALUE})
           public ArrayList<RatingDTO> getRatingsForEmployeeById(){
                return null;
           }

          @PostMapping(path = "/client",consumes = MediaType.APPLICATION_JSON_VALUE , produces ={MediaType.APPLICATION_JSON_VALUE})
          public ArrayList<RatingDTO> getRatingsForClientById(){
               return null;
          }

          @PostMapping(path = "/forClient/byId",consumes = MediaType.APPLICATION_JSON_VALUE , produces ={MediaType.APPLICATION_JSON_VALUE})
          public ArrayList<RatingDTO> CreateRatingsForClientById(){
            return null;
          }

          @PostMapping(path = "/forEmployee/byId",consumes = MediaType.APPLICATION_JSON_VALUE , produces ={MediaType.APPLICATION_JSON_VALUE})
          public ArrayList<RatingDTO> CreateRatingsForEmployeeById(){
            return null;
          }
}
