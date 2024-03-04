package com.example.demo.Auth;

import com.example.demo.Models.AdminsDataModel;
import com.example.demo.jpaRepositories.AdminsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminsDataRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
        Optional<AdminsDataModel> userInfo = repository.findByAdminEmail(username);
        
        return userInfo.map(UserInfoUserDetails::new)
        		 .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
