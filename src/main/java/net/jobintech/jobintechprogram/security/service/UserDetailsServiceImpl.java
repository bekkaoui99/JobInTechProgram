package net.jobintech.jobintechprogram.security.service;


import lombok.RequiredArgsConstructor;
import net.jobintech.jobintechprogram.Models.User;
import net.jobintech.jobintechprogram.Repository.UserRepository;
import net.jobintech.jobintechprogram.security.model.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userByEmail = userRepository.findByEmail(username);
        return userByEmail.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

    }
}
