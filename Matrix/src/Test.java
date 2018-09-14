
import chn.util.*;
public class Test {
	public static void main (String[] args){
		SimpleIO in=new SimpleIO();
		
		System.out.print("Number of rows: ");
		int row=in.readInt();
		System.out.println();
		System.out.print("Number of columns: ");
		int col=in.readInt();
		System.out.println();
		MyMatrix a=new MyMatrix(row,col,"A");
		MyMatrix b=new MyMatrix(row,1,"B");
		MyMatrix x=new MyMatrix(col,1,"Result");
		MyMatrix save=new MyMatrix(row,col,"ASave");
		MyMatrix bSave=new MyMatrix(row,1,"BSave");
		
		//*
		a.initializeRandomly(0,100);
		b.initializeRandomly(0,200);
		//*/
		
		/*
		a.initializeFromConsole();
		b.initializeFromConsole();
		//*/
		
		save=a.saveMatrix();
		bSave=b.saveMatrix();
		
		System.out.println(MyMatrix.toString(a));
		System.out.println(MyMatrix.toString(b));
		//*
		x=a.gebs(b);
		//System.out.println(MyMatrix.toString(a));
		//System.out.println(MyMatrix.toString(x));
		//System.out.println(MyMatrix.toString(bSave));
		System.out.println(MyMatrix.toString(save.multiply(x)));
		x.printResult(save, x, bSave);
		//*/
		
	}
}
