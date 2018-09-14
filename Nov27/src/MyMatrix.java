
public class MyMatrix {
	int myRow, myCol,i,j;
	int [][] myMatrix=new int[myRow][myCol];
	
	public MyMatrix(){
		myRow=10;
		myCol=10;
		myMatrix=new int[myRow][myCol];
		for(i=0;i<myRow;i++){
			for(j=0;j<myRow;j++){
				myMatrix[i][j]=(int) Math.round(Math.random()*myRow*myCol);
			}
		}
	}
	
	public MyMatrix(int row, int col){
		myRow=row;
		myCol=col;
		myMatrix=new int[myRow][myCol];
		for(i=0;i<myRow;i++){
			for(j=0;j<myRow;j++){
				myMatrix[i][j]=(int) Math.round(Math.random()*myRow*myCol);
			}
		}
	}
	
	public int getValue(int row, int col){
		return myMatrix[row][col];
	}
	
	public int getRow(){
		return myRow;
	}
	
	public int getCol(){
		return myCol;
	}
	
	
}
