package springworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	private String SSN;
	
	private String firtName;
	
	private String lastName;
	
	@Autowired
	private Loan myLoan;
	
	@Autowired
	private Address  address;

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getFirtName() {
		return firtName;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Loan getMyLoan() {
		return myLoan;
	}

	public void setMyLoan(Loan myLoan) {
		this.myLoan = myLoan;
	}

	
	
	

}
