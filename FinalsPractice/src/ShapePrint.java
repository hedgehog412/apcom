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

public class FindMaxTest {
	public static Comparable max(Comparable a, Comparable b){
		if(a.compareTo(b)>0){
			return a;
		}
		else{
			return b;
		}
	}
	public static void main (String args[]){
		Shape s1=new Circle(3.0,"Circle");
		Shape s2=new Square(4.5,"Square");
		System.out.println("Area of"+s1.getName()+" is "+s1.area());
		System.out.println("Area of"+s2.getName()+" is "+s2.area());
		Shape s3=(Shape) max(s1,s2);
		System.out.println("The larger shape is the "+s3.getName());
	}

}

