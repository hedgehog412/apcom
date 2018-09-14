
public class UnderGrad extends Student{
	public UnderGrad(){
		super();
	}
	
	public UnderGrad(String name, int[] tests, String grade){
		super(name, tests, grade);
	}
	
	public void computeGrade(){
		if(getTestAverage()>=70) setGrade("Pass");
		else setGrade("Fail");
	}
}

public class GradStudent extends Student{
	private int myGradID;
	public GradStudent(){
		super();
		myGradID=0;
	}
	
	public GradStudent(String name, int[] test, String grade, int gradID){
		super(name, test, grade);
		myGradID=gradID;
	}
	
	public int getID(){
		return myGradID;
	}
	
	public void computeGrade(){
		super.computeGrade();
		if(getTestAverage()>=90) setGrade("Pass with distiction");
	}
}

