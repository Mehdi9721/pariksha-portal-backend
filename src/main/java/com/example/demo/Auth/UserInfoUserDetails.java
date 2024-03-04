package com.example.demo.Auth;

import com.example.demo.Models.AdminsDataModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {


    private String adminEmail;
    private String adminPassword;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(AdminsDataModel userInfo) {
        adminEmail=userInfo.getAdminEmail();
        adminPassword=userInfo.getAdminPassword();
        authorities= Arrays.stream(userInfo.getAdminRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
     
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return adminPassword;
    }

    @Override
    public String getUsername() {
        return adminEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}