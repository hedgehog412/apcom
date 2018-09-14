
public class Sphere extends Circle implements shape3D{
	public Sphere(String name, double radius){
		super(radius,name);
		
	}
	public double surfaceArea(){
		return myRadius*myRadius*4*Math.PI;
	}
	public double volume(){
		return myRadius*myRadius*myRadius*4/3*Math.PI;
	}

}
