package test.advanced.springservice;

import test.advanced.model.Passenger;

public interface IPassengerService {
	boolean addPassenger(Passenger passenger);

	boolean deletePassenger(int profileId);

	boolean updatePassenger(Passenger passenger);

	Passenger loadPassenger(int profileId);
}
