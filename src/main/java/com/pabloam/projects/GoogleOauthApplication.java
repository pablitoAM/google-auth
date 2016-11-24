package com.pabloam.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@ComponentScan
@SpringBootApplication
public class GoogleOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleOauthApplication.class, args);
    }

    @Component
    @EnableOAuth2Sso
    public static class LoginConfigurer extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers("/", "/login**", "/webjars/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated();

        }
    }
}
