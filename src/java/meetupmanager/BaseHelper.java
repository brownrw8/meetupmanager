/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetupmanager;

import java.util.Date;
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
        postProcessTransaction();
        return list;
    }
    
    public List fetchAllByAttribute(String attribute, String value) {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+"."+attribute+" = \""+value+"\"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return list;
    }
    
    public List fetchAllByAttribute(String attribute, Integer value) {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+"."+attribute+" = "+value+"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return list;
    }
    
    public List fetchBetween(String attribute, Integer min, Integer max) {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from Events as event where event."+attribute+" between "+min+" and "+max+"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return list;
    }
    
    public List fetchBetween(String attribute, String min, String max) {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from Events as event where event."+attribute+" between \""+min+"\" and \""+max+"\"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return list;
    }
    
    public List fetchBetween(String attribute, Date min, Date max) {
        List<IFetchable> list = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from Events as event where event."+attribute+" between \""+min+"\" and \""+max+"\"");
            list = (List<IFetchable>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return list;
    }
    
    public IFetchable fetchAfter(String attribute, Date value) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+".id > "+value+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return object;
    }
    
    public IFetchable fetchAfterOrEqual(String attribute, Date value) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+".id >= "+value+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return object;
    }
    
    public IFetchable fetchBefore(String attribute, Date value) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+".id < "+value+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return object;
    }
    
    public IFetchable fetchBeforeOrEqual(String attribute, Date value) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+".id <= "+value+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
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
        postProcessTransaction();
        return object;
    }
    
    public IFetchable fetchByID(Integer ID) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+".id = "+ID+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return object;
    }
    
    public IFetchable fetchByAttribute(String attribute, Integer value) {
        IFetchable object = null;
        try {
            session.getTransaction().begin();
            Query q = session.createQuery ("from "+this.tableName+" as "+this.tableAlias+" where "+this.tableAlias+"."+attribute+" = "+value+"");
            object = (IFetchable) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        postProcessTransaction();
        return object;
    }
    
    public boolean save(IFetchable record){
        try {
            session.getTransaction().begin();
            session.save(record);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    private void postProcessTransaction(){

    }
}
