package com.homework.supplychainmgmt.security;

import com.homework.supplychainmgmt.dao.UserRepository;
import com.homework.supplychainmgmt.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = Optional.ofNullable(userRepository.findUserByUsername(username));
        User user = userOpt.orElseThrow(
                () -> new UsernameNotFoundException("Username not found in the database"));
        return new SecurityUser(user);
    }
}
