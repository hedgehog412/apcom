
public class Student {
	public static final int NUM_TESTS=3;
	private String myName;
	private int[] myTests;
	private String myGrade;
	
	public Student(){
		myName="";
		myTests=new int [NUM_TESTS];
		myGrade="";
	}
	
	public Student (String name, int[] tests, String grade){
		myName=name;
		myTests=tests;
		myGrade=grade;
	}
	
	public String getName(){
		return myName;
	}
	
	public String getGrade(){
		return myGrade;
	}
	
	public void setGrade(String newGrade){
		myGrade=newGrade;
	}
	
	public void computeGrade(){
		if(myName.equals("")) myGrade="No Grade";
		else if(getTestAverage()>=65) myGrade="Pass";
		else myGrade="Fail";
	}
	
	public double getTestAverage(){
		double total=0;
		for(int score:myTests){
			total+=score;
		}
		return total/NUM_TESTS;
	}
}
