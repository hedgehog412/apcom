import java.util.Scanner;
import chn.util.*;
import java.util.concurrent.TimeUnit;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner5_final
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args) throws Exception
	{
		FileOutput outcon=new FileOutput("conversation.txt","append");
		Magpie5_final maggie = new Magpie5_final();
		
		Scanner in = new Scanner (System.in);
		String subject = "", verb = "", object = "", 
			   subjectComplement = "",
			   objectComplement = "", 
			   directObject = "", indirectObject = "",
			   preposition = "";
		int count = 0;
		int countNumOfQuestions = 0;
		String newResponse = "";
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   outcon.println("\n***********Conversation started at "+dtf.format(now)+"***********\n");
		   
		System.out.println("Hi! let's talk. Press 0 or say bye if you want to end the conversation. \nAlso, tell me anytime when the question or conversation is strange.");
		outcon.println("Hi! let's talk. Press 0 or say bye if you want to end the conversation. \nAlso, tell me anytime when the question or conversation is strange.");
		
		maggie.init();
		String q=maggie.getRandomQuestion();
		System.out.println(q);
		outcon.println(q);
		String temp=q;

		do
		{
			if(!in.hasNextInt()){
				String input=in.nextLine();
				if(maggie.findKeyword(input.toLowerCase(),"bye")>=0){
					continue;
				}
				else if(maggie.findKeyword(input.toLowerCase(),"yes")>=0){
					System.out.println("I'm glad to hear that.");
					outcon.println("I'm glad to hear that.");
					count++;
					newResponse=maggie.getRandomQuestion();
				}
				else if(maggie.findKeyword(input.toLowerCase(),"no")>=0){
					System.out.println("I'm sorry to hear that.");
					outcon.println("I'm sorry to hear that.");
					count++;
					newResponse=maggie.getRandomQuestion();
				}
				else{
				count++;
				System.out.println("invalid character");
				continue;
				}
			}

			else {
				count = in.nextInt();
				in.nextLine();

			//EXIT IF COUNT IS 0
			if(count == 0) 
				continue;

			//1ST_STATEMENT
			else if (count == 1){
				System.out.println();
				System.out.println("Enter subject: ");
				subject = in.nextLine();

				System.out.println("Enter verb: ");
				verb = in.nextLine();

				System.out.println("Enter preposition: ");
				preposition = in.nextLine();
				
				String sentence = subject.substring(0, 1).toUpperCase() + subject.substring(1) + " " + verb + " " + preposition + ".";
				outcon.println(sentence);
				System.out.println("\n" + sentence);
				newResponse = maggie.transform1st_FormStatement(subject, verb, preposition);
			}

			//2ND_STATEMENT
			else if (count == 2){
				System.out.println();
				System.out.println("Enter subject: ");
				subject = in.nextLine();

				System.out.println("Enter verb: ");
				verb = in.nextLine();

				System.out.println("Enter subject complement: ");
				subjectComplement = in.nextLine();
				
				String sentence = subject.substring(0, 1).toUpperCase() + subject.substring(1) + " " + verb + " " + subjectComplement + ".";
				outcon.println(sentence);
				System.out.println("\n" + sentence);
				newResponse = maggie.transform2nd_FormStatement(temp, subject, verb, subjectComplement);
			}
			
			//3RD_STATEMENT
			else if (count == 3){
				System.out.println();
				System.out.println("Enter subject: ");
				subject = in.nextLine();

				System.out.println("Enter verb: ");
				verb = in.nextLine();

				System.out.println("Enter object: ");
				object = in.nextLine();	
				
				String sentence = subject.substring(0, 1).toUpperCase() + subject.substring(1) + " " + verb + " " + object + ".";
				outcon.println(sentence);
				System.out.println("\n" + sentence);
				newResponse = maggie.transform3rd_FormStatement(subject, verb, object);
			}

			//4RD_STATEMENT
			else if (count == 4){
				System.out.println();
				System.out.println("Enter subject: ");
				subject = in.nextLine();

				System.out.println("Enter verb: ");
				verb = in.nextLine();

				System.out.println("Enter direct object: ");
				directObject = in.nextLine();	

				System.out.println("Enter indirect object: ");
				indirectObject = in.nextLine();	
				
				String sentence = subject.substring(0, 1).toUpperCase() + subject.substring(1) + " " + verb + " " + directObject + " " + indirectObject + ".";
				outcon.println(sentence);
				System.out.println("\n" + sentence);
				newResponse = maggie.transform4th_FormStatement(subject, verb, directObject, indirectObject);
			}
			
			//5TH_STATEMENT
			else if (count == 5){
				System.out.println();
				System.out.println("Enter subject:");
				subject = in.nextLine();

				System.out.println("Enter verb: ");
				verb = in.nextLine();

				System.out.println("Enter object:");
				object = in.nextLine();	
			
				System.out.println("Enter object complement:");
				objectComplement = in.nextLine();
				
				String sentence = subject.substring(0, 1).toUpperCase() + subject.substring(1) + " " + verb + " " + object + " " + objectComplement + ".";
				outcon.println(sentence);
				System.out.println("\n" + sentence);
				newResponse = maggie.transform5th_FormStatement(subject, verb, object, objectComplement);
			}
			}
			System.out.println("\nthinking...");
			TimeUnit.MILLISECONDS.sleep((int)(Math.random()*1000+1500));
			
			if(maggie.findKeyword(newResponse, "Tell me more") >= 0){
				countNumOfQuestions++;
				if(countNumOfQuestions == (int)(Math.random()*3+4)){
					newResponse = "This is getting boring.";
					newResponse=newResponse+maggie.getRandomQuestion();
					countNumOfQuestions = 0;
				}
			}
			
			outcon.println(newResponse);
			System.out.println(newResponse);
			temp=newResponse;
	
		} 
		while(count != 0);
		

		System.out.println("Bye! This was a nice conversation.");
		outcon.println("Bye! This was a nice conversation.\n***********Conversation ended***********\n");
		outcon.close();
	
	}
}
