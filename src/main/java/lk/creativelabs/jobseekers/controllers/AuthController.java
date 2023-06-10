package lk.creativelabs.jobseekers.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;
import lk.creativelabs.jobseekers.service.UserCredentialService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("auth")
@CrossOrigin
public class AuthController {


        @Autowired
        UserCredentialService userCredentialService;

      @PostMapping("/token/refresh")
      public void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
          String authorizationHeader = request.getHeader(AUTHORIZATION);
          if(authorizationHeader != null &&  authorizationHeader.startsWith("Bearer ")) {
              try {
                  String token = authorizationHeader.substring("Bearer ".length());
                  Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                  JWTVerifier verifier = JWT.require(algorithm).build();
                  DecodedJWT decodedJWT = verifier.verify(token);
                  String userId = decodedJWT.getSubject();

                  UserCredentialsDTO user = userCredentialService.getUser(userId);
                  log.info("refresh token call ");
                  String access_token  = JWT.create()
                          .withSubject(user.getUserId())
                          .withExpiresAt(new Date(System.currentTimeMillis()+ 10 * 60 * 1000))
                          .withIssuer(request.getRequestURL().toString())
                          .withClaim("roles",user.getRole())   //sometimes  have many roles
                          .sign(algorithm);

                  String refresh_token = JWT.create()
                          .withSubject(user.getUserId())
                          .withExpiresAt(new Date(System.currentTimeMillis()+ 30 * 60 * 1000))
                          .withIssuer(request.getRequestURL().toString())
                          .sign(algorithm);

                  Map<String,String> tokens = new HashMap<>();
                  tokens.put("access_token",access_token);
                  tokens.put("refresh_token",refresh_token);

                  response.setContentType(APPLICATION_JSON_VALUE);
                  new ObjectMapper().writeValue(response.getOutputStream(),tokens);


              } catch (Exception exception) {
                  log.error("Error logging in : {}", exception.getMessage());
                  response.setHeader("error", exception.getMessage());
                  response.setStatus(FORBIDDEN.value());
                  //  response.sendError(FORBIDDEN.value());

                  Map<String, String> error = new HashMap<>();
                  error.put("code","401");
                  error.put("error_message", exception.getMessage());
                  response.setContentType(APPLICATION_JSON_VALUE);
                  new ObjectMapper().writeValue(response.getOutputStream(), error);

                  System.out.println("CCCCCCCCCCCC");
              }
          }else {
              throw new RuntimeException("Refresh token is missing");
          }
      }


      // update username and passwords

      @PostMapping("/update")
      public ResponseUtil updateCredentials(){

                return null;
      }


}
