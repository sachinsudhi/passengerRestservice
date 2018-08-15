package test.advanced.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.advanced.model.Passenger;
import test.advanced.springservice.IPassengerService;

@RestController
@RequestMapping("/Passengers")
public class PassengerController {
@Autowired
IPassengerService service;

@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
public ResponseEntity<Passenger> registerUser(@RequestBody Passenger passenger) {
	boolean res = service.addPassenger(passenger);
	if (res)
		return new ResponseEntity<Passenger>(passenger, HttpStatus.CREATED);
	else
		return new ResponseEntity<Passenger>(passenger, HttpStatus.SERVICE_UNAVAILABLE);
}

@RequestMapping(value = "/delete/{profileId}", method = RequestMethod.DELETE)
public ResponseEntity<Passenger> deleteCustomer(@PathVariable int profileId) {
	boolean res = service.deletePassenger(profileId);
	if (res)
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@RequestMapping(value = "/update", method = RequestMethod.PUT)
public ResponseEntity<Passenger> updateCustomer(@RequestBody Passenger passenger) {
	boolean res = service.updatePassenger(passenger);
	if (res)
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@RequestMapping(value = "/{profileId}", method = RequestMethod.GET)
public ResponseEntity<Passenger> loadCustomer(@PathVariable int profileId) {
	Passenger passenger = service.loadPassenger(profileId);
	return new ResponseEntity<>(passenger, HttpStatus.OK);
}

}
