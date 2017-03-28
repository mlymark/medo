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
    private List<User> users;
    private User user = new User();//新用户实体
    private Boolean isShow = false; 
    private User userUp = new User();;//更新实体
    
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
        
        user.setStatus(1);
        user.setDescn("不知");
        userService.create(user);
        setup();//刷新
        
    }
    
    public void findUser(){
        Integer userId = Integer.parseInt(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("userId"));
        userUp = userService.findOne(userId);
        isShow = true;
        
    }
    
    public void updateUser(){
        userService.update(userUp);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public User getUserUp() {
        return userUp;
    }

    public void setUserUp(User userUp) {
        this.userUp = userUp;
    }

    
}
