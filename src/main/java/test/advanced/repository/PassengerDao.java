package test.advanced.repository;

import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import test.advanced.model.Passenger;
import test.advanced.utils.HibernateUtils;

@Repository
public class PassengerDao implements IPassengerDao {
	SessionFactory sf;
	final static Logger logger = Logger.getLogger(PassengerDao.class);
	public PassengerDao() {
		sf = HibernateUtils.getSessionFactory();
	}
	@Override
	public boolean addPassenger(Passenger passenger) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.save(passenger);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to execute addPassenger method", e);
			return false;
		}
		session.close();
		logger.debug("Completed executing PassengerDao::addPassenger API");
		return true;
	}

	@Override
	public boolean deletePassenger(int profileId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			Passenger passenger = (Passenger) session.load(Passenger.class, profileId);
			session.delete(passenger);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute deletePassenger method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean updatePassenger(Passenger passenger) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			session.update(passenger);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute updatePassenger method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public Passenger loadPassenger(int profileId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		Passenger passenger;
		try {
			passenger = (Passenger) session.get(Passenger.class, profileId);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute loadPassenger method", e);
			return null;
		}
		session.close();
		return passenger;
	}

}
