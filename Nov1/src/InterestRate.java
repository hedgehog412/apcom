import chn.util.*;
public class InterestRate {
	
	public InterestRate()
	{
		
	}
	
	public double getInterestRate()
	{
		SimpleIO hi=new SimpleIO();
		double InterestRate;
		System.out.println("isert interest rate in decimal form");
		InterestRate=hi.readDouble();
		return InterestRate;
	}
}
