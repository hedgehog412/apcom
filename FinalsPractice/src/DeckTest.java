
public class DeckTest {
	public static void main(String[] args){
	Deck a=new Deck();
	a.writeDeck();
	a.shuffle();
	a.writeDeck();
	
	manyDecks d=new manyDecks();
	d.writeAll();
	d.shuffleAll();
	d.writeAll();
	}
}
