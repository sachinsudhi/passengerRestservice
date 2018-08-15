package test.advanced.repository;

import test.advanced.model.CreditCard;

public interface ICreditCardDao {
	boolean addCreditCard(CreditCard card);

	boolean deleteCreditCard(long cardNumber);

	boolean updateCreditCard(CreditCard card);

	CreditCard loadCreditCard(long cardNumber);
}
