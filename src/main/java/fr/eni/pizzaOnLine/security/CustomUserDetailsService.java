package fr.eni.pizzaOnLine.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import fr.eni.pizzaOnLine.dao.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UtilisateurRepository utilisateurRepository;
	
	
	public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        fr.eni.pizzaOnLine.entities.Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
	        if (utilisateur == null) {
	            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
	        }
	        return utilisateur;
	    }
	
}
