//11월 13일 수업 내용
import chn.util.*;
public class StudentTest {
	/*
	public static void main (String [] args){
	Student s=null;
	Student u=new UnderGrad("JIhyunJeon", new int[] {98, 96, 97}, "none");
	Student g=new GradStudent ("TaejunKim", new int [] {87, 89, 90}, "none",1234);
	
	System.out.print("Enter Student Status:");
	System.out.println("Grad(G), Undergrad(U), Neither(N)");
	
	SimpleIO in=new SimpleIO();
	String str=in.readToken();
	
	if(str.equals("G")){
		s=g;
	}
	else if(str.equals("U")){
		s=u;
	}
	else{
		s=new Student();
	}
	
	s.computeGrade();
	System.out.println(s.getGrade());
	}
	*/
	
	public static void computeAllGrades(Student[] studentList){
		for(Student s:studentList){
			if(s!=null){
				s.computeGrade();
			}
		}
	}
	
	public static void printAllGrades(Student[] studentList){
		for(Student s:studentList){
			System.out.println(s.getGrade());
		}
	}
	
	public static void main (String[] args){
		Student [] stu=new Student [5];
		stu[0]=new Student ("JihunJeon", new int [] {93,94,90}, "none");
		stu[1]=new Student ("TaejunKim", new int [] {98,97,96}, "none");
		stu[2]=new Student ("SunghoLee", new int [] {98,90,96}, "none");
		computeAllGrades(stu);
		printAllGrades(stu);
		for(Student s:stu){
			System.out.println(s.getGrade());
		}
	}
}
