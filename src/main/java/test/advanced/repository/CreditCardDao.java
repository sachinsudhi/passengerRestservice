package test.advanced.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import test.advanced.model.CreditCard;
import test.advanced.utils.HibernateUtils;

@Repository
public class CreditCardDao implements ICreditCardDao {
	SessionFactory sf;
	final static Logger logger = Logger.getLogger(CreditCardDao.class);

	public CreditCardDao() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean addCreditCard(CreditCard card) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.save(card);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to execute addCreditCard method", e);
			return false;
		}
		session.close();
		logger.debug("Completed executing CreditCardDao::addCreditCard API");
		return true;
	}

	@Override
	public boolean deleteCreditCard(long cardNumber) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			CreditCard card = (CreditCard) session.load(CreditCard.class, cardNumber);
			session.delete(card);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute deleteCreditCard method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean updateCreditCard(CreditCard card) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			session.update(card);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute updateCreditCard method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public CreditCard loadCreditCard(long cardNumber) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		CreditCard card;
		try {
			card = (CreditCard) session.get(CreditCard.class, cardNumber);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute loadCreditCard method", e);
			return null;
		}
		session.close();
		return card;
	}

}
