/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Rob
 */
@WebServlet(name = "AuthServlet", urlPatterns = {"/auth"})
public class AuthServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            boolean isLoggedIn = isLoggedIn(request);
            if(isLoggedIn){
                boolean isLoggingOut = isLoggingOut(request);
                if(isLoggingOut){
                    request.getRequestDispatcher("/auth.jsp").forward(request, response);
                }else{
                    response.sendRedirect("/MeetupManager/user");   
                }
            }else{
                boolean isAuthenticated = isAuthenticated(request);
                if(isAuthenticated){
                    response.sendRedirect("/MeetupManager/user");
                }else{
                    request.getRequestDispatcher("/auth.jsp").forward(request, response);
                }   
            }
        }catch(ServletException | IOException se){
            
        }
    }
    
    private boolean isAuthenticated(HttpServletRequest request){
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
    
    private boolean isLoggingOut(HttpServletRequest request){
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
    
    private boolean isLoggedIn(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("loggedInUser") == null) {
            return false;
        } else {
            return true;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is the Admin Module";
    }// </editor-fold>

}
