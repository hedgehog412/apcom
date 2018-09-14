
public class BirdSanctuary {
	private Bird[] birdList;
	public void allEat(){
		for(Bird b:birdList){
			System.out.println(b.getName()+" eats "+b.getFood());
		}
	}
}
