import java.util.*;
public class ArrayListTest{
	public static void main(String[] args){
		List<Integer> list=new ArrayList<Integer>();
		/*
		for(int i=0;i<4;i++){
			list.add(i*i);
		}
		System.out.println(list);
		
		Integer getOb=list.get(2);
		System.out.println(getOb.intValue());
		
		int n=list.get(3);
		System.out.println(n);
		
		Integer x=list.set(3, 5);
		System.out.println(list);
		System.out.println(x);
		
		x=list.remove(2);
		System.out.println(list);
		System.out.println(x);
		
		list.add(1,7);
		System.out.println(list);
		
		list.add(2,8);
		System.out.println(list);
		
		for(Integer num:list){
			System.out.print(num+" ");
		}
		//*/
		
		for(int i=0;i<=10;i++){
			list.add(i);
		}
		
		System.out.println(list);
		
		insert(list, 9);
		
		System.out.println(list);
		
		list=getRandomList();
		
		System.out.println(list);
		
		swap(list,1,4);
		
		System.out.println(list);
		
		printNegs(list);
		
		changeEvenToEmpty(list);
		
		System.out.println(list);
		
	}
	public static void insert(List<Integer> list, Integer value)
	{
		int index=0;
		while(index<list.size()&&value.compareTo(list.get(index))>0){
			index++;
		}
		list.add(index,value);
	}
	public static List<Integer> getRandomList(){
		Scanner sc=new Scanner(System.in);
		System.out.println("How long?");
		int index=sc.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<index;i++){
			list.add((int)(Math.random()*101));
		}
		return list;
	}
	public static <E> void swap(List<E> list,int i, int j){
		E temp=list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
	}
	public static void printNegs(List<Integer> list){
		System.out.print("The negative values are");
		for(Integer a:list){
			if(a.intValue()<0) System.out.print(a+", ");
		}
		System.out.println();
	}
	public static void changeEvenToEmpty(List<Integer> list){
		for(int i=0;i<list.size();i++){
			if(i%2==0) list.set(i,0);
		}
	}
}
