
public class ColorGrid {
	private String[][] myPixels;
	private int myRows;
	private int myCols;
	
	public ColorGrid(String s,int numRows, int numCols){
		myPixels=new String[numRows][numCols];
		myRows=numRows;
		myCols=numCols;
		int index=0;
		for(int i=0;i<myRows;i++){
			for(int j=0;j<myCols;j++){
				myPixels[i][j]=s.substring(index,index+1);
				index++;
			}
		}
	}
	
	public void paintRegion(int row, int col, String newColor,String oldColor)//oldcolor도 받는거 기억
	{
		if(row>=0&&row<myRows&&col>=0&&col<myCols&&oldColor!=newColor){
			if(!myPixels[row][col].equals(newColor)&&myPixels[row][col].equals(oldColor)){
			myPixels[row][col]=newColor;
			paintRegion(row-1,col,newColor,oldColor);
			paintRegion(row+1,col,newColor,oldColor);
			paintRegion(row,col-1,newColor,oldColor);
			paintRegion(row,col+1,newColor,oldColor);
			}
		}
	}
	
	public void display(){
		for(int i=0;i<myRows;i++){
			for(int j=0;j<myCols;j++){
				System.out.print(myPixels[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args){
		ColorGrid hey=new ColorGrid("rrbgyybrbyrrggrrrbyrryrb",4,6);
		hey.display();
		System.out.println();
		hey.paintRegion(2, 3, "b",hey.myPixels[2][3]);
		hey.display();
	}
}
