
public class manyDecks {
	private Deck[] allDecks;
	public static final int NUMDECKS=10;
	
	public manyDecks(){
		allDecks=new Deck[NUMDECKS];
		for(int i=0;i<NUMDECKS;i++){
			allDecks[i]=new Deck();
		}
	}
	
	public void shuffleAll(){
		for(Deck d:allDecks){
			d.shuffle();
		}
	}
	
	public void writeAll(){
		for(Deck d:allDecks){
			d.writeDeck();
		}
	}
}
