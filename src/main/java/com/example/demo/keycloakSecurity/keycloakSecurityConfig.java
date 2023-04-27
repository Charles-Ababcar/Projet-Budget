package com.example.demo.keycloakSecurity;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class keycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    // Stratégie de gestion de la sessions
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    // Gérer les utilisateurs et leurs roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(keycloakAuthenticationProvider());
    }
    // Les droits d'accès
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.cors();
        http.authorizeRequests().antMatchers("**").permitAll();//ne neccessite aucune authentification au niveau des services
        http.authorizeRequests().antMatchers("/v3/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
                "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagger-ui.html",
                "/swagger-resources/configuration/security").permitAll(); //Ne necessite aucune authentification
       //http.authorizeRequests().antMatchers("**").authenticated(); // necessite une authentification
        //http.authorizeRequests().antMatchers("/dg_TypeStructure/**").authenticated(); // necessite une authentification
        //http.authorizeRequests().antMatchers("/dg_Drp/**").hasAuthority("DRP"); // necessite le role MANAGER
        //http.authorizeRequests().antMatchers( "dg_TypeStructure/**").hasAnyAuthority("ROLE_DRP");
        //http.authorizeRequests().antMatchers( "**").hasAnyAuthority("ADMIN");
        //http.authorizeRequests().antMatchers(HttpMethod.POST, "**").hasAnyAuthority("ADMIN");
    }
}
