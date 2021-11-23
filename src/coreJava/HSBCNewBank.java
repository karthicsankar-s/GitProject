package coreJava;

public class HSBCNewBank {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HSBCBank bank = new HSBCBank();
		
		bank.authentication();
		bank.carLon();
		bank.debit();
		bank.HouseLoan();
		bank.credit();
		bank.MutualFunds();
		
		System.out.println("***********");
		
		USBankRules rules = new HSBCBank();
		rules.authentication();
		rules.credit();
		rules.debit();
		
		System.out.println("***********");
		
		BrazilBankRules brzrules = new HSBCBank();
		brzrules.MutualFunds();
		
		System.out.println("***********");
		System.out.println(USBankRules.minMoney);
		

	}

}
