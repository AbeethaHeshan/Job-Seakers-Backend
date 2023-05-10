package lk.creativelabs.jobseekers.controllers;

import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;
import lk.creativelabs.jobseekers.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("login")
//public class LoginController {
//
//    @Autowired
//    UserCredentialService userCredentialService;
//
//
//      @PostMapping
//      public void login(@RequestBody UserCredentialsDTO userCredentialsDTO){
//          UserCredentialsDTO userDetails = userCredentialService.getUserDetails(userCredentialsDTO.getUsername(), userCredentialsDTO.getPassword());
//
//          System.out.println(userDetails);;
//
//      }
//
//}
