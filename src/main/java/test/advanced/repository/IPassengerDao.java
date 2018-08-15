package test.advanced.repository;

import test.advanced.model.Passenger;

public interface IPassengerDao {
	boolean addPassenger(Passenger passenger);

	boolean deletePassenger(int profileId);

	boolean updatePassenger(Passenger passenger);

	Passenger loadPassenger(int profileId);
}
