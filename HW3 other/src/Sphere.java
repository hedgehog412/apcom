
public class Sphere extends shape3D{
	public Sphere(String name, double value){
		super(name,value);
	}
	public double surfaceArea(){
		return super.surfaceArea()*Math.PI*4/3;
	}
	
	public double volume(){
		return super.volume()*Math.PI*4;
	}

}
