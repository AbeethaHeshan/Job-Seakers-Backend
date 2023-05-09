package lk.creativelabs.jobseekers.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("advertisement")
public class JobAdvertisementController {

           @PostMapping(value = "/createNew",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void createAdvertisement(){

           }

           @PostMapping(value = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void updateAdvertisement(){

           }

           @PostMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void deleteAdvertisement(){

           }

           @PostMapping(value = "/getAll/byClientId",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void getAllAdvertisementsForUniqueClient(){

           }

           @GetMapping(value = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
           public void getAllAdvertisements(){

           }

           @PostMapping(value = "/getAll/byCategoryId",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void getAllAdvertisementsByCategoryId(){

           }



}
