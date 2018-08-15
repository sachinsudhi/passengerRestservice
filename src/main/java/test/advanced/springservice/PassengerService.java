package test.advanced.springservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.advanced.model.Passenger;
import test.advanced.repository.IPassengerDao;

@Service
public class PassengerService implements IPassengerService {
	@Autowired
	IPassengerDao pDao;
	
	public PassengerService() {
		super();
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		boolean result = pDao.addPassenger(passenger);
		return result;
	}

	@Override
	public boolean deletePassenger(int profileId) {
		boolean result = pDao.deletePassenger(profileId);
		return result;
	}

	@Override
	public boolean updatePassenger(Passenger passenger) {
		boolean result = pDao.updatePassenger(passenger);
		return result;
	}

	@Override
	public Passenger loadPassenger(int profileId) {
		Passenger passenger = pDao.loadPassenger(profileId);
		return passenger;
	}
}
