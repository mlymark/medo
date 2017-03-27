/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;




/**
 *
 * @author dell
 */
public class JdbcRequestMapBulider  
    extends JdbcDaoSupport{  
    //查询资源和权限关系的sql语句  
    private String resourceQuery = "";  
      
    public String getResourceQuery() {  
        return resourceQuery;  
    }  
  
    //查询资源  
    public List<Resource> findResources() {  
        ResourceMapping resourceMapping = new ResourceMapping(getDataSource(),  
                resourceQuery);  
        return resourceMapping.execute();  
    }  
      
    //拼接RequestMap  
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap() {  
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();  
          
        List<Resource> resourceList = this.findResources();  
        for (Resource resource : resourceList) {  
            RequestMatcher requestMatcher = this.getRequestMatcher(resource.getUrl());  
            List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();  
            list.add(new SecurityConfig(resource.getRole()));  
            requestMap.put(requestMatcher, list);  
        }  
        return requestMap;  
    }  
    //通过一个字符串地址构建一个AntPathRequestMatcher对象  
    protected RequestMatcher getRequestMatcher(String url) {  
        return new AntPathRequestMatcher(url);  
    }  
  
    public void setResourceQuery(String resourceQuery) {  
        this.resourceQuery = resourceQuery;  
    }  
      
    /** 
     * @classname Resource 
     * @author ZMC 
     * @time 2017-1-10 
     * 资源内部类 
     */  
    private class Resource {  
        private String url;//资源访问的地址  
        private String role;//所需要的权限  
  
        public Resource(String url, String role) {  
            this.url = url;  
            this.role = role;  
        }  
  
        public String getUrl() {  
            return url;  
        }  
  
        public String getRole() {  
            return role;  
        }  
    }  
      
    private class ResourceMapping extends MappingSqlQuery {  
        protected ResourceMapping(DataSource dataSource,  
            String resourceQuery) {  
            super(dataSource, resourceQuery);  
            compile();  
        }  
        //对结果集进行封装处理  
        protected Object mapRow(ResultSet rs, int rownum)  
            throws SQLException {  
            String url = rs.getString(1);  
            String role = rs.getString(2);  
            Resource resource = new Resource(url, role);  
            return resource;  
        }  
    }  
      
}  
