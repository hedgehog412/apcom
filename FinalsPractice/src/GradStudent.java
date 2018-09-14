
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
