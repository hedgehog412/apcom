public class Student {
	private String myName;
	private int myAge;
	private double myHeight;
	public String getName(){
		return myName;
	}
	public int getAge(){
		return myAge;
	}
	public double getHeight(){
		return myHeight;
	}
	public void setAge (int age){
		if(age<0) myAge=-age;
		else if (age==0) myAge=0;
		else myAge=age;
	}
	public void setName (String name){
		if(name!=null) myName=name;
		else myName="no name";
	}
	public void setHeight (double height){
		if(height<0) myHeight=height;
		else if(height==0.0) myHeight=0;
		else myHeight=height;
	}
}