
public class Deck {
	private int[] myDeck;
	public static final int NUMCARDS=52;
	
	public Deck(){
		myDeck=new int[NUMCARDS];
		for(int i=0;i<NUMCARDS;i++){
			myDeck[i]=i;
		}
	}
	
	public void writeDeck(){
		for(int x:myDeck){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	public void swap(int[] x,int a, int b){
		int temp=x[a];
		x[a]=x[b];
		x[b]=temp;
	}
	
	public void shuffle(){
		int index;
		for(int i=NUMCARDS-1;i>=0;i--){
			index=(int)(Math.random()*52);
			swap(myDeck, i, index);
		}
	}
}
