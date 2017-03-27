/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.security;

import au.com.w4u.medo.demo.entity.Role;
import au.com.w4u.medo.demo.entity.User;
import au.com.w4u.medo.demo.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author dell
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired  
    private UserService userService; 
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户信息  
        User user = userService.findUserByName(username);  
        if (user != null) {  
            List<String> roleArr= new ArrayList<>();
            for(Role role : user.getRoles()){
                roleArr.add(role.getName());
            }
            // 设置角色  
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),  
                    AuthorityUtils.createAuthorityList((String[]) roleArr.toArray()));  
        }  
  
        throw new UsernameNotFoundException("User '" + username  
                    + "' not found.");  
    }
    
}
