
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
