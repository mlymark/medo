
import au.com.w4u.medo.demo.entity.Role;
import au.com.w4u.medo.demo.entity.User;
import au.com.w4u.medo.demo.service.RoleService;
import au.com.w4u.medo.demo.service.UserService;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
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
        Role role = roleService.findRoleByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User entity = new User();
        entity.setUsername("mlymark");
        entity.setPassword("7514470");
        entity.setStatus(1);
        entity.setDescn("I am a user");
        userService.create(entity);
        System.out.println("ID: "+entity.getId());
        
    } 
    
//    @Test
    public void testDeleteUser(){
        User user = userService.findUserByName("mlymark");
        userService.delete(user);
    }
    
    @Test
    public void testFindUsers(){
        User user = userService.findUserByName("admin");
    }
    
    @Test
    public void testRestApi(){
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://192.168.0.181:8088/medo-demo/api/user/list");
        try {
//            SimpleUrlAuthenticationFailureHandler
//LoginUrlAuthenticationEntryPoint
//            String userPassword = "admin:admin";
//            String encoding = "";
//            request.setHeader("Authorization", "Basic " + encoding);
            HttpResponse response = httpclient.execute(request);
            // Check the response: if the body is empty then an error occurred
            System.out.println(response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() != 200){
                throw new Exception("Error: '" + response.getStatusLine().getReasonPhrase() + "' - Code: " +
                        response.getStatusLine().getStatusCode());
            }
            // 获取验证状态
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
