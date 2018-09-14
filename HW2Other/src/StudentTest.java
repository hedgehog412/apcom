import chn.util.*;

public class StudentTest {
	public static void main (String[] args)
	{
		int x;
		FileInput apcsIn=new FileInput("APCSList.txt");
		FileOutput apcsList=new FileOutput("APCSListResult.txt");
		Student[] apcs=new Student[15];
		
		for(x=0;x<apcs.length;x++)
			apcs[x]=new Student(apcsIn.readToken(),apcsIn.readInt(),apcsIn.readDouble(),apcsIn.readDouble(),apcsIn.readDouble());

		double sum=0;

		
		for(x=0;x<apcs.length;x++)
		{
			sum+=apcs[x].PrintAverage();
			System.out.println(apcs[x].PrintName()+" "+apcs[x].PrintAge()+" "+apcs[x].PrintHeight()+" "+apcs[x].PrintMiddle()+" "+apcs[x].PrintFinal()+" "+apcs[x].PrintAverage());
		}
		double avg = sum/apcs.length;
		System.out.println("\t\tÀüÃ¼ Æò±Õ : "+avg);

		double standard=0;

		for(x=0;x<apcs.length;x++)
			standard+=(apcs[x].PrintAverage()-avg)*(apcs[x].PrintAverage()-avg);

		System.out.println("\t\tÇ¥ÁØÆíÂ÷ : "+Math.sqrt(standard/apcs.length));

		for(x=0;x<apcs.length;x++)
			apcsList.println(apcs[x].PrintName()+" "+apcs[x].PrintAge()+" "+apcs[x].PrintHeight()+" "+apcs[x].PrintMiddle()+" "+apcs[x].PrintFinal()+" "+apcs[x].PrintAverage());
		apcsList.println("\t\tÀüÃ¼ Æò±Õ : "+avg);
		apcsList.println("\t\tÇ¥ÁØÆíÂ÷ : "+Math.sqrt(standard/apcs.length));
		apcsList.close();


		

	}
}
