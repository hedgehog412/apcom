
public class Circle extends Shape{
	private double myRadius;
	
	public Circle(double radius, String name){
		super(name);
		myRadius=radius;
	}
	
	public double perimeter(){
		return 2*Math.PI*myRadius;
	}
	
	public double area(){
		return Math.PI*myRadius*myRadius;
	}
	
}
