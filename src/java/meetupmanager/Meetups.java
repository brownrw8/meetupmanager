package meetupmanager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Meetups  implements java.io.Serializable {


     private Integer id;
     private Events events;
     private Date dateAndTime;
     private Set<UserAttendees> userAttendeeses = new HashSet<UserAttendees>(0);

    public Meetups() {
    }

	
    public Meetups(Events events, Date dateAndTime) {
        this.events = events;
        this.dateAndTime = dateAndTime;
    }
    public Meetups(Events events, Date dateAndTime, Set<UserAttendees> userAttendeeses) {
       this.events = events;
       this.dateAndTime = dateAndTime;
       this.userAttendeeses = userAttendeeses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Events getEvents() {
        return this.events;
    }
    
    public void setEvents(Events events) {
        this.events = events;
    }
    public Date getDateAndTime() {
        return this.dateAndTime;
    }
    
    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    public Set<UserAttendees> getUserAttendeeses() {
        return this.userAttendeeses;
    }
    
    public void setUserAttendeeses(Set<UserAttendees> userAttendeeses) {
        this.userAttendeeses = userAttendeeses;
    }




}


