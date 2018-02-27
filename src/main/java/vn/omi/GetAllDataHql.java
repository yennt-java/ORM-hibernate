package main.java.vn.omi;


import main.java.vn.omi.entity.Item;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GetAllDataHql {
    public static void main(String[] args) throws Exception {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        Transaction tr = session.beginTransaction();

        String hql = "FROM Item";
        Query query = session.createQuery(hql);
        List<Item> items = query.list();


        for (Item item : items) {
            System.out.println("ID: " + item.getId());
            System.out.println("Item Total: " + item.getItem_total());
            System.out.println("Cart: " + item.getCart().getName());
        }


        tr.commit();
        System.out.println("Data printed");
        sessFact.close();
    }
}