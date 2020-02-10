package pro.nikolaev.currencyconverter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pro.nikolaev.currencyconverter.dto.UserRegistrationDto;
import pro.nikolaev.currencyconverter.entities.Person;
import pro.nikolaev.currencyconverter.repositories.PersonRepository;

import java.util.List;

@Service
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with email " + username + " not found!");
        }
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

    public Person save(UserRegistrationDto registrationDto) {
        if (registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            Person user = new Person();
            user.setEmail(registrationDto.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            return personRepository.saveAndFlush(user);
        }
        return null;
    }
}
