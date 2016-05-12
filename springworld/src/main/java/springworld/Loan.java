package springworld;

import org.springframework.stereotype.Component;

@Component
public class Loan {
	
	private String loadId;
	
	private String loanAmount;

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
}
