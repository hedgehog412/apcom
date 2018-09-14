
public class UnderGrad extends Student {
	public UnderGrad(){
		super();
	}
	GradStudent hi=new GradStudent();
	public UnderGrad(String name, int [] tests, String grade, GradStudent a){
		super(name,tests,grade);
		hi=a;
	}
	
	public void computeGrade(){
		if (getTestAverage()>=70)
		{
			setGrade("Pass");
		}
		else
		{
			setGrade("Fail");
		}
	}
	
}
