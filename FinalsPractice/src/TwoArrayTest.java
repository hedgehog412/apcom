import java.util.*;
public class TwoArrayTest {
	public static void main(String[] args){
		int[][] mat=new int[][]{{1,2,3},{4,5,6},{7,-8,9}};
		int sum=0;
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				sum+=mat[i][j];
			}
		}
		System.out.println(sum);
		for(int i=0;i<mat[2].length;i++){
			mat[2][i]+=2;
		}
		System.out.println(countNegs(mat));
		mat=getMatrix(3,3);
	}
	public static int countNegs(int[][] a){
		int count=0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				if(a[i][j]<0) count++;
			}
		}
		return count;
	}
	public static int[][] getMatrix(int row,int col){
		int[][] list=new int[row][col];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				list[i][j]=sc.nextInt();
			}
		}
		return list;
	}
}
