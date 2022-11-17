package com.ideas2it.universityManagement.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/** User Details loading class
 * @author Parthasarathy elumalai
 * @version 1.0 9-11-2022
 */
@Service
public class UserService implements UserDetailsService {

    /**
     *
     * @param username - Pass a username and password
     * @return UserDetails - return userDetails
     * @throws UsernameNotFoundException - user identity is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin","password",new ArrayList<>());
    }
}
