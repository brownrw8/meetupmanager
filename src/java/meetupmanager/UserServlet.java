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

/**
 *
 * @author Rob
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

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
        UserController controller = new UserController(request,response);
        try {     
            boolean isLoggedIn = controller.isLoggedIn();
            if(isLoggedIn){
                if(controller.isValidAction()){
                    controller.performAction();
                }else{
                    Users user = (Users)request.getSession().getAttribute("loggedInUser");
                    request.setAttribute("user", user);
                    MeetupsHelper meetups = new MeetupsHelper();
                    request.setAttribute("meetups", meetups.fetchAll());
                    RatingsHelper ratings = new RatingsHelper();
                    request.setAttribute("ratings", ratings.fetchAll());
                    EventCategoriesHelper eventCategories = new EventCategoriesHelper();
                    request.setAttribute("eventCategories", eventCategories.fetchAll());
                    UserAttendeesHelper userAttendees = new UserAttendeesHelper();
                    request.setAttribute("userAttendees", userAttendees.fetchAllByAttribute("users",user.getId()));
                    request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
                }
            }else{
                response.sendRedirect("/MeetupManager/auth");
            }
        }catch(ServletException | IOException se){
            
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
        return "Short description";
    }// </editor-fold>

}
