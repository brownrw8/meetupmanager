
package meetupmanager;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rob
 */
public class UsersHelper {
    Session session = null;

    public UsersHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List getUsers(int startID, int endID) {
        List<Users> usersList = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from Users as user where user.id between "+startID+" and "+endID+"");
            System.out.print(q);
            usersList = (List<Users>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
    
    
}
