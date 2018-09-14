import chn.util.*;
public class Test {
	public static void main (String[] args){
		SimpleIO in=new SimpleIO();
		
		int row=in.readInt();
		int col=in.readInt();
		
		MyMatrix a=new MyMatrix(row,col);
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++)
			{
				System.out.print(a.getValue(i,j)+" ");
			}
			System.out.println();
		}
	}

}
