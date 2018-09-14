
public class Cube extends Square implements shape3D{
	public Cube(String name, double side){
		super(name, side);
	}
	
	public double surfaceArea(){
		return 6*mySide*mySide;
	}
	
	public double volume(){
		return mySide*mySide*mySide;
	}

}
