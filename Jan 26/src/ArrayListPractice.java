import java.util.*;
public class ArrayListPractice {
	//241 p examples
	
	public static void main (String [] args){
		//1.
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<4;i++)
		{
			list.add(i*i);
		}
		
		Integer intOb=list.get(2);
		int n=list.get(3);
		System.out.println(intOb+" "+n+"\n"+list);
		
		intOb=list.set(3, 5);
		System.out.println(intOb+"\n"+list);
		
		intOb=list.remove(2);
		
		list.add(1,7);
		list.add(2,8);
		
		System.out.println(intOb+"\n"+list);
		
		System.out.println("*******************************");
		//2.
		for(Integer num:list){
			System.out.println(num);
			
		}
		System.out.println("*******************************");
		
		//3.
		list=new ArrayList<Integer>();
		
		for(int i=0;i<5;i++){
			list.add(i*i);
		}
		
		System.out.println(list);
		
		insert(list, 17);
		
		System.out.println(list);
		System.out.println("*******************************");
		
		//4.
		System.out.println(getRandomList(10));
		System.out.println("*******************************");
	}
	//3.
	public static void insert(List<Integer> list, Integer num){
		int idx=0;
		while(idx<list.size()&&list.get(idx)<num)
		{
			idx++;
		}
		list.add(idx, num);
	}
	
	//4.
	public static List<Integer> getRandomList(int length){
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<length;i++){
			result.add((int)(Math.random()*101));
		}
		return result;
	}
}
