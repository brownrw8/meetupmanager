/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rob
 */
public abstract class BaseHelper {
    
    Session session = null;
    protected String tableName = null;
    protected String tableAlias = null;
    
    public BaseHelper() {
        HibernateUtil util = new HibernateUtil();
        this.session = util.getSessionFactory().getCurrentSession();
    }
    
    public List fetchAll() {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List fetchBetween(int minID, int maxID) {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from Events as event where event.id between "+minID+" and "+maxID+"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public IFetchable fetchByID(int ID) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+".id = "+ID+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
    
    public IFetchable fetchByAttribute(String attribute, String value) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+"."+attribute+" = \""+value+"\"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
