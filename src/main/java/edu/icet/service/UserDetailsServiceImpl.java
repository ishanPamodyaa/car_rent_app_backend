package edu.icet.service;

import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return username -> {

            UserDetails userDetails = userRepository.findByEmail(username);
            if (userDetails == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return userDetails;
        };
    }
}
