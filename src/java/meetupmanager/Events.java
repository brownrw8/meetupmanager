package meetupmanager;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Events  implements java.io.Serializable {


     private Integer id;
     private EventCategories eventCategories;
     private Users users;
     private String name;
     private BigDecimal latitude;
     private BigDecimal longitude;
     private Boolean isRecurring;
     private Set<Meetups> meetupses = new HashSet<Meetups>(0);

    public Events() {
    }

	
    public Events(EventCategories eventCategories, Users users, String name) {
        this.eventCategories = eventCategories;
        this.users = users;
        this.name = name;
    }
    public Events(EventCategories eventCategories, Users users, String name, BigDecimal latitude, BigDecimal longitude, Boolean isRecurring, Set<Meetups> meetupses) {
       this.eventCategories = eventCategories;
       this.users = users;
       this.name = name;
       this.latitude = latitude;
       this.longitude = longitude;
       this.isRecurring = isRecurring;
       this.meetupses = meetupses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public EventCategories getEventCategories() {
        return this.eventCategories;
    }
    
    public void setEventCategories(EventCategories eventCategories) {
        this.eventCategories = eventCategories;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    public BigDecimal getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    public Boolean getIsRecurring() {
        return this.isRecurring;
    }
    
    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
    }
    public Set<Meetups> getMeetupses() {
        return this.meetupses;
    }
    
    public void setMeetupses(Set<Meetups> meetupses) {
        this.meetupses = meetupses;
    }




}


