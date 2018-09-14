import java.util.*;
import chn.util.*;
public class GetListTest {
	static SimpleIO in=new SimpleIO();
	public static List<Integer> getList()
	{
		List<Integer> a=new ArrayList<Integer>(); //(Arrays.asList(in.readInt(), in.readInt(),in.readInt()));//내가 검색해서 찾은 list작성 방법
		a.add(1);
		a.add(2);
		a.add(3);
		return a;
	}

	public static void writeList(List<Integer> a)
	{
		System.out.println(a);
	}
	
	public static void main (String[] args)
	{
		List<Integer> list=getList();
		writeList (list);
	}
}
