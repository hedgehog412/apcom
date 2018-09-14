
public class BankAccount {
	private String myPassword;
	private double myBalance;
	public static final double OVERDRAWN_PENALTY=20.0;
	
	public BankAccount(){//default constructor->can create instance for BankAccount();
		myPassword="";
		myBalance=0.0;
	}
	
	public BankAccount(String password, double balance){
		myPassword=password;
		myBalance=balance;
	}
	
	public double getBalance()
	{
		return myBalance;
	}
	
	public void deposit(String password, double amount)//mutator, modifier
	{
		if(password.equals(myPassword))//필요성은 oct30에
		{
			myBalance+=amount;
		}
		else
		{
			throw new IllegalArgumentException("wrong password");
		}
	}
	
	public void withdraw(String password, double amount)
	{
		if(password.equals(myPassword)){
			myBalance-=amount;
			if(myBalance<0)
			{
				myBalance-=OVERDRAWN_PENALTY;
			}
		}
		else
		{
			throw new IllegalArgumentException("wrong password");
		}
	}
}
