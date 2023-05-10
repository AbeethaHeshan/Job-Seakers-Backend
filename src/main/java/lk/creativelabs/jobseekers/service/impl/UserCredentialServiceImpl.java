package lk.creativelabs.jobseekers.service.impl;

import lk.creativelabs.jobseekers.dto.UserCredentialsDTO;
import lk.creativelabs.jobseekers.entity.UserCredentials;
import lk.creativelabs.jobseekers.repo.UserCredentialsRepo;
import lk.creativelabs.jobseekers.service.UserCredentialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


@Service @Transactional
public class UserCredentialServiceImpl implements UserCredentialService , UserDetailsService {

      @Autowired
      UserCredentialsRepo userCredentials;

      @Autowired
      ModelMapper mapper;



      @Override
      public UserCredentialsDTO getUserDetails(String username , String password) {

            return  mapper.map(userCredentials.findAllByUsernameAndPassword(username,password), UserCredentialsDTO.class);
      }


      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserCredentials user = userCredentials.findByUsername(username);
            if(user == null){
                  System.out.println("User not found");
                  throw new UsernameNotFoundException(" This User not found");
            }
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            // we can use for more authorities using for each
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
      }
}
