/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Rob
 */
public class AuthController extends BaseController {

    public AuthController(HttpServletRequest request, HttpServletResponse response){
        super(request,response);
    }
    public boolean isAuthenticated(){
        HttpSession session = request.getSession(false);
        String username = request.getParameter("username");
        String candidate = request.getParameter("password");
        boolean isAuthenticated;
        if(username==null||candidate==null){
            isAuthenticated = false;
            return isAuthenticated;
        }
        UsersHelper helper = new UsersHelper();
        Users user = (Users)helper.fetchByAttribute("username",username);
        if(user==null){
            isAuthenticated = false;
            return isAuthenticated;
        }
        if(!BCrypt.checkpw(candidate, user.getPassword())){
            isAuthenticated = false;
            return isAuthenticated;
        }
        request.getSession().setAttribute("loggedInUser", user);
        if(user.getIsAdmin()){
            request.getSession().setAttribute("loggedInAdmin", user);
        }
        isAuthenticated = true;
        return isAuthenticated;
    }
    
    public boolean isLoggingOut(){
        HttpSession session = request.getSession(false);
        String logout = request.getParameter("logout");
        if(logout!=null){
            if(logout.equals("logout_loggedInUser")){
                Users user = (Users)request.getSession().getAttribute("loggedInUser");
                if(user.getIsAdmin()){
                    request.getSession().setAttribute("loggedInAdmin", null);
                }
                request.getSession().setAttribute("loggedInUser", null);
                return true;
            }
        }
        return false;
    }



}
