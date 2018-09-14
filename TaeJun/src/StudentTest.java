package student;
import chn.util.*;
public class StudentTestTaeJun {
	 //FileInput 사용하기 위해서는 api package를 불러와야 한다. 
		public static void main (String[] args)
		{
			//FileInput과 FileOutput을 선언
			FileInput/*class이름*/ readIn/*변수이름*/ = new FileInput("File.txt"); //이 클래스의 특성상 이 클래스 안의 method의 intput parameter는 file.txt파일에서 받아온다.
			FileOutput/*class 선언*/ printOut/*reference type의 변수 printOut을 선언*/ = new FileOutput("Result.txt");// FileOutput의 모든 메서드와 속성을 메모리에 할당시키는데, 이 메서들은 모두 result.txt파일을 기반으로 작동을 함.
			
			int n = readIn.readInt(); //File.txt에 첫 번째 수(사람 수)를 장수로 읽어내서 int형 변수 n에 저장한다.
			Student[] apcs = new Student[n]; //apcs라는 참조변수를 만들고 student형에 배열 n개를 만들어 apcs 참조변수에 (주소를) 저장한다.

			for(int i=0;i<apcs.length;i++) //아래 내용을 반복한다 : 배열들의 요소를 txt file에 입력한 대로 초기화를 시켜준다(0부터 apcs 배열의 length까지) 
				apcs[i]=new Student(readIn.readToken(),readIn.readInt(),readIn.readDouble(),readIn.readInt(),readIn.readInt());
			
			System.out.println("이름\t나이\t키\t중간\t기말\t평균");

			double sum=0;

			for(int i=0;i<apcs.length;i++) {
				sum+=apcs[i].getAvg();
				System.out.println(apcs[i].getName()+"\t"+apcs[i].getAge()+"\t"+apcs[i].getHeight()+"\t"+apcs[i].getMid()+"\t"+apcs[i].getFin()+"\t"+apcs[i].getAvg());
			}

			double avg=sum/n;
			System.out.println("\t\t\t\t\t\t\t"+avg);

			double stad=0;

			for(int i=0;i<apcs.length;i++)
				stad+=Math.pow(avg-apcs[i].getAvg(),2);
			System.out.println("\t\t\t\t\t\t\t "+Math.sqrt(stad/n));

			for(int i=0;i<apcs.length;i++)
				printOut.println(apcs[i].getName()+"\t"+apcs[i].getAge()+"\t"+apcs[i].getHeight()+"\t"+apcs[i].getMid()+"\t"+apcs[i].getFin()+"\t"+apcs[i].getAvg());
			printOut.println("\t\t\t\t\t"+avg);
			printOut.println("\t\t\t\t\t "+Math.sqrt(stad/n));
			printOut.close();
		}
	}

}


public class StudentTest {

}
