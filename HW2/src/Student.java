public class Student
{	
		
	private String myName;
	private int myAge;
	private double myHeight;
	private double myScore[]=new double[2];
	
	public Student(String name, int age, double height, double middle, double finals)
	{
		myName=name;
		myAge=age;
		myHeight=height;
		myScore[0]=middle;
		myScore[1]=finals;
	}
	
	public String getName()
	{
		return myName;
	}
	public int getAge()
	{
		return myAge;
	}
	public double getHeight()
	{
		return myHeight;
	}
	public double getMid()
	{
		return myScore[0];
	}
	public double getFin()
	{
		return myScore[1];
	}
	public double getAvg()
	{
		return (myScore[0]+myScore[1])/2;
	}
}
