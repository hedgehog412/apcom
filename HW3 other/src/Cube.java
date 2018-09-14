
public class Cube extends shape3D{
	public Cube(String name, double value){
		super(name,value);
	}
	public double surfaceArea(){
		return super.surfaceArea()*6;
	}
	
	public double volume(){
		return super.volume();
	}
}
