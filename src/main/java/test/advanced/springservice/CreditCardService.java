package test.advanced.springservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.advanced.model.CreditCard;
import test.advanced.repository.ICreditCardDao;

@Service
public class CreditCardService implements ICreditCardService {
	@Autowired
	ICreditCardDao cDao;

	public CreditCardService() {
		super();
	}

	@Override
	public boolean addCreditCard(CreditCard card) {
		boolean result =cDao.addCreditCard(card);
		return result;
	}

	@Override
	public boolean deleteCreditCard(long cardNumber) {
		boolean result =cDao.deleteCreditCard(cardNumber);
		return result;
	}

	@Override
	public boolean updateCreditCard(CreditCard card) {
		boolean result =cDao.updateCreditCard(card);
		return result;
	}

	@Override
	public CreditCard loadCreditCard(long cardNumber) {
		CreditCard card=cDao.loadCreditCard(cardNumber);
		return card;
	}

}
