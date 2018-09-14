
public class Square extends Shape {
	private double mySide;
	
	public Square(double side, String name){
		super(name);
		mySide=side;
	}
	
	public double perimeter(){
		return 4*mySide;
	}
	
	public double area(){
		return mySide*mySide;
	}
}
