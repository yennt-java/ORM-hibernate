package main.java.vn.omi;

import main.java.vn.omi.entity.Cart;
import main.java.vn.omi.entity.Item;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class CreateData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		Cart cart = new Cart();
		cart.setName("Cart123");
		session.save(cart);

		Item item = new Item();
		item.setItem_total("123");
		item.setQuantity("321");
		item.setItemId("Item123");
		item.setCart(cart);
		session.save(item);

		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}

}