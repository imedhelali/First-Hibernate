package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import contexte.Employer;

public class testhibernate {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		sf.openSession();
		Transaction tx = null;
		Session session = sf.getCurrentSession();
		try {
			tx = session.beginTransaction();
			Employer c1 = new Employer("Romdhani", "Mohamed", 100f);
			session.save(c1);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				sf.close();
			}
		}

	}

}
