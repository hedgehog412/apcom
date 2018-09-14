
	import chn.util.*;

	public class Student
	{	
			
			String myName;
			int myAge;
			double myHeight;
			double myScore[]=new double[2];
			float bunsan;
			float wholeAverage;
			boolean lines;
			String test;
			String line;
			public Student(String name, int age, double height, double mid, double fin)
			{
				myName=name;
				myAge=age;
				myHeight=height;
				myScore[0]=mid;
				myScore[1]=fin;
			}
			public String PrintName()
			{
				return myName;
			}
			public int PrintAge()
			{
				return myAge;
			}
			public double PrintHeight()
			{
				return myHeight;
			}
			public double PrintMiddle()
			{
				return myScore[0];
			}
			public double PrintFinal()
			{
				return myScore[1];
			}
			public double PrintAverage()
			{
				return (myScore[0]+myScore[1])/2;
			}
	}
