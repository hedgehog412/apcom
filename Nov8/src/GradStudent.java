
public class GradStudent extends Student{
	private int myGradID;
	
	public GradStudent(){
		super();
		myGradID=0;
		//super();-->constructor call must be the first statement in the constructor
	}
	
	public GradStudent(String name, int[] tests, String grade, int gradID){
		super(name,tests,grade);
		myGradID=gradID;
	}
	
	public int getID(){
		return myGradID;
	}
	
	public void computeGrade(){
		if(getTestAverage()>=90){
			setGrade("Pass with distinction");
		}
	}
}
