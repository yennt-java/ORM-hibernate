package main.java.vn.omi;

import java.util.List;

import main.java.vn.omi.entity.Item;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaQuery;

public class GetAllData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		
		CriteriaQuery<Item> cq = session.getCriteriaBuilder().createQuery(Item.class);
		cq.from(Item.class);
		List<Item> items = session.createQuery(cq).getResultList();

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