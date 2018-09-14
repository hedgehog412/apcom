
public class Student {
	private String myName, myGrade;
	private int[] myTests;
	private int myID;
	public final static int NUM_TEST=3;
	
	public Student(){
		myName="";
		myGrade="";
		myTests=new int [NUM_TEST];
		myID=0;
	}
	
	public Student(String name, String grade, int[] tests, int id){
		myName=name;
		myGrade=grade;
		myTests=tests;
		myID=id;
	}
	
	//ID하고 학생이 일치하는지 확인
	public boolean checkStudent(int id){
		if(id==myID){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getName(){
		return myName;
	}
	
	public String getGrade(){
		return myGrade;
	}
	
	//getTest_ 는 같은 사람인지 확인할 때 점수가 다르더라도 평균이나 grade가 같을 수 있기 때문에 만들어진 것이다 
	public int getTest1(){
		return myTests[0];
	}
	
	public int getTest2(){
		return myTests[1];
	}
	
	public int getTest3(){
		return myTests[2];
	}
	
	public double getTestAverage(){
		double total=0;
		for(int score:myTests){
			total+=score;
		}
		return total/NUM_TEST;
	}
	
	public void computeGrade(){
		if(myName.equals(""))
		{
			myGrade="NO GRADE";
		}
		else if(getTestAverage()>=65)
		{
			myGrade="PASS";
		}
		else
		{
			myGrade="FAIL";
		}
	}
	
	//이름과 점수가 같으면 같은 사람이라고 생각했다
	public boolean equal(Student a, Student b){
		if(a.getName().equals(b.getName())&&a.getTest1()==b.getTest1()&&a.getTest2()==b.getTest2()&&a.getTest3()==b.getTest3()){
			return true;
		}
		else{
			return false;
		}
	}
}
