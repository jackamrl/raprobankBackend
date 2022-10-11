package com.mycompany.raprobank.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        try {
            authenticationManagerBuilder.inMemoryAuthentication().withUser("user")
                    .password("{noop}codedean.vn").roles("USER").and().withUser("admin")
                    .password("{noop}codedean.vn)").roles("ADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                .antMatchers("/users").hasRole("USER")
                .antMatchers("/api/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.cors().and().csrf().disable();
    }

}
