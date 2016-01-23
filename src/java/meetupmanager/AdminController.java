/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import serviceMethod.ServiceMethod;

/**
 *
 * @author Rob
 */
public class AdminController extends BaseController {

    public AdminController(HttpServletRequest request) {
        super(request);
        actions.put("signUp", new ServiceMethod() {
            public void execute() {
               
            }
        });
    }
    public boolean isAdmin(){
            HttpSession session = request.getSession(false);
            if(session == null || session.getAttribute("loggedInAdmin") == null) {
                return false;
            }
        return true;
    }

}
