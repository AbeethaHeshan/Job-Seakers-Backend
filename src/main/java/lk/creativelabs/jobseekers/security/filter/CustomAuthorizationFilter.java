package lk.creativelabs.jobseekers.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// uthorize part
@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          log.info(request.getServletPath());
         if(request.getServletPath().equals("/login") || request.getServletPath().equals("/auth/token/refresh")){
             filterChain.doFilter(request,response);
         }else{
             String authorizationHeader = request.getHeader("Authorization");  //AUTHORIZATION

             System.out.println(authorizationHeader+ " "+ "  vvvvvvvvvv  " );
             if(authorizationHeader != null &&  authorizationHeader.startsWith("Bearer ")){
                 try{
                     String token  = authorizationHeader.substring("Bearer ".length());
                     Algorithm algorithm  = Algorithm.HMAC256("secret".getBytes());
                     JWTVerifier verifier = JWT.require(algorithm).build();
                     DecodedJWT decodedJWT = verifier.verify(token);
                     String userId = decodedJWT.getSubject();
                     System.out.println(decodedJWT + " =  decode jwt ");
                     String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                     System.out.println(Arrays.toString(roles) + "  ROLES ");
                     Collection<SimpleGrantedAuthority> authorities  = new ArrayList<>();
                     stream(roles).forEach(role ->{
                         authorities.add(new SimpleGrantedAuthority(role));
                     });
                     System.out.println(userId + " =  user id ");
                     UsernamePasswordAuthenticationToken authenticationToken  = new UsernamePasswordAuthenticationToken(userId,null,authorities);
                     SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                     filterChain.doFilter(request,response);
                 }catch (Exception exception){
                       log.error("Error logging in : {}",exception.getMessage());
                       response.setHeader("error",exception.getMessage());
                       response.setStatus(FORBIDDEN.value());
                     //  response.sendError(FORBIDDEN.value());

                         Throwable nestedException = exception;
                         while (nestedException.getCause() != null) {
                             nestedException = nestedException.getCause();
                         }
                         String nestedMessage = nestedException.getMessage();


                         Map<String, Object> res = new HashMap<>();

                         Map<String, Object> data = new HashMap<>();
                         data.put("message", nestedMessage);

                         res.put("code", 401);
                         res.put("data", data);

                         response.setContentType(APPLICATION_JSON_VALUE);
                         new ObjectMapper().writeValue(response.getOutputStream(),res);

                 }
             }else{
                   log.warn("do filter");
                  filterChain.doFilter(request,response);
             }
         }
    }
}
