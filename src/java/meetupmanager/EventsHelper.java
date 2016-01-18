
package meetupmanager;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rob
 */
public class EventsHelper {
    Session session = null;

    public EventsHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List getEvents(int startID, int endID) {
        List<Events> eventsList = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from Events as event where event.id between "+startID+" and "+endID+"");
            System.out.print(q);
            eventsList = (List<Events>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventsList;
    }
    
    
}
