
package student;

public class Student {
	private String myName;
	private int myAge;
	private double myHeight;
	private int myMid;
	private int myFin;
//attribute
	public Student(String name, int age, double height, int mid, int fin){
		myName = name;
		myAge = age;
		myHeight = height;
		myMid = mid;
		myFin = fin;
	}
//method
	public void setAge (int age){
		if(age<0) myAge=-age;
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

	public void setMid (int mid){
		if(mid<0) myMid=-mid;
		else if (mid==0) myMid=0;
		else myMid=mid;
	}

	public void setFin (int fin){
		if(fin<0) myFin=-fin;
		else if (fin==0) myFin=0;
		else myFin=fin;
	}

	public String getName(){
		return myName;
	}

	public int getAge(){
		return myAge;
	}

	public double getHeight(){
		return myHeight;
	}

	public int getMid(){
		return myMid;
	}

	public int getFin(){
		return myFin;
	}

	public double getAvg() 
	{
		return (myMid+myFin)/2;
	}
}
