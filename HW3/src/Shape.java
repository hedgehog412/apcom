
public abstract class Shape {
	private String myName;
	public Shape(String name){
		myName=name;
	}
	
	public String getName(){
		return myName;
	}
	
	public abstract double area();
	public abstract double perimeter();

}
