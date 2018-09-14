
public class Image {
	private final int BLACK=1;
	private final int WHITE=0;
	private int[][] image;
	private int size;
	
	public Image(int mySize){
		image=new int[mySize][mySize];
		size=mySize;
	}
	
	public void display(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(image[i][j]);
			}
			System.out.println();
		}
	}
	
	public void eraseBlob(int row, int col){
		if(row>=0&&row<size&&col>=0&&col<size&&image[row][col]==BLACK){//조건 순서 중요함 b/c row>=0이 되어야 [row]가 됨 
			image[row][col]=WHITE;
			System.out.println("["+row+" , "+col+"]");
			eraseBlob(row+1,col);
			eraseBlob(row-1,col);
			eraseBlob(row,col-1);
			eraseBlob(row,col+1);
		}
	}
	
	public static void main(String[] args){
		Image img=new Image(8);
		img.image=new int[][]{
				{0,0,1,0,0,0,0,0},
				{0,1,1,1,1,1,1,0},
				{0,1,0,0,0,0,1,1},
				{0,1,0,1,0,0,1,0},
				{0,1,0,0,0,0,1,0},
				{0,1,1,1,1,1,1,0},
				{1,1,1,1,0,0,1,0},
				{0,0,0,1,1,0,0,0}
				};
		img.display();
		img.eraseBlob(1, 1);
		System.out.println();
		img.display();
	}
}
