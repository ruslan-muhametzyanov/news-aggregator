package services;

import models.Item;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class DBService {

     public void saveInDB(List<Item> list){
        Session session = HibernateUtil.openSession();

        try {
            session.beginTransaction();
            for (Item item: list){
                session.save(item);
            }
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<Item> getListOfItems(){
        List<Item> list = new ArrayList<Item>();
        Session session = HibernateUtil.openSession();

        try {
            session.beginTransaction();
            list = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }

}
