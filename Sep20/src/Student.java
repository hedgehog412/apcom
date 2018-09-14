
public class Student //class identifier, 
{	/*
	public String myName;
	public int myAge;
	public float myHeight;
	//*/
	//*
	private String myName;
	private int myAge;
	private float myHeight;
	//access가 불가하다고 나옴 
	//*/
	public Student (String name, int age, float height)
	{
		myName=name;
		myAge=age;
		myHeight=height;
	}//construct가 끝나면 name age height는 jvm에 의해 delocation, but 이미 mN, mA, mH에 copy 해놓음
	//age=19; 이면 그림에서 age에만 19가 들어가 있음 
	//name="Hong ~" 이 들어가면 name은 다른 곳을 가리키고 seo를 출력하 seo~를 출력함 
	public String getName(){
		return myName;
	}
	public int getAge(){
		return myAge;
	}
	public float getHeight(){
		return myHeight;
	}
	public void setAge (int age){
		myAge=age;
	}
	public void setName (String name){
		myName=name;
	}
	public void setHeight (float height){
		myHeight=height;
	}
}
//construct 두개-input parameter가 3개 있는거와 없는 거
//default constructor는 input parameter의 종류와 개수로 구분, 없는게 default
//