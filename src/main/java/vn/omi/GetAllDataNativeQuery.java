package main.java.vn.omi;


import java.util.Iterator;
import java.util.List;

import main.java.vn.omi.entity.Item;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.NativeQuery;

import javax.persistence.criteria.CriteriaQuery;

public class GetAllDataNativeQuery {
    public static void main(String[] args) throws Exception {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();

        List<Item> items = session.createNativeQuery(
                "SELECT * FROM Item", Item.class )
                .getResultList();


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