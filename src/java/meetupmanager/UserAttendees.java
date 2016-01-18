package meetupmanager;

public class UserAttendees  implements java.io.Serializable {


     private Integer id;
     private Meetups meetups;
     private Ratings ratings;
     private Users users;
     private Boolean isRsvp;
     private String comments;

    public UserAttendees() {
    }

	
    public UserAttendees(Meetups meetups, Users users) {
        this.meetups = meetups;
        this.users = users;
    }
    public UserAttendees(Meetups meetups, Ratings ratings, Users users, Boolean isRsvp, String comments) {
       this.meetups = meetups;
       this.ratings = ratings;
       this.users = users;
       this.isRsvp = isRsvp;
       this.comments = comments;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Meetups getMeetups() {
        return this.meetups;
    }
    
    public void setMeetups(Meetups meetups) {
        this.meetups = meetups;
    }
    public Ratings getRatings() {
        return this.ratings;
    }
    
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Boolean getIsRsvp() {
        return this.isRsvp;
    }
    
    public void setIsRsvp(Boolean isRsvp) {
        this.isRsvp = isRsvp;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }




}


