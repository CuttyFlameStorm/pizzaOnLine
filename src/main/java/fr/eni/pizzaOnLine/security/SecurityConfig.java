package fr.eni.pizzaOnLine.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    public PasswordEncoder PasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance(); // Pour simplifier, n'utilisez pas NoOpPasswordEncoder en production
	        // return new BCryptPasswordEncoder();
	    }
	
//		@Override
	//  protected void configure(HttpSecurity http) throws Exception {
//	      http
//	          .authorizeRequests()
//	              .antMatchers("/", "/commander/**", "/devadmin/**", "/panier/**").permitAll()
//	              .antMatchers("/preparation/**").hasAnyAuthority("Serveur", "Pizzaiolo")
//	              .antMatchers("/carte/**", "/preparation/**").hasAnyAuthority("Gerant")
//	              .anyRequest().authenticated()
//	              .and()
//	          .formLogin()
//	              .loginPage("/login") // URL de la page de connexion personnalisée
//	              .defaultSuccessURL("/secure/home") // Redirection après une connexion réussie
//	              .permitAll() // Autoriser l'accès à la page de connexion
//	              .and()
//	          .logout()
//	              .logoutUrl("/logout")
//	              .permitAll()
//	              .and()
//	          .csrf().disable(); // Désactivez CSRF pour simplifier
	//
//	      // Vous pouvez ajouter d'autres configurations ici, comme la gestion des sessions, etc.
	//  }

	 @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http 
			.authorizeHttpRequests((requests)->requests
					.requestMatchers("/","/commander/**","/panier/**").permitAll()
					.requestMatchers("/preparation/**").hasAnyAuthority("Livreur","Pizzaiolo")
//						.requestMatchers("/carte/**","/preparation/**").hasAnyAuthority("Gerant")
					.anyRequest().hasAnyAuthority("Gerant")
			)
			.formLogin(Customizer.withDefaults())
			.logout((logout)->logout.permitAll());
		
		return http.build();
	}

	
}