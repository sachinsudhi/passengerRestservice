package test.advanced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CreditCard")
@Data
public class CreditCard {
	@Column(name="profile_id_fk")
	private int profileId;
	
	@Id
	@Column(name="card_number")
	private long cardNumber;
	
	@Column(name="card_type")
	private String cardType;
	
	@Column(name="expiry_month")
	private String expirationMonth;
	
	@Column(name="expiry_year")
	private String expirationYear;
}
