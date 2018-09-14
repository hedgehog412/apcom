
public class StudentTest 
{
	public static void main (String [] args){
	Student seo= new Student ("Seo Jae Duck", 17, 180f);//actual input parameter
	//System.out.println(seo.myName+seo.myAge+seo.myHeight);-->access 불가(private일떄) 
	System.out.println(seo.getName());
	}
}
