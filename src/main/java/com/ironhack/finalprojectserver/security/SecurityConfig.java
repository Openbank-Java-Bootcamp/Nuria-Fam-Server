package com.ironhack.finalprojectserver.security;

import com.ironhack.finalprojectserver.filter.CustomAuthenticationFilter;
import com.ironhack.finalprojectserver.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/auth/login");
        http.csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/auth/login/**").permitAll();
        http.authorizeRequests().antMatchers("/api/auth/signup").permitAll();

        // Everyone can get the restaurants, plate categories, drink categories, plates and drinks
        http.authorizeRequests().antMatchers(GET,"/api/restaurants").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/restaurants/{id}").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/{id}/platecategory").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/plates/{id}").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/plates/category/{id}").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/{id}/drinkcategory").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/drinks/{id}").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/drinks/category/{id}").permitAll();

        // Everyone can get the ratings
        http.authorizeRequests().antMatchers(GET,"/api/{id}/ratings").permitAll();

        // Only the owner can add, update and delete restaurants, plate categories, drink categories, plates, drinks and employees
        http.authorizeRequests().antMatchers(GET,"/api/restaurants/userid/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(POST, "/api/restaurants").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(PUT, "/api/restaurants/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(DELETE, "/api/restaurants/**").hasAnyAuthority("ROLE_OWNER");

        http.authorizeRequests().antMatchers(POST, "/api/platecategory").hasAnyAuthority("ROLE_OWNER");

        http.authorizeRequests().antMatchers(POST, "/api/drinkcategory").hasAnyAuthority("ROLE_OWNER");

        http.authorizeRequests().antMatchers(POST, "/api/plates").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(PUT, "/api/plates/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(DELETE, "/api/plates/**").hasAnyAuthority("ROLE_OWNER");

        http.authorizeRequests().antMatchers(POST, "/api/drinks").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(PUT, "/api/drinks/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(DELETE, "/api/drinks/**").hasAnyAuthority("ROLE_OWNER");


        http.authorizeRequests().antMatchers(GET, "/api/employees/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(GET, "/api/{id}/employees/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(POST, "/api/employees").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(PUT, "/api/employees/**").hasAnyAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(DELETE, "/api/employees/**").hasAnyAuthority("ROLE_OWNER");

        // Users and owners can get, update and delete a user
        http.authorizeRequests().antMatchers(GET, "/api/users/**").hasAnyAuthority("ROLE_OWNER", "ROLE_USER");
        http.authorizeRequests().antMatchers(PUT, "/api/users/**").hasAnyAuthority("ROLE_OWNER", "ROLE_USER");
        http.authorizeRequests().antMatchers(DELETE, "/api/users/**").hasAnyAuthority("ROLE_OWNER", "ROLE_USER");

        // Only users can rate a restaurant
        http.authorizeRequests().antMatchers(POST, "/api/ratings").hasAnyAuthority("ROLE_USER");

        http.authorizeRequests().antMatchers("/", "/csrf", "/v2/api-docs", "/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll();

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
