
public class Oct30 {
	public static void main (String [] args)
	{
		String str1="test";//문자열 상수라고 부른다 String array constant " "는 상수로 취급
		String str2="test";//메모리에 동일한 놈으로 취급(같은 코드에서)
		String str3=new String("test");//항상 새로 allocate한다 
		System.out.println(str1==str2);//같은 놈을 가리키고 있음 b/c 문자열 상수라서 
		System.out.println(str1==str3);//새로 allocate해서 str3에 assign하는 거임->주소값을 비교하고 있는 거임 but string에서 얘를 비교할 일이 거의 없음 그래서 equal을 비교하는게 합당한 것
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));//identifier안에 들어있는 값이 같은지 다른지를 찾아보고 여기는 equal하다 
		//string, object 등에 equal method가 있음
	}
}
