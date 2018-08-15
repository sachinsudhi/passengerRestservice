package test.advanced.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Table(name="Passenger")

@Data
public class Passenger {
	@Id
	@GeneratedValue
	@Column(name="profile_id")
	private int profileId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="tel_no")
	private String telNo;
	
	@Email(message="Please enter a valid email ID")
	private String emailId;
	
	@Column(name="Password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="profile_id_fk")
	private List<CreditCard> cards;
	
	public Passenger() {
		super();
	}
	
	public Passenger(String firstName, String lastName) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public Passenger(int profileId,String firstName, String lastName) {
		super();
		this.profileId=profileId;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public Passenger( String firstName, String lastName, String address, String telNo, String emailId, String password) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.telNo=telNo;
		this.emailId=emailId;
		this.password=password;
	}
	
	public Passenger(int profileId, String firstName, String lastName, String address, String telNo, String emailId, String password) {
		super();
		this.profileId=profileId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.telNo=telNo;
		this.emailId=emailId;
		this.password=password;
	}
}
