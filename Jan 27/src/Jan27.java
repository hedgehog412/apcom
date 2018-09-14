import java.util.*;
public class Jan27 {
	public static void main(String[ ] args)
	{
		List<String> list=new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("bye");
	
		//245 5.
		/*
		Iterator<String> itr=list.iterator();
		String a=itr.next();
		System.out.println(list+"\n"+a);
		itr.remove();
		System.out.println(list);
		a=itr.next();
		itr.remove();
		System.out.println(a+"\n"+list);
		//*/
		
		//2
		/*
		removeTwos(list);
		System.out.println(list);
		//*/
		
		
	}
	public static void removeTwos(List<String> list){
		Iterator<String> itr=list.iterator();
		while(itr.hasNext()){
			if(itr.next().length()==2){
				itr.remove();
			}
		}
	}
	
} 
