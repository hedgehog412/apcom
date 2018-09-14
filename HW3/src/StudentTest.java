import chn.util.*;
public class StudentTest {
	public static void main (String[] args){
		
		SimpleIO in=new SimpleIO();
		FileInput insert=new FileInput("APCS.txt");
		
		int id,count=0,id1,id2;
		int first=0,second=0;
		
		Student[] APCS=new Student[15];
		for(int x=0;x<15;x++){
			APCS[x]=new Student(insert.readToken(),"none", new int[] {insert.readInt(), insert.readInt(), insert.readInt()}, insert.readInt());
		}
		
		for(int x=0;x<15;x++){
			APCS[x].computeGrade();
		}
		
		//리스트 중에서 같은 사람이 없는지 찾는 것
		for(int i=0;i<15;i++){
			for(int j=i+1;j<15;j++){
				if(APCS[i].equal(APCS[i], APCS[j])){
					System.out.println(APCS[i].getName()+" and "+APCS[j].getName()+" are the same student");
				}
			}
		}
		
		//ID를 입력 받아서 점수를 확인 하는 것
		for(;;){
			System.out.println("Insert ID, insert 0 to exit");
			id=in.readInt();
			
			if(id==0){
				break;
			}
			
			for(int x=0;x<15;x++){
				if(APCS[x].checkStudent(id)){
					System.out.println(APCS[x].getName()+" "+APCS[x].getGrade()+"ED");
					break;
				}
				else{
					count++;
				}
			}
			
			if(count==15){
				System.out.println("Wrong ID");
			}
			else{
				break;
			}
		}
		
		//ID 2개를 입력받아서 둘이가 같은 사람인지 확인하는 것
		for(;;){
			System.out.println("Insert first ID, insert 0 to exit");
			id1=in.readInt();
			
			if(id1==0){
				break;
			}
			
			for(int x=0;x<15;x++){
				if(APCS[x].checkStudent(id1)){
					first=x;
					break;
				}
				else{
					count++;
				}
			}
			
			if(count==15){
				System.out.println("Wrong ID");
			}
			else{
				break;
			}
		}
		
		
	
		for(;;){
			System.out.println("Insert second ID, insert 0 to exit");
			id2=in.readInt();
			
			if(id2==0){
				break;
			}
			
			for(int x=0;x<15;x++){
				if(APCS[x].checkStudent(id2)){
					second=x;
					break;
				}
				else{
					count++;
				}
			}
			
			if(count==15){
				System.out.println("Wrong ID");
			}
			else{
				break;
			}
		}
	
	if(first!=0&&second!=0){
	if(APCS[first].equal(APCS[first], APCS[second])){
		System.out.println(APCS[first].getName()+" and "+APCS[second].getName()+" are the same student");
	}
	else{
		System.out.println(APCS[first].getName()+" and "+APCS[second].getName()+" are not the same student");
	}
	}
}
}
