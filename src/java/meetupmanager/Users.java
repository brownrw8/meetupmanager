package meetupmanager;

import java.util.HashSet;
import java.util.Set;


public class Users  implements java.io.Serializable {


     private Integer id;
     private String firstname;
     private String lastname;
     private String username;
     private String email;
     private Set<Events> eventses = new HashSet<Events>(0);
     private Set<UserAttendees> userAttendeeses = new HashSet<UserAttendees>(0);

    public Users() {
    }

	
    public Users(String firstname, String lastname, String username, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }
    public Users(String firstname, String lastname, String username, String email, Set<Events> eventses, Set<UserAttendees> userAttendeeses) {
       this.firstname = firstname;
       this.lastname = lastname;
       this.username = username;
       this.email = email;
       this.eventses = eventses;
       this.userAttendeeses = userAttendeeses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Events> getEventses() {
        return this.eventses;
    }
    
    public void setEventses(Set<Events> eventses) {
        this.eventses = eventses;
    }
    public Set<UserAttendees> getUserAttendeeses() {
        return this.userAttendeeses;
    }
    
    public void setUserAttendeeses(Set<UserAttendees> userAttendeeses) {
        this.userAttendeeses = userAttendeeses;
    }




}


