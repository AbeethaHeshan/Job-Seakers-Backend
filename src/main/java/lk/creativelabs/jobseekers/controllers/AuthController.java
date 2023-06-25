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

import org.springframework.web.bind.annotation.*;

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

      @GetMapping("/token/refresh")
      public void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
          String authorizationHeader = request.getHeader("Authorization");
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
                          .withExpiresAt(new Date(System.currentTimeMillis()+ 5 * 60 * 1000))
                          .withIssuer(request.getRequestURL().toString())
                          .withClaim("roles",user.getRole())   //sometimes  have many roles
                          .sign(algorithm);

                  String refresh_token = JWT.create()
                          .withSubject(user.getUserId())
                          .withExpiresAt(new Date(System.currentTimeMillis()+ 50 * 60 * 1000))
                          .withIssuer(request.getRequestURL().toString())
                          .sign(algorithm);




                  Map<String, Object> res = new HashMap<>();

                  Map<String, Object> data = new HashMap<>();
                  data.put("access_token",access_token);
                  data.put("refresh_token",refresh_token);

                  res.put("code", 200);
                  res.put("data", data);

                  response.setContentType(APPLICATION_JSON_VALUE);
                  new ObjectMapper().writeValue(response.getOutputStream(),res);


              } catch (Exception exception) {
                  log.error("Error logging in : {}", exception.getMessage());
                  response.setHeader("error", exception.getMessage());
                  response.setStatus(FORBIDDEN.value());
                  //  response.sendError(FORBIDDEN.value());

                  Map<String, Object> res = new HashMap<>();

                  Map<String, Object> data = new HashMap<>();
                  data.put("message", exception.getMessage());
                  res.put("code", 401);
                  res.put("data", data);

                  response.setContentType(APPLICATION_JSON_VALUE);
                  new ObjectMapper().writeValue(response.getOutputStream(),res);

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
