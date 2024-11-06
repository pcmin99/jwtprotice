package com.example.jwtprotice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.jwtprotice.dto.CustomUserDetails;
import com.example.jwtprotice.entity.UserEntity;
import com.example.jwtprotice.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {

				//DB에서 조회
                UserEntity userData = userRepository.findByUsername(username);

                if (userData == null) {
                                
                                //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
                    throw new UsernameNotFoundException("User not found");
                }
        
                return new CustomUserDetails(userData);
    }
    



}
