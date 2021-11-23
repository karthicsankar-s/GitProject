package coreJava;

public class HSBCBank implements USBankRules,BrazilBankRules {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void authentication() {
		System.out.println("Two Factor Authentication implemented");
		
	}

	@Override
	public void credit() {
		System.out.println("Credit is handled by VISA");
		
	}

	@Override
	public void debit() {
		System.out.println("Debit is handled by MasterCard");
		
	}
	
	public void carLon() {
		System.out.println("car loan");
		
	}
	
	public void HouseLoan() {
		System.out.println("HouseLoan");
		
	}

	@Override
	public void MutualFunds() {
		System.out.println("MutualFunds");
		
	}

}
