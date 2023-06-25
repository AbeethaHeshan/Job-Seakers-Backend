package lk.creativelabs.jobseekers.security;

import lk.creativelabs.jobseekers.security.filter.CustomAuthonticationFilter;
import lk.creativelabs.jobseekers.security.filter.CustomAuthorizationFilter;
import lk.creativelabs.jobseekers.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private  UserDetailsService userCredentials;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userCredentials).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        CustomAuthonticationFilter customAuthonticationFilter = new CustomAuthonticationFilter(authenticationManagerBean());
        customAuthonticationFilter.setFilterProcessesUrl("/login");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/auth/token/refresh/**").permitAll();

        http.authorizeRequests().antMatchers(POST,"/jobcategories/**").authenticated();

        http.authorizeRequests().antMatchers(POST,"/employee/getemployee/**").authenticated();
        http.authorizeRequests().antMatchers(POST,"/employee/update/**").authenticated();
        http.authorizeRequests().antMatchers(POST,"/employee/delete/**").authenticated();

        http.authorizeRequests().antMatchers(GET,"/client/getclient/**").authenticated();
        http.authorizeRequests().antMatchers(POST,"/client/update/**").authenticated();
        http.authorizeRequests().antMatchers(POST,"/client/delete/**").authenticated();

        http.authorizeRequests().antMatchers(POST,"/advertisement/**").authenticated();
        http.authorizeRequests().antMatchers(GET,"/advertisement/getAll/byClientId").authenticated();
        http.authorizeRequests().antMatchers(GET,"/advertisement/getAll").permitAll();

        http.authorizeRequests().antMatchers(GET,"/jobcategories/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/jobcategories/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/employee/createNew/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/client/createNew/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthonticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return super.authenticationManagerBean();
    }

}
