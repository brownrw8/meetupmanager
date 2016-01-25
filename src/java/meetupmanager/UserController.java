/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rob
 */
public class UserController extends BaseController {

    public UserController(HttpServletRequest request, HttpServletResponse response){
        super(request,response);
        this.actions = new ArrayList<String>();
        this.actions.add("review");
        this.actions.add("signup");
        this.actions.add("create");
    }
    
    protected void actionReview(){
        response.setContentType("application/json");
        PrintWriter out;
        try {
            out = response.getWriter();
            UserAttendeesHelper attendeesHelper = new UserAttendeesHelper();
            UserAttendees attendee = (UserAttendees)attendeesHelper.fetchByID(Integer.valueOf(request.getParameter("userAttendee")));
            attendee.setComments(request.getParameter("comments"));
            RatingsHelper ratingsHelper = new RatingsHelper();
            attendee.setRatings((Ratings)ratingsHelper.fetchByID(Integer.valueOf(request.getParameter("rating"))));
            if(attendeesHelper.save(attendee)){
                 out.write("{\"result\":\"success\",\"record\":\""+attendee.toString()+"\"}");
            }else{
                 out.write("{\"result\":\"failure\",\"record\":\""+attendee.toString()+"\"}");
            }
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void actionSignup(){
        response.setContentType("application/json");
        PrintWriter out;
        try {
            out = response.getWriter();
            UserAttendees attendee = new UserAttendees();
            attendee.setIsRsvp(Boolean.valueOf(request.getParameter("isRsvp")));
            attendee.setUsers((Users)request.getSession().getAttribute("loggedInUser"));
            MeetupsHelper meetupsHelper = new MeetupsHelper();
            attendee.setMeetups((Meetups)meetupsHelper.fetchByID(Integer.valueOf(request.getParameter("meetup"))));
            UserAttendeesHelper attendeesHelper = new UserAttendeesHelper();
            if(attendeesHelper.save(attendee)){
                 out.write("{\"result\":\"success\",\"record\":\""+attendee.toString()+"\"}");
            }else{
                 out.write("{\"result\":\"failure\",\"record\":\""+attendee.toString()+"\"}");
            }
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void actionCreate(){
        response.setContentType("application/json");
        PrintWriter out;
        try {
            out = response.getWriter();
            Events event = new Events();
            event.setName(String.valueOf(request.getParameter("name")));
            EventCategoriesHelper eventCategoriesHelper = new EventCategoriesHelper();
            event.setEventCategories((EventCategories)eventCategoriesHelper.fetchByID(Integer.valueOf(request.getParameter("eventCategory"))));
            event.setLatitude(new BigDecimal(request.getParameter("latitude")));
            event.setLongitude(new BigDecimal(request.getParameter("longitude")));
            event.setIsRecurring(Boolean.valueOf(request.getParameter("isRecurring")));
            event.setUsers((Users)request.getSession().getAttribute("loggedInUser"));
            EventsHelper eventsHelper = new EventsHelper();
            if(eventsHelper.save(event)){
                Meetups meetup = new Meetups();
                meetup.setEvents(event);
                meetup.setDateAndTime(new Date(request.getParameter("dateAndTime")));
                MeetupsHelper meetupsHelper = new MeetupsHelper();
                if(meetupsHelper.save(meetup)){
                      out.write("{\"result\":\"success\",\"record\":\""+meetup.toString()+"\"}");   
                }else{
                      out.write("{\"result\":\"failure\",\"record\":\""+meetup.toString()+"\"}");
                }
            }else{
                 out.write("{\"result\":\"failure\",\"record\":\""+event.toString()+"\"}");
            }
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    
}
