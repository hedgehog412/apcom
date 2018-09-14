import java.util.*;
public class BankAccount {
	private String myPassword;
	private double myBalance;
	public static final double OVERDRAWN_PENALTY=20.0;
	private static double intRate;
	
	public BankAccount(){
		myPassword="";
		myBalance=0.0;
	}
	
	public BankAccount(String password, double balance){
		myPassword=password;
		myBalance=balance;
	}
	
	public double getBalance(){
		return myBalance;
	}
	
	public void deposit(String password, double amount){
		if(password.equals(myPassword)) myBalance+=amount;//equals 기억하기!!!!
		else throw new IllegalArgumentException("Wrong Password");//73p. exception
		
	}
	
	public void withdraw(String password, double amount){
		if(password.equals(myPassword)) {
			myBalance-=amount;
			if(myBalance<0) myBalance-=OVERDRAWN_PENALTY;
		}
		else throw new IllegalArgumentException("Wrong Password");
	}
	
	public static double getInterestRate(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter interest rate for bank account in decimal form");
		intRate=sc.nextDouble();
		return intRate;
	}
	
	public static void chargeFee(BankAccount b, String password, double fee){
		final double MIN_BALANCE=10.0;
		if(b.getBalance()<MIN_BALANCE){
			b.withdraw(password, fee);
		}
	}
	
	public static BankAccount chooseBestAccount(BankAccount b1, BankAccount b2){
		if(b1.getBalance()>b2.getBalance()){
			return b1;
		}
		else{
			return b2;
		}
	}
	
	//내가 걍 한 거임
	public static String toString(BankAccount b,String password){
		if(password.equals(b.myPassword)){
		return "Balance is "+b.getBalance();
		}
		else throw new IllegalArgumentException("Wrong Password");
	}
}
