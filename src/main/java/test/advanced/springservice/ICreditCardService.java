package test.advanced.springservice;

import test.advanced.model.CreditCard;

public interface ICreditCardService {
	boolean addCreditCard(CreditCard card);

	boolean deleteCreditCard(long cardNumber);

	boolean updateCreditCard(CreditCard card);

	CreditCard loadCreditCard(long cardNumber);
}
