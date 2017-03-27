
import au.com.w4u.medo.demo.entity.Role;
import au.com.w4u.medo.demo.entity.User;
import au.com.w4u.medo.demo.service.RoleService;
import au.com.w4u.medo.demo.service.UserService;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mly
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Rollback
public class TestService {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;

    @Before
    public void init(){
        System.out.println("TestService.init()");
    }
    
//    @Test
    public void testAddUser(){
        User entity = new User();
        entity.setUsername("mao longyun4");
        entity.setPassword("7514470");
        Integer id = userService.save(entity);
        User user = userService.findOne(1);
    } 
    
    @Test
    public void testGetUser(){
//        User user = userService.findOne(1);
        User user = userService.findUserByName("admin");
        Iterator<Role> i =user.getRoles().iterator();
        while (i.hasNext()) {
            Role next = i.next();
            System.out.println(next.getName());
        }
        
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    
}
