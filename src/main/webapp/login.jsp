<%-- 
    Document   : login
    Created on : 2017-3-26, 14:59:37
    Author     : dell
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style type="text/css">
            .error{
                color:red;
            }
            .hide{
                display: none;
            }
        </style>
    </head>
    <body>
        <div class="error ${param.error == true ? '' : 'hide'}"> 
            登陆失败<br>  
            ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}  
        </div>  
        <form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" style="width:260px; text-align: center">  
            <fieldset>  
                <legend>登陆</legend>  
                用户： <input type="text" name="username" style="width: 150px;"  
                    value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /><br />  
                密码： <input type="password" name="password" style="width: 150px;" /><br />  
                <input type="checkbox" name="rememberMe" />两周之内不必登陆<br />  
                <input type="submit" value="登陆" /> <input type="reset" value="重置" />  
            </fieldset>  
        </form>
    </body>
</html>
