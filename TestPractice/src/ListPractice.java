import java.util.ArrayList;
import java.util.List;//imports

public class ListPractice {
	public static void main(String[] args){
		List<Integer> list=new ArrayList<Integer>();//generic form
		for(int i=0;i<=3;i++){
			list.add(i*i);
		}
		int n=list.get(2);
		int a=list.set(2, 5);
		int b=list.get(2);
		int c=list.remove(2);
		list.add(2,7);
		list.add(4,10);
		insert(list, 5);
		for(int x:list){
			System.out.print(x+" , ");
		}
		
		//System.out.println("\n"+n+" "+a+" "+b+" "+c);
		
		//System.out.println(list.size());
		
		System.out.println();
		list=getRandomlist(6);
		for(int x:list){
			System.out.print(x+" , ");
		}
		System.out.println();
		swap(list,0,5);
		for(int x:list){
			System.out.print(x+" , ");
		}
		System.out.println();
		list.add(-3);
		list.set(2, -1);
		printNeg(list);
	}
	public static void insert(List<Integer> list,Integer value){//parameter
		int index=0;
		while(index<list.size()&&value.compareTo(list.get(index))>=0){//index<list.size()없으면 에러 가능
			index++;
		}
		list.add(index,value);//순서 주의
	}
	public static List<Integer> getRandomlist(int size){
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			int a=(int) (Math.random()*101);//기억나지?
			result.add(a);
		}
		return result;
	}
	public static void swap(List<Integer> list,int a,int b){//꼭 int가아니라 E로 설정해서 아무 리스트나 가능하게 
		int temp=list.set(a,list.get(b));//그럼 얘도 E로 temp를 설정
		list.set(b, temp);
	}
	public static void printNeg(List<Integer> list){
		for(int a:list){
			if(a<0) System.out.println(a);
		}
	}
}
