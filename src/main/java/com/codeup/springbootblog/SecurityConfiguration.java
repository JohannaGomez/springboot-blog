package com.codeup.springbootblog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private UserDetailsLoader usersLoader;
//
//    public SecurityConfiguration(UserDetailsLoader usersLoader) {
//        this.usersLoader = usersLoader;
//    }
//
    @Bean
    // telling that this object should be built automaticly
    public PasswordEncoder passwordEncoder() {
        //Hashing passwords:
        return new BCryptPasswordEncoder();
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(usersLoader) // How to find users by their username
//                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
//        ;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
        .and()
                .authorizeRequests()
                .antMatchers("/", "/posts") // anyone can see the home and posts page
                .permitAll()
                ;
    }
}
