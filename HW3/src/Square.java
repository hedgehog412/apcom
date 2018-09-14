
public class Square extends Shape {
	double mySide;
	
	public Square(String name, double side){
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
