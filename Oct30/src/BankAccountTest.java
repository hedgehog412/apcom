
public class BankAccountTest {
	public static void main (String[] args)
	{
		BankAccount Jeon=new BankAccount("0412",100.0);
		
		Jeon.deposit("0412", 100.0);
		System.out.println(Jeon.getBalance());
		
		Jeon.withdraw("0412", 150);
		System.out.println(Jeon.getBalance());
		
		Jeon.withdraw("0412",60);
		System.out.println(Jeon.getBalance());
		
	}
}
