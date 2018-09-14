import chn.util.*;
public class StudentTest {
	public static void main (String[] args)
	{
		FileInput InputList=new FileInput("APCSList.txt");
		FileOutput apcsList=new FileOutput("APCSListFinal.txt");
		
		Student[] apcs=new Student[15];
		double avgMid,sumMid=0;
		double avgFin,sumFin=0;
		double avgClass,sumClass=0;
		double devMid,devFin=0;
		double devSumMid=0,devSumFin=0;
		double devClass,devSumClass=0;

		for(int x=0;x<apcs.length;x++)
		{
			apcs[x]=new Student(InputList.readToken(), InputList.readInt(), InputList.readDouble(), InputList.readDouble(), InputList.readDouble());
			apcsList.println(apcs[x].getName()+" "+apcs[x].getAge()+" "+apcs[x].getHeight()+" "+apcs[x].getMid()+" "+apcs[x].getFin()+" "+apcs[x].getAvg());
			
		}
		//중간 평균
		for(int x=0;x<apcs.length;x++)
		{
			sumMid+=apcs[x].getMid();
		}
		avgMid=sumMid/apcs.length;
		apcsList.println("중간 평균="+avgMid);
		
		//기말 평균
		for(int x=0;x<apcs.length;x++)
		{
			sumFin+=apcs[x].getFin();
		}
		avgFin=sumFin/apcs.length;
		apcsList.println("기말 평균="+avgFin);
		
		//전체 평균 
		for(int x=0;x<apcs.length;x++)
		{
			sumClass+=apcs[x].getMid()+apcs[x].getFin();
		}
		avgClass=sumClass/apcs.length/2;
		apcsList.println("전체 평균="+avgClass);
		
		//중간 표준편차 
		for(int x=0;x<apcs.length;x++)
		{
		devSumMid+=(apcs[x].getMid()-avgClass)*(apcs[x].getMid()-avgClass);
		}
		devMid=Math.sqrt(devSumClass/apcs.length);
		apcsList.println("중간고사 표준편차="+devMid);
		
		//기말 표준편차
		for(int x=0;x<apcs.length;x++)
		{
		devSumFin+=(apcs[x].getFin()-avgClass)*(apcs[x].getFin()-avgClass);
		}
		devFin=Math.sqrt(devSumClass/apcs.length);
		apcsList.println("기말고사 표준편차="+devFin);
		
		//표준편차
		for(int x=0;x<apcs.length;x++)
		{
		devSumClass+=(apcs[x].getMid()-avgClass)*(apcs[x].getMid()-avgClass)+(apcs[x].getFin()-avgClass)*(apcs[x].getFin()-avgClass);
		}
		devClass=Math.sqrt(devSumClass/apcs.length/2);
		apcsList.println("표준편차="+devClass);
		
		apcsList.close();
}
}
