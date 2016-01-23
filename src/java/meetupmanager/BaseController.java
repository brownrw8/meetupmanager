/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import serviceMethod.ServiceMethod;





/**
 *
 * @author Rob
 */
public abstract class BaseController {
    protected final HttpServletRequest request;
    protected Map<String, ServiceMethod> actions;
    
    public BaseController(HttpServletRequest request){
        this.request = request;
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
            final Executor serviceMethod = (Executor) actions.get(action);
            if(serviceMethod != null) {
                return true;
            }   
        }
        return false;
    }
    
    public void performAction() {
        String action = request.getParameter("action");
        final ServiceMethod serviceMethod = (ServiceMethod)actions.get(action);
        if(serviceMethod != null) {
            serviceMethod.execute();
        }
    }
}
