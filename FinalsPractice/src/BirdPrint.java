public abstract class Bird {
	private String myName;
	private String myNoise;
	
	public Bird(String name, String noise){
		myName=name;
		myNoise=noise;
	}
	
	public String getName(){
		return myName;
	}
	
	public String getNoise(){
		return myNoise;
	}
	
	public abstract String getFood();
}

public abstract class Owl extends Bird{
	public Owl(String name){
		super(name, "hoot");
	}
	public abstract String getFood();
}

public class SnowyOwl extends Owl{
	public SnowyOwl(){
		super("SnowyOwl");
	}
	
	public String getFood(){
		int num=(int) (Math.random()*3);
		switch (num){
		case 1:return "hare";
		case 2:return "lemming";
		default:return "small bird";
		}
	}
}

public class BirdSanctuary {
	private Bird[] birdList;
	public void allEat(){
		for(Bird b:birdList){
			System.out.println(b.getName()+" eats "+b.getFood());
		}
	}
}

