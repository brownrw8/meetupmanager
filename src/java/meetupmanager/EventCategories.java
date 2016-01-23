package meetupmanager;
// Generated Jan 19, 2016 7:40:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * EventCategories generated by hbm2java
 */
public class EventCategories  implements java.io.Serializable,IFetchable {


     private Integer id;
     private String name;
     private Set<Events> eventses = new HashSet<Events>(0);

    public EventCategories() {
    }

	
    public EventCategories(String name) {
        this.name = name;
    }
    public EventCategories(String name, Set<Events> eventses) {
       this.name = name;
       this.eventses = eventses;
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
    public Set<Events> getEventses() {
        return this.eventses;
    }
    
    public void setEventses(Set<Events> eventses) {
        this.eventses = eventses;
    }




}


