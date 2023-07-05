package lk.creativelabs.jobseekers.controllers;

import lk.creativelabs.jobseekers.dto.AdvertiesmentDTO;
import lk.creativelabs.jobseekers.service.AdvertiesmentService;
import lk.creativelabs.jobseekers.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("advertisement")
@CrossOrigin
public class JobAdvertisementController {
     @Autowired
     AdvertiesmentService advertiesmentService;

           @PostMapping(value = "/createNew",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public ResponseUtil createAdvertisement(@RequestBody AdvertiesmentDTO advertiesmentDTO,@RequestHeader String userId) throws Exception {
              return  new ResponseUtil(200,"save Success",advertiesmentService.createNewAdvertiesment(advertiesmentDTO,userId));
           }

           @PostMapping(value = "/update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void updateAdvertisement(){

           }

           @PostMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void deleteAdvertisement(){

           }

           @GetMapping (value = "/getAll/byClientId",produces = {MediaType.APPLICATION_JSON_VALUE})
           public ResponseUtil getAllAdvertisementsForUniqueClient(@RequestHeader String userId){
               return  new ResponseUtil(200,"get by client",advertiesmentService.getAllAdvertiesmentsByClientId(userId));
           }

           @GetMapping(value = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
           public ResponseUtil getAllAdvertisements(){
                 return new ResponseUtil(200,"get succes",advertiesmentService.getAllAdvertiesments());
           }

           @PostMapping(value = "/getAll/byCategoryId",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
           public void getAllAdvertisementsByCategoryId(){

           }



}
