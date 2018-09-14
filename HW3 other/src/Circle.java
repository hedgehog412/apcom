
public class Circle extends shape2D{
	public Circle(String name, double value){
		super(name,value);
	}
	public double perimeter(){
		return super.perimeter()*Math.PI*2;
	}
	
	public double area(){
		return super.area()*Math.PI;
	}

}
