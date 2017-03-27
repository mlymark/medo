/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.view;

import au.com.w4u.medo.demo.entity.User;
import au.com.w4u.medo.demo.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author lihui
 */
@ManagedBean(name = "userView")
@ViewScoped
public class UserView implements Serializable {

    // Private Constants
    private String name;
    private String phone;
    private List<User> users;
    private User userOne;
    private Boolean isShow = false; 
    
    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    /**
     * *
     * init news information page
     */
    @PostConstruct
    public void setup() {
        users = userService.findAll();
    }
    
    public void addUser(){
        User user = new User();
        user.setUsername(name);
        user.setPassword(phone);
        userService.create(user);
        setup();//刷新
        
    }
    
    public void findUser(){
        Integer userId = Integer.parseInt(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("userId"));
        userOne = userService.findOne(userId);
        isShow = true;
        
    }
    
    public void updateUser(){
        userService.create(userOne);
        isShow = false;
        setup();//刷新
    }
    
    public void deleteUserById(){
        Integer userId = Integer.parseInt(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("userId"));
        userService.deleteById(userId);
        setup();//刷新
    }
    
    public void closeDidlog(){
        isShow = false;
    }
    
//    public void deleteAllUser(){
//        User user = new User();
//        userService.delete(user);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public User getUserOne() {
        return userOne;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    
}
