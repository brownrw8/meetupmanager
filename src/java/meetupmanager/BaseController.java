/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






/**
 *
 * @author Rob
 */
public abstract class BaseController {
    protected final HttpServletRequest request;
    protected final HttpServletResponse response;
    protected List<String> actions;
    
    public BaseController(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }
    
    public boolean isLoggedIn(){
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("loggedInUser") == null) {
            return false;
        }
        return true;
    }
    
    public boolean isValidAction() {
        String action = request.getParameter("action");
        if(action!=null){
            if(actions.contains(action)){
                return true;
            }
        }
        return false;
    }
    
    protected Method getDeclaredMethod(String qualifiedAction){
        Method method = null;
        try {
            method = this.getClass().getDeclaredMethod(qualifiedAction);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return method;
    }
    
    public void performAction() {
        String action = request.getParameter("action");
        Method method;
        try {
            method = this.getDeclaredMethod(getFullyQualifiedAction(action));
            method.invoke(this);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getFullyQualifiedAction(String action){
        return "action" + action.substring(0, 1).toUpperCase() + action.substring(1);
    }
    
    
}




