
public class Square extends shape2D{
	public Square(String name, double value){
		super(name,value);
	}
	public double perimeter(){
		return super.perimeter()*4;
	}
	
	public double area(){
		return super.area();
	}
}
