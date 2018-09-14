
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
