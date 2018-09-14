import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;//imports

public class IteratorPractice {
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		list.add("ab");
		list.add("b");
		list.add("ccde");
		list.add("de");
		
		Iterator<String> itr=list.iterator();//generic form
		System.out.println();
		while(itr.hasNext()){
			System.out.print(itr.next()+" , ");
		}
		
		removeTwos(list);
		
		itr=list.iterator();//needs to make new iterator if used before
		System.out.println();
		while(itr.hasNext()){
			System.out.print(itr.next()+" , ");
		}
		
		/*
		System.out.println();
		while(true){
			System.out.print(itr.next());
		}
		//*/
		
		
	}
	public static void removeTwos(List<String> str){
		Iterator<String> itr=str.iterator();//make new iterator
		while(itr.hasNext()){
			if(itr.next().length()==2){
				itr.remove();
			}
		}
	}
}
