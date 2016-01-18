package meetupmanager;

import java.util.HashSet;
import java.util.Set;


public class Ratings  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String description;
     private Set<UserAttendees> userAttendeeses = new HashSet<UserAttendees>(0);

    public Ratings() {
    }

	
    public Ratings(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Ratings(String name, String description, Set<UserAttendees> userAttendeeses) {
       this.name = name;
       this.description = description;
       this.userAttendeeses = userAttendeeses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<UserAttendees> getUserAttendeeses() {
        return this.userAttendeeses;
    }
    
    public void setUserAttendeeses(Set<UserAttendees> userAttendeeses) {
        this.userAttendeeses = userAttendeeses;
    }




}


